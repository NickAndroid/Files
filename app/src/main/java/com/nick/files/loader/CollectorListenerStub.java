package com.nick.files.loader;

import com.nick.files.model.BaseElement;
import com.nick.files.model.Category;

import java.util.List;

/**
 * Created by nick on 15-9-19.
 */
public class CollectorListenerStub extends CollectorListener {

    @Override
    protected void onStart(Category category) {

    }

    @Override
    protected void onComplete(List<? extends BaseElement> result, Category category) {

    }

    @Override
    protected void onInterrupt(Category category) {

    }

    @Override
    protected void onFailure(Category category) {

    }
}
