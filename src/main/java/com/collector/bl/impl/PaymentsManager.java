package com.collector.bl.impl;

import com.collector.bl.IPaymentsManager;
import com.collector.ruleengine.api.Facts;
import com.collector.ruleengine.api.IFactsFactory;
import com.collector.ruleengine.api.IRuleEngineManager;
import com.collector.ruleengine.api.Rule;
import com.collector.tmp.PaymentRequest;
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
