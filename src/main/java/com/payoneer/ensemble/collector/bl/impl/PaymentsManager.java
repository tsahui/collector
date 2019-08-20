package com.payoneer.ensemble.collector.bl.impl;

import com.payoneer.ensemble.collector.bl.IPaymentsManager;
import com.payoneer.ensemble.collector.ruleengine.api.IFactsFactory;
import com.payoneer.ensemble.collector.ruleengine.api.IRuleEngineManager;
import com.payoneer.ensemble.collector.ruleengine.api.Rule;
import com.payoneer.ensemble.collector.ruleengine.api.Facts;
import com.payoneer.ensemble.collector.tmp.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsManager implements IPaymentsManager {

    @Autowired
    private IFactsFactory factsFactory;

    @Autowired
    private IRuleEngineManager ruleEngine;

    @Override
    public String getLegalEntityForPayment(PaymentRequest paymentRequest) {

        Facts facts = factsFactory.buildFacts(paymentRequest);

        Rule rule = ruleEngine.findMatchingRule(facts);

        return rule.getAction();
    }

}
