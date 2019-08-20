package com.payoneer.ensemble.collector.ruleengine.impl.jeasy.core;

import com.payoneer.ensemble.collector.ruleengine.api.Facts;
import com.payoneer.ensemble.collector.ruleengine.api.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RuleEngine {

    private static final Logger logger = LoggerFactory.getLogger(RuleEngine.class);

    private RulesEngineParameters parameters;


    public RuleEngine() {
        this(new RulesEngineParameters());
    }

    public RuleEngine(final RulesEngineParameters parameters) {
        this.parameters = parameters;
    }

    public RulesEngineParameters getParameters() {
        return new RulesEngineParameters(
                parameters.isSkipOnFirstAppliedRule(),
                parameters.isSkipOnFirstFailedRule(),
                parameters.isSkipOnFirstNonTriggeredRule(),
                parameters.getPriorityThreshold()
        );
    }


    public void fire(Set<Rule> rules, Facts facts) {
        for (Rule rule : rules) {
            final String name = rule.getName();
            final int priority = rule.getPriority();
            if (priority > parameters.getPriorityThreshold()) {
                logger.debug("Rule priority threshold ({}) exceeded at rule '{}' with priority={}, next rules will be skipped",
                        parameters.getPriorityThreshold(), name, priority);
                break;
            }
            if (rule.evaluate(facts)) {
                try {
                    rule.execute(facts);
                    if (parameters.isSkipOnFirstAppliedRule()) {
                        logger.debug("Next rules will be skipped since parameter skipOnFirstAppliedRule is set");
                        break;
                    }
                } catch (Exception exception) {
                    if (parameters.isSkipOnFirstFailedRule()) {
                        logger.debug("Next rules will be skipped since parameter skipOnFirstFailedRule is set");
                        break;
                    }
                }
            } else {
                if (parameters.isSkipOnFirstNonTriggeredRule()) {
                    logger.debug("Next rules will be skipped since parameter skipOnFirstNonTriggeredRule is set");
                    break;
                }
            }
        }
    }

    public Map<Rule, Boolean> matchRules(Set<Rule> rules, Facts facts) {
        logger.debug("Checking rules");
        Map<Rule, Boolean> result = new HashMap<>();
        for (Rule rule : rules) {
            result.put(rule, rule.evaluate(facts));
        }
        return result;
    }

    public Rule matchRule(Set<Rule> rules, Facts facts) {
        logger.debug("Checking rules");
        for (Rule rule : rules) {
            if (rule.evaluate(facts)){
                logger.debug("found rule [{}] to match facts [{}]", rule, facts);
                return rule;
            }
        }
        return null;
    }
}
