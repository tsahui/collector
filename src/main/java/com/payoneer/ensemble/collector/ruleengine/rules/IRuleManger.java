package com.payoneer.ensemble.collector.ruleengine.rules;

import com.payoneer.ensemble.collector.ruleengine.api.Rule;

import java.util.Set;
import java.util.UUID;

public interface IRuleManger {

    Set<Rule> getRulesById(UUID collectorId);

}
