package com.ivanov.util;

import java.time.LocalDateTime;

public class DateUtil {

    private static DateUtil instance;

    private DateUtil() {

    }

    public static DateUtil getInstance() {
        if (instance == null) {
            instance = new DateUtil();
        }
        return instance;
    }

    public LocalDateTime getCurrentDate() {
        return LocalDateTime.now();
    }
}
