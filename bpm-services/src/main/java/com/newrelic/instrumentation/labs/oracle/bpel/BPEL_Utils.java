package com.newrelic.instrumentation.labs.oracle.bpel;

import java.util.Map;

public class BPEL_Utils {

    public static void addAttribute(Map<String, Object> attributes, String key, String value) {
        if(value != null &&attributes != null && key != null && !key.isEmpty()) {
            attributes.put(key, value);
        }
    }
}
