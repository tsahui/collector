package com.collector.ruleengine.rules;

import com.collector.ruleengine.api.Rule;

import java.util.Set;
import java.util.UUID;

public interface IRuleManger {

    Set<Rule> getRulesById(UUID collectorId);

}
