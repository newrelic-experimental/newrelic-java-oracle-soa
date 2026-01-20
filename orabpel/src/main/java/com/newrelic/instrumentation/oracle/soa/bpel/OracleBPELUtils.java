package com.newrelic.instrumentation.oracle.soa.bpel;

import com.collaxa.cube.engine.ICubeContext;
import com.collaxa.cube.engine.delivery.CallbackInfo;
import com.collaxa.cube.engine.delivery.InvokeInfo;
import com.collaxa.cube.engine.dispatch.message.invoke.InvokeInstanceMessage;

import java.util.Map;

public class OracleBPELUtils {

    public static void addAttribute(Map<String, Object> attributes, String key, Object value) {
        if(value != null && attributes != null && key != null && !key.isEmpty()) {
            attributes.put(key, value);
        }
    }

    public static void addInvokeInstanceMessage(Map<String, Object> attributes, InvokeInstanceMessage message) {
        if(message != null) {
            addAttribute(attributes,"InvokeInstanceMessage-MessageGUID",message.getMessageGUID());
            addAttribute(attributes,"InvokeInstanceMessage-MessageId",message.getMessageId());
            addAttribute(attributes,"InvokeInstanceMessage-ApplicationName",message.getApplicationName());
            addAttribute(attributes,"InvokeInstanceMessage-EngineType",message.getEngineType());
        }
    }

    public static void addCallbackInfo(Map<String, Object> attributes, CallbackInfo info) {
        if(info != null) {
            addAttribute(attributes,"CallbackInfo-MessageGUID",info.getMessageGUID());
            addAttribute(attributes,"CallbackInfo-EventName",info.getEventName());
            addAttribute(attributes,"CallbackInfo-Operation",info.getOperationName());
            addAttribute(attributes,"CallbackInfo-NodeType",info.getNodeType());
            addAttribute(attributes,"CallbackInfo-ConversationId",info.getConversationId());
        }
    }

    public static void addInvokeInfo(Map<String, Object> attributes, InvokeInfo info) {
        if(info != null) {
            addAttribute(attributes,"InvokeInfo-MessageGUID",info.getMessageGUID());
            addAttribute(attributes,"InvokeInfo-ConversationId",info.getConversationId());
            addAttribute(attributes,"InvokeInfo-OperationName",info.getOperationName());
            addAttribute(attributes,"InvokeInfo-NodeType",info.getNodeType());
            addAttribute(attributes,"InvokeInfo-ConversationId",info.getConversationId());
        }
    }
}
