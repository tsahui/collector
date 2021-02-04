package com.collector.ruleengine.rules.impl;

import com.collector.ruleengine.api.Rule;
import com.collector.ruleengine.rules.IRuleManger;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RuleManager implements IRuleManger {


    @Override
    public Set<Rule> getRulesById(UUID collectorId) {
        return null;
    }
}
