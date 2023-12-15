package com.general.ood.ricksapp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {
    private Map properties;

    public InstrumentSpec(Map properties) {
        if (properties == null)
            this.properties = new HashMap();
        else
            this.properties = new HashMap(properties);
    }


    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public Map getProperties() {
        return properties;
    }

    public boolean matches(InstrumentSpec spec) {
        Iterator itr = spec.getProperties().keySet().iterator();
        while (itr.hasNext()) {
            String propName = (String) itr.next();
            if (!properties.get(propName).equals(spec.getProperties().get(propName)))
                return false;
        }
        return true;
    }
}
