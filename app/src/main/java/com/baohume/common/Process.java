package com.baohume.common;

/**
 * Created by qijianbin on 16/4/23.
 */
public class Process {

    /** @hide */
    public static final int PROC_TERM_MASK = 0xff;
    /** @hide */
    public static final int PROC_ZERO_TERM = 0;
    /** @hide */
    public static final int PROC_SPACE_TERM = (int)' ';
    /** @hide */
    public static final int PROC_TAB_TERM = (int)'\t';
    /** @hide */
    public static final int PROC_COMBINE = 0x100;
    /** @hide */
    public static final int PROC_PARENS = 0x200;
    /** @hide */
    public static final int PROC_QUOTES = 0x400;
    /** @hide */
    public static final int PROC_OUT_STRING = 0x1000;
    /** @hide */
    public static final int PROC_OUT_LONG = 0x2000;
    /** @hide */
    public static final int PROC_OUT_FLOAT = 0x4000;

    public static long getElapsedCpuTime() {
        return android.os.Process.getElapsedCpuTime();
    }

    public static boolean readProcFile(String s, int[] systemCpuFormat, Object o, long[] sysCpu, Object o1) {
        return false;
    }
}
