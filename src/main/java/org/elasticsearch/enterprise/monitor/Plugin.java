/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.enterprise.monitor;

import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.component.LifecycleComponent;
import org.elasticsearch.common.inject.AbstractModule;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.ArrayList;
import java.util.Collection;

public class Plugin extends AbstractPlugin {

    public Plugin() {
    }

    @Override
    public String name() {
        return "Elasticsearch enterprise - monitor";
    }

    @Override
    public String description() {
        return "Monitoring with an elastic sauce";
    }

    @Override
    public Collection<Module> modules(Settings settings) {
        Module m = new AbstractModule() {

            @Override
            protected void configure() {
                bind(StatsExportersService.class).asEagerSingleton();
            }
        };
        return ImmutableList.of(m);
    }

    @Override
    public Collection<Class<? extends LifecycleComponent>> services() {
        Collection<Class<? extends LifecycleComponent>> l = new ArrayList<Class<? extends LifecycleComponent>>();
        l.add(StatsExportersService.class);
        return l;
    }
}
