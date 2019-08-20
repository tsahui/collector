package com.payoneer.ensemble.collector.tmp;

import com.payoneer.ensemble.collector.ruleengine.api.Facts;
import com.payoneer.ensemble.collector.ruleengine.impl.FactsFactory;


public class Main {

    public static void main(String[] args) {

        PaymentRequest paymentRequest = new PaymentRequest(100, Currency.gbp);
        Facts facts = new FactsFactory().buildFacts(paymentRequest);

        BaseRule rule = DB.readRule();

        if (rule.evaluate(facts)){
            RuleAction action = DB.readAction();
            System.out.println(action);

        }


    }

}
