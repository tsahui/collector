package com.collector.tmp;

import com.collector.ruleengine.action.BaseRuleAction;
import org.jeasy.rules.mvel.MVELRule;
import org.jeasy.rules.mvel.MVELRuleFactory;
import org.jeasy.rules.support.YamlRuleDefinitionReader;

import java.io.FileReader;

class DB {

    private static MVELRuleFactory ruleFactory = new MVELRuleFactory(new YamlRuleDefinitionReader());

    static BaseRule readRule(){
        try {
            MVELRule dbRule = ruleFactory.createRules(new FileReader("src/main/resources/rules.yml"));

            return (BaseRule) dbRule;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BaseRule();
    }

    static RuleAction readAction() {
        return new BaseRuleAction();
    }
}
