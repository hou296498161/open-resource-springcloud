package com.beauhou.authentication.eo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/3 0003 21:40
 */
@Data
@TableName("t_user")
public class T_USER {
    private Integer id;

    private String username;

    private String password;

}
