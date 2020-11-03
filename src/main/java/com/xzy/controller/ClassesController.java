package com.xzy.controller;

import com.alibaba.excel.EasyExcel;
import com.xzy.dto.ClassesExcel;
import com.xzy.dto.Page;
import com.xzy.entity.Classes;
import com.xzy.entity.Subject;
import com.xzy.service.ClassesService;
import com.xzy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 9:46
 * @description:
 */
@Controller
@RequestMapping("/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/delete/{classId}")
    public String deleteClasses(@PathVariable("classId") Integer classId) {
        classesService.deleteClassByClassId(classId);
        return "redirect:/classes/toList";
    }

    @RequestMapping("/update")
    public String updateClasses(Classes classes) {
        classesService.updateClass(classes);
        return "redirect:/classes/toList";
    }

    @RequestMapping("/toUpdate/{classId}")
    public String toUpdateClasses(@PathVariable("classId") Integer classId, Model model) {
        Classes classes = classesService.getClassByClassId(classId);
        model.addAttribute("classes", classes);
        List<Subject> subjects = subjectService.getSubjectList();
        model.addAttribute("subjects", subjects);
        return "class_update";
    }

    @RequestMapping("/add")
    public String addClasses(Classes classes) {
        classesService.addClass(classes);
        return "redirect:/classes/toList";
    }

    @RequestMapping("/toAdd")
    public String toAddClasses(Model model) {
        List<Subject> subjects = subjectService.getSubjectList();
        model.addAttribute("subjects", subjects);
        return "class_add";
    }

    @RequestMapping("/download")
    public void downloadClasses(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("classes", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<ClassesExcel> data = new ArrayList<>();
        List<Classes> classList = classesService.getClassList();

        for (Classes c : classList) {
            ClassesExcel cel = new ClassesExcel();

            cel.setSubject(c.getSubject().getSubjectName());
            cel.setCreateTime(c.getCreateTime());
            cel.setClassName(c.getClassName());
            cel.setClassLife(c.getClassLife());
            cel.setClassId(c.getClassId());
            cel.setClassCount(c.getClassCount());
            cel.setClassAddress(c.getClassAddress());

            data.add(cel);
        }
        EasyExcel.write(response.getOutputStream(), ClassesExcel.class).sheet("班级信息").doWrite(data);

    }

    @ResponseBody
    @RequestMapping("/getPage")
    public Page getClassesPage(int pageNum, int pageSize) {
        return classesService.getClassesPage(pageNum, pageSize);
    }

    @RequestMapping("/toList")
    public String toClassList() {
        return "class_list";
    }
}
