package com.collector.ruleengine.api;

public interface Condition {

    boolean evaluate(Facts facts);

    Condition FALSE = facts -> false;

    Condition TRUE = facts -> true;
}