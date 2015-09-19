package com.nick.files.loader;

import android.os.Handler;

import com.nick.files.model.BaseElement;
import com.nick.files.model.Category;

import java.util.List;

/**
 * Created by nick on 15-9-19.
 */
public abstract class CollectorListener extends Handler implements ICollectorListener {

    protected abstract void onStart(Category category);

    protected abstract void onComplete(List<? extends BaseElement> result, Category category);

    protected abstract void onInterrupt(Category category);

    protected abstract void onFailure(Category category);


    @Override
    public final void postOnStart(final Category category) {
        post(new Runnable() {
            @Override
            public void run() {
                onStart(category);
            }
        });
    }

    @Override
    public final void postOnComplete(final List<? extends BaseElement> result, final Category category) {
        post(new Runnable() {
            @Override
            public void run() {
                onComplete(result,  category);
            }
        });
    }

    @Override
    public final void postOnInterrupt(final Category category) {
        post(new Runnable() {
            @Override
            public void run() {
                onInterrupt(category);
            }
        });
    }

    @Override
    public final void postOnFailure(final Category category) {
        post(new Runnable() {
            @Override
            public void run() {
                onFailure(category);
            }
        });
    }
}
