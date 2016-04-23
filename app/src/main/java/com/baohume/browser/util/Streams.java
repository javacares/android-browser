package com.baohume.browser.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by qijianbin on 16/4/4.
 */
public abstract class Streams {
    public static byte[] readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream var2 = new ByteArrayOutputStream();
        byte[] var3 = new byte[1024];

        int var5;
        while((var5 = inputStream.read(var3)) != -1) {
            var2.write(var3, 0, var5);
        }

        var2.close();
        return var2.toByteArray();
    }
}
