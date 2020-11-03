package com.xzy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: Thomas_xiao
 * @date: 2020/11/3
 * @time: 10:56
 * @description:
 */
@ControllerAdvice
public class CommonExceptionHandle {

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView exceptionHandle(Exception e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("fault_500");
        return mv;
    }
}
