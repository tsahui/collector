package com.collector.ruleengine.api;

public interface IRuleEngineManager {

    Rule findMatchingRule(Facts facts);
}
