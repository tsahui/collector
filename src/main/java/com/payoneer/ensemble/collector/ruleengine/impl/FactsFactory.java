package com.payoneer.ensemble.collector.ruleengine.impl;

import com.payoneer.ensemble.collector.ruleengine.api.Facts;
import com.payoneer.ensemble.collector.ruleengine.api.IFactsFactory;
import com.payoneer.ensemble.collector.tmp.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class FactsFactory implements IFactsFactory {


    @Override
    public Facts buildFacts(PaymentRequest paymentRequest) {
        return new Facts()
                .withFact("amount", paymentRequest.getAmount())
                .withFact("currency", paymentRequest.getCurrency());
    }
}
