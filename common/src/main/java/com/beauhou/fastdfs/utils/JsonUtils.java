package com.beauhou.fastdfs.utils;

import com.alibaba.fastjson.JSON;


/**
 * @author beauhou
 * @version 1.0
 * @date 2020/3/6 0006 14:39
 */
public class JsonUtils {
    /**
     * 对象转json
     * @param object
     * @return
     */
    public static String object2Json(Object object){
        String json = JSON.toJSONString(object);
        return json;
    }

    /**
     * json转对象
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> Object json2Object(String json,Class<T> cls){
        T object = (T)JSON.parseObject(json, cls);
        return object;
    }
}
