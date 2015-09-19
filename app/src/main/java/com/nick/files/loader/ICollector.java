package com.nick.files.loader;

import com.nick.files.model.BaseElement;

import java.util.List;

/**
 * Created by nick on 15-9-19.
 */
interface ICollector extends Incorruptible {
    List<? extends BaseElement> collect(ICollectorListener listener);
}
