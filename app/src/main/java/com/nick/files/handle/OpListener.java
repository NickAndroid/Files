package com.nick.files.handle;

/**
 * Created by nick on 15-9-19.
 */
public interface OpListener {
    void onStart(OpStatus opStatus);

    void onProgressUpdate(OpStatus opStatus);

    void onFailure(OpStatus opStatus);

    void onSuccess(OpStatus opStatus);

    void onInterrupted(OpStatus opStatus);
}
