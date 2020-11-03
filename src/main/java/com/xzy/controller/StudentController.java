package com.xzy.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xzy.dto.Page;
import com.xzy.dto.StudentExcel;
import com.xzy.dto.StudentExcel2;
import com.xzy.entity.Classes;
import com.xzy.entity.Education;
import com.xzy.entity.Employee;
import com.xzy.entity.Student;
import com.xzy.service.ClassesService;
import com.xzy.service.EducationService;
import com.xzy.service.EmployeeService;
import com.xzy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/30
 * @time: 7:51
 * @description:
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassesService classesService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Integer studentId) {
        studentService.deleteStudentByStudentId(studentId);
        return "redirect:/student/toList";
    }

    @RequestMapping("/update")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/student/toList";
    }

    @RequestMapping("/toUpdate/{studentId}")
    public String toUpdateStudent(@PathVariable("studentId") Integer studentId, Model model) {
        Student student = studentService.getStudentByStudentId(studentId);
        List<Classes> classList = classesService.getClassList();
        List<Education> educationList = educationService.getEducationList();
        model.addAttribute("classList", classList);
        model.addAttribute("educationList", educationList);
        List<Employee> employees = employeeService.getEmployeeList();
        model.addAttribute("employees", employees);
        model.addAttribute("student", student);
        return "student_update";
    }

    @RequestMapping("/add")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "redirect:/student/toList";
    }

    @RequestMapping("/toAdd")
    public String toAddStudent(Model model) {
        List<Classes> classList = classesService.getClassList();
        model.addAttribute("classList", classList);
        List<Education> educationList = educationService.getEducationList();
        model.addAttribute("educationList", educationList);
        List<Employee> employees = employeeService.getEmployeeList();
        model.addAttribute("employees", employees);
        return "student_add";
    }

    @RequestMapping("/import")
    public String importStudent(@RequestParam("file") MultipartFile excelFile) throws IOException {

        EasyExcel.read(excelFile.getInputStream(), StudentExcel2.class, new AnalysisEventListener<StudentExcel2>() {

            @Override
            public void invoke(StudentExcel2 data, AnalysisContext context) {
                Student student = new Student();
                student.setTeacher(new Employee(data.getTeacher()));
                student.setStuQq(data.getStuQq());
                student.setStuPhone(data.getStuPhone());
                student.setStuGender(data.getStuGender());
                student.setStuEmail(data.getStuEmail());
                student.setStudentName(data.getStudentName());
                student.setInTime(data.getInTime());
                student.setGraduateSchool(data.getGraduateSchool());
                student.setEducation(new Education(data.getEducation()));
                student.setCreateTime(data.getCreateTime());
                student.setClasses(new Classes(data.getClassId()));
                student.setCardNum(data.getCardNum());
                studentService.addStudent(student);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("导入完毕");
            }
        }).sheet().doRead();
        return "redirect:/student/toList";
    }

    @RequestMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("学生信息导入模板", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<StudentExcel2> data = new ArrayList<>();

        EasyExcel.write(response.getOutputStream(), StudentExcel2.class).sheet("学员信息").doWrite(data);
    }

    @RequestMapping("/download")
    public void downLoadStudents(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("students", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<StudentExcel> data = new ArrayList<>();
        List<Student> students = studentService.getStudentList();

        for (Student student : students) {
            StudentExcel sel = new StudentExcel();
            sel.setStudentId(student.getStudentId());
            sel.setStudentName(student.getStudentName());
            sel.setClassName(student.getClasses().getClassName());
            sel.setStuGender(student.getStuGender());
            sel.setStuPhone(student.getStuPhone());
            sel.setStuEmail(student.getStuEmail());
            sel.setStuQq(student.getStuQq());
            sel.setCardNum(student.getCardNum());
            sel.setTeacher(student.getTeacher().getEmpName());
            sel.setGraduateSchool(student.getGraduateSchool());
            sel.setEducation(student.getEducation().getEducationName());
            sel.setCreateTime(student.getCreateTime());
            sel.setInTime(student.getInTime());

            data.add(sel);
        }

        EasyExcel.write(response.getOutputStream(), StudentExcel.class).sheet("学员信息").doWrite(data);
    }

    @RequestMapping("/toImport")
    public String toStudentImport() {
        return "student_import";
    }

    @ResponseBody
    @RequestMapping("/getPage")
    public Page getStudentPage(int pageNum, int pageSize) {
        return studentService.getStudents(pageNum, pageSize);
    }

    @RequestMapping("/toList")
    public String toStudentList() {
        return "student_list";
    }
}
