package com.xzy.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Thomas_xiao
 * @date: 2020/10/31
 * @time: 9:44
 * @description:
 */
@Data
public class User implements Serializable {

    private String email;
    private String password;
    private String captcha;
    private String rm;

}
