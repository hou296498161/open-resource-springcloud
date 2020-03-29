package com.beauhou.cache.eo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/27 0027 13:17
 */
@Data
public class UserEntity implements Serializable {
    private Long id;
    private String guid;
    private String name;
    private String age;
    private Date createTime;
}
