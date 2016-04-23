package com.android.browser.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Created by qijianbin on 16/4/4.
 */
public abstract class ResponseUtils {

    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Charset responseCharset(String contentType) {
        return UTF_8;
    }
}
