package com.nick.files;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nick.files.handle.BasicFileHandler;
import com.nick.files.handle.Op;
import com.nick.files.handle.OpListenerStub;
import com.nick.files.handle.OpStatus;
import com.nick.files.loader.CollectorExecutor;
import com.nick.files.loader.CollectorListenerStub;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Op op = new Op.OpBuilder()
                .option(Op.OP_COPY)
                .core(4)
                .target(null)
                .to(null)
                .setListener(new OpListenerStub() {
                    @Override
                    public void onSuccess(OpStatus opStatus) {
                        super.onSuccess(opStatus);
                    }
                }).build();

        BasicFileHandler.getInstance().execute(op);

        CollectorExecutor.getInstance().collectAll(new CollectorListenerStub());
    }
}
