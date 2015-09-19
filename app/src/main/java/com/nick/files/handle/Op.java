package com.nick.files.handle;

import com.nick.files.model.FileModel;

/**
 * Created by nick on 15-9-19.
 */
public class Op {
    public static final int OP_COPY = 0;
    public static final int OP_MOVE = 1;
    public static final int OP_DELETE = 2;

    private Op() {
        // Nothing.
    }

    int option;
    FileModel targetFile;
    String to;
    int core;
    OpListener listener;

    public static class OpBuilder {
        int option;
        FileModel targetFile;
        String to;
        int core;
        OpListener listener;

        public OpBuilder() {
            // Nothing.
        }

        public OpBuilder option(int option) {
            this.option = option;
            return this;
        }

        public OpBuilder target(FileModel fileModel) {
            this.targetFile = fileModel;
            return this;
        }

        public OpBuilder to(String des) {
            this.to = to;
            return this;
        }

        public OpBuilder core(int core) {
            this.core = core;
            return this;
        }

        public OpBuilder setListener(OpListener listener) {
            this.listener = listener;
            return this;
        }

        public Op build() {
            Op op = new Op();
            op.option = this.option;
            op.core = this.core;
            op.targetFile = this.targetFile;
            op.to = this.to;
            op.listener = this.listener;
            return op;
        }
    }
}
