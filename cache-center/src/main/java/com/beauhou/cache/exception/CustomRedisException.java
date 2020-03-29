package com.beauhou.cache.exception;

/**
 * redis操作异常
 * @author beauhou
 * @version 1.0
 * @date 2020/3/27 0027 13:08
 */
public class CustomRedisException  extends RuntimeException{

    public CustomRedisException() {
    }

    public CustomRedisException(String message) {
        super(message);
    }

    public CustomRedisException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomRedisException(Throwable cause) {
        super(cause);
    }

    public CustomRedisException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
