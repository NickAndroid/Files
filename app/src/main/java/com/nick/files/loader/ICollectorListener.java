package com.nick.files.loader;

import com.nick.files.model.BaseElement;
import com.nick.files.model.Category;

import java.util.List;

/**
 * Created by nick on 15-9-19.
 */
interface ICollectorListener {
    void postOnStart(Category category);

    void postOnComplete(List<? extends BaseElement> result, Category category);

    void postOnInterrupt(Category category);

    void postOnFailure(Category category);
}
