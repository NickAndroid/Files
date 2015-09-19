package com.nick.files.handle;

/**
 * Created by nick on 15-9-19.
 */
public interface IFileHandler {

    public static final int ERROR_CODE_FILE_NOT_EXISTS = 0x1;
    public static final int ERROR_CODE_NO_PERMISSION = 0x2;
    public static final int ERROR_CODE_INVALID_FILE = 0x3;
    public static final int ERROR_CODE_IO_FAILURE = 0x4;

    int execute(Op op);
}
