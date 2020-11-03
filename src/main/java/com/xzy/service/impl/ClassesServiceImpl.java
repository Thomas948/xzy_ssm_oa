package com.xzy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzy.dto.Page;
import com.xzy.entity.Classes;
import com.xzy.mapper.ClassesMapper;
import com.xzy.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/29
 * @time: 20:41
 * @description:
 */
@Transactional(rollbackFor = {RuntimeException.class, Error.class})
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public void addClass(Classes classes) {
        classesMapper.addClass(classes);
    }

    @Override
    public void updateClass(Classes classes) {
        classesMapper.updateClass(classes);
    }

    @Override
    public void deleteClassByClassId(Integer classId) {
        classesMapper.deleteClassByClassId(classId);
    }

    @Override
    public Classes getClassByClassId(Integer classId) {
        return classesMapper.getClassByClassId(classId);
    }

    @Override
    public List<Classes> getClassList() {
        return classesMapper.getClassList();
    }

    @Override
    public Page getClassesPage(int pageNum, int pageSize) {
        Page page = new Page();
        PageHelper.startPage(pageNum, pageSize);
        List<Classes> classList = classesMapper.getClassList();
        PageInfo<Classes> pageInfo = new PageInfo<>(classList);
        page.setPageSize(pageInfo.getPageSize());
        page.setPages(pageInfo.getPages());
        page.setPageNum(pageInfo.getPageNum());
        page.setHasNext(pageInfo.isHasNextPage());
        page.setHasPre(pageInfo.isHasPreviousPage());
        page.setObj(pageInfo.getList());
        return page;
    }
}
