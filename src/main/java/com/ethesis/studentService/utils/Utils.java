package com.ethesis.studentService.utils;

/**
 * @author erfan
 * @since 2/9/23
 */
public class Utils {

    public static boolean isValidIdentifier(Long id) {
        return id != 0 && id != null;
    }
}
