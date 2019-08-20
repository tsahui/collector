package com.payoneer.ensemble.collector.ruleengine.api;

import com.payoneer.ensemble.collector.ruleengine.api.Facts;
import com.payoneer.ensemble.collector.ruleengine.api.Rule;

public interface IRuleEngineManager {

    Rule findMatchingRule(Facts facts);
}
