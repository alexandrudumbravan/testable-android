package com.android.testable.lib.app;

import com.android.testable.lib.os.TABundle;

public class StarterConfig {

    private final Class<?> componentClass;
    private final TABundle extras;
    private final String action;

    private StarterConfig(Builder builder) {
        this.componentClass = builder.componentClass;
        this.extras = builder.extras;
        this.action = builder.action;
    }

    public Class<?> getComponentClass() {
        return componentClass;
    }

    public TABundle getExtras() {
        return extras;
    }

    public String getAction() {
        return action;
    }

    public static class Builder {
        private Class<?> componentClass;
        private TABundle extras;
        private String action;

        public Builder withCompoentClass(Class<?> componentClass) {
            this.componentClass = componentClass;
            return this;
        }

        public Builder withExtras(TABundle extras) {
            this.extras = extras;
            return this;
        }

        public Builder withAction(String action) {
            this.action = action;
            return this;
        }

        public StarterConfig build() {
            return new StarterConfig(this);
        }

    }
}
