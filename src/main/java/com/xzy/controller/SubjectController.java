package com.xzy.controller;

import com.alibaba.excel.EasyExcel;
import com.xzy.dto.Page;
import com.xzy.dto.SubjectExcel;
import com.xzy.entity.Subject;
import com.xzy.entity.SubjectType;
import com.xzy.service.SubjectService;
import com.xzy.service.SubjectTypeService;
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
 * @time: 9:57
 * @description:
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectTypeService subjectTypeService;

    @RequestMapping("/delete/{subjectId}")
    public String deleteSubject(@PathVariable("subjectId") Integer subjectId) {
        subjectService.deleteSubjectBySubjectId(subjectId);
        return "redirect:/subject/toList";
    }

    @RequestMapping("/update")
    public String updateSubject(Subject subject) {
        subjectService.updateSubject(subject);
        return "redirect:/subject/toList";
    }

    @RequestMapping("/toUpdate/{subjectId}")
    public String toUpdateSubject(@PathVariable("subjectId") Integer subjectId, Model model) {
        Subject subject = subjectService.getSubjectBySubjectId(subjectId);
        model.addAttribute("subject", subject);
        List<SubjectType> subjectTypes = subjectTypeService.getSubjectTypes();
        model.addAttribute("subjectTypes", subjectTypes);
        return "subject_update";
    }

    @RequestMapping("/add")
    public String addSubject(Subject subject) {
        subjectService.addSubject(subject);
        return "redirect:/subject/toList";
    }

    @RequestMapping("/toAdd")
    public String toAddSubject(Model model) {
        List<SubjectType> subjectTypes = subjectTypeService.getSubjectTypes();
        model.addAttribute("subjectTypes", subjectTypes);
        return "subject_add";
    }

    @RequestMapping("/download")
    public void downloadSubjects(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("subjects", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        List<SubjectExcel> data = new ArrayList<>();
        List<Subject> subjects = subjectService.getSubjectList();

        for (Subject s : subjects) {
            SubjectExcel sel = new SubjectExcel();

            sel.setSubjectType(s.getSubjectType().getSubjectTypeName());
            sel.setSubjectName(s.getSubjectName());
            sel.setSubjectLife(s.getSubjectLife());
            sel.setSubjectId(s.getSubjectId());
            sel.setCreateTime(s.getCreateTime());

            data.add(sel);
        }
        EasyExcel.write(response.getOutputStream(), SubjectExcel.class).sheet("学科信息").doWrite(data);

    }

    @ResponseBody
    @RequestMapping("/getPage")
    public Page getSubjectPage(int pageNum, int pageSize) {
        return subjectService.getSubjects(pageNum, pageSize);
    }

    @RequestMapping("/toList")
    public String toSubjectList() {
        return "subject_list";
    }
}
