package com.beauhou.authentication.eo;

import lombok.Data;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/3 0003 21:40
 */
@Data
public class T_USER {
    private Integer id;

    private String username;

    private String password;

    private String moble_phone;
}
