package com.nick.files.handle;

/**
 * Created by nick on 15-9-19.
 */
public class BasicFileHandler implements IFileHandler {

    private static BasicFileHandler HANDLER;

    public static synchronized BasicFileHandler getInstance() {
        if (HANDLER == null) {
            HANDLER = new BasicFileHandler();
        }
        return HANDLER;
    }

    @Override
    public int execute(Op op) {
        return 0;
    }
}
