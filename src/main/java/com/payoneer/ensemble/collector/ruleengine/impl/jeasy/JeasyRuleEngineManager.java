package com.payoneer.ensemble.collector.ruleengine.impl.jeasy;

import com.payoneer.ensemble.collector.ruleengine.api.Facts;
import com.payoneer.ensemble.collector.ruleengine.api.IRuleEngineManager;
import com.payoneer.ensemble.collector.ruleengine.api.Rule;
import com.payoneer.ensemble.collector.ruleengine.impl.jeasy.core.RuleEngine;
import com.payoneer.ensemble.collector.ruleengine.impl.jeasy.core.RulesEngineParameters;
import com.payoneer.ensemble.collector.ruleengine.rules.IRuleManger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.UUID;

@Service
public class JeasyRuleEngineManager implements IRuleEngineManager {

    private RuleEngine engine; // = new RuleEngine();

    @Autowired
    private IRuleManger ruleManger;

    @PostConstruct
    private void init(){
        RulesEngineParameters parameters = new RulesEngineParameters();
        parameters.setSkipOnFirstAppliedRule(true);

        engine = new RuleEngine(parameters);
    }


    @Override
    public Rule findMatchingRule(Facts facts) {
        UUID uuid = UUID.randomUUID(); //TODO:: find a way to create an ID for each collector
        Set<Rule> rules = ruleManger.getRulesById(uuid);
        return engine.matchRule(rules, facts);
    }
}
