package com.xzy.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.xzy.entity.Employee;
import com.xzy.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/31
 * @time: 9:16
 * @description:
 */
@Controller
public class UserController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/logout")
    private String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }


    @RequestMapping("/updatePwd")
    public String updatePwd(Employee employee, Model model, HttpSession session) {
        employeeService.updateEmployee(employee);
        Employee emp = employeeService.getEmployeeByEmpId(employee.getEmpId());
        model.addAttribute("msg", "修改成功");
        session.setAttribute("current", emp);
        return "user_pwd";
    }

    @RequestMapping("/toUpdatePwd")
    public String toUpdatePwd(HttpSession session) {
        Object current = session.getAttribute("current");
        if (current instanceof Employee) {
            return "user_pwd";
        } else {
            return "login";
        }
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(Employee employee, Model model, HttpSession session) {
        employeeService.updateEmployee(employee);
        Employee emp = employeeService.getEmployeeByEmpId(employee.getEmpId());
        session.setAttribute("current", emp);
        model.addAttribute("msg", "修改成功");
        return "user_info";
    }

    @RequestMapping("/toUpdateInfo")
    public String toUpdateInfo(HttpSession session) {
        Object current = session.getAttribute("current");
        if (current instanceof Employee) {
            return "user_info";
        } else {
            return "login";
        }
    }


    @RequestMapping("/login")
    public String login(Employee emp,String captcha,String rm, Model model, HttpSession session) {
        String c = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (captcha != null && captcha.equalsIgnoreCase(c)) {
            //获取当前用户的实体
            Subject subject = SecurityUtils.getSubject();
            //封装用户名和密码
            UsernamePasswordToken token = new UsernamePasswordToken(emp.getEmail(), emp.getEmpPassword());
            token.setRememberMe("1".equals(rm));
            try {
                subject.login(token);
                Employee employee = employeeService.getEmployeeByEmail(emp.getEmail());
                session.setAttribute("current", employee);
                session.setAttribute("name", employee.getEmpName());
            } catch (UnknownAccountException uae) {
                System.out.println("用户名不存在:" + uae.getMessage());
            } catch (IncorrectCredentialsException ice) {
                System.out.println("密码错误:" + ice.getMessage());
            } catch (LockedAccountException lae) {
                System.out.println("用户被锁定:" + lae.getMessage());
            } catch (AuthenticationException ae) {
                System.out.println("其他异常:" + ae.getMessage());
                model.addAttribute("msg", "用户名或密码错误");
                return "login";
            }
            return "index";

        } else {
            model.addAttribute("msg", "验证码错误");
            return "login";
        }
    }

    @RequestMapping("/toMain")
    public String toMain() {
        return "index";
    }

    @RequestMapping("/verifyCode")
    public void createCaptcha(HttpServletResponse response, HttpSession session) {
        try {
            //创建验证码核心对象
            DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
            Properties properties = new Properties();
            properties.setProperty("kaptcha.textproducer.char.length", "4");
            Config config = new Config(properties);
            defaultKaptcha.setConfig(config);

            //设置响应头
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");

            String kaptchaText = defaultKaptcha.createText();
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, kaptchaText);
            BufferedImage image = defaultKaptcha.createImage(kaptchaText);
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("/imageUpload")
    public Map<String, String> imageUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename();
        long millis = System.currentTimeMillis();
        filename = "icon-" + millis + "-" + filename;
        String path = request.getServletContext().getRealPath("/images/users");
        file.transferTo(new File(path + "/" + filename));
        String source = "/images/users/" + filename;
        Map<String, String> map = new HashMap<>(8);
        map.put("data", source);
        return map;
    }
}
