package com.android.testable.lib.app;

import com.android.testable.lib.os.TABundle;

public class StarterConfig {

    private Class<?> componentClass;
    private TABundle extras;
    private String action;

    public Class<?> getComponentClass() {
        return componentClass;
    }

    public TABundle getExtras() {
        return extras;
    }

    public String getAction() {
        return action;
    }
}
