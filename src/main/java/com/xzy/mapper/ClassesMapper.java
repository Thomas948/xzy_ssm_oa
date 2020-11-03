package com.xzy.mapper;

import com.xzy.entity.Classes;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:27
 * @description:
 */
public interface ClassesMapper {

    void addClass(Classes classes);

    void updateClass(Classes classes);

    void deleteClassByClassId(Integer classId);

    Classes getClassByClassId(Integer classId);

    List<Classes> getClassList();
}
