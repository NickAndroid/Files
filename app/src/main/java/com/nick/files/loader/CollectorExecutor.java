package com.nick.files.loader;

import com.nick.files.Utils.Preconditions;
import com.nick.files.model.Category;

import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by nick on 15-9-19.
 */
public class CollectorExecutor {

    private static CollectorExecutor EXECUTOR;

    private ExecutorService mExecutorService;

    public static synchronized CollectorExecutor getInstance() {
        if (EXECUTOR == null) {
            EXECUTOR = new CollectorExecutor();
        }
        return EXECUTOR;
    }

    private CollectorExecutor() {
        mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 4);
    }

    public void collectMultiplyAsync(EnumSet<Category> categories, CollectorListener listener) {
        Preconditions.checkNotNull(categories);
        for (Category c : categories) {
            collectAsync(c, listener);
        }
    }

    public void collectAll(final CollectorListener listener) {
        for (Category c : Category.values()) {
            collectAsync(c, listener);
        }
    }

    public void collectAsync(final Category category, final CollectorListener listener) {
        Preconditions.checkNotNull(category);
        Preconditions.checkNotNull(listener);
        Runnable action = new Runnable() {
            @Override
            public void run() {
                ICollector collector = getCollectorByCategory(category);
                collector.collect(listener);
            }
        };
        mExecutorService.execute(action);
    }

    private ICollector getCollectorByCategory(Category category) {
        switch (category) {
            case MUSIC:
                return new AudioCollector();
        }
        throw new UnsupportedOperationException("Unknown category.");
    }
}
