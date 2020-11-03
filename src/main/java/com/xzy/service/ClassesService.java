package com.xzy.service;

import com.xzy.dto.Page;
import com.xzy.entity.Classes;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:40
 * @description:
 */
public interface ClassesService {

    void addClass(Classes classes);

    void updateClass(Classes classes);

    void deleteClassByClassId(Integer classId);

    Classes getClassByClassId(Integer classId);

    List<Classes> getClassList();

    Page getClassesPage(int pageNum, int pageSize);
}
