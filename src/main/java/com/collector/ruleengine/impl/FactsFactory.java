package com.collector.ruleengine.impl;

import com.collector.ruleengine.api.Facts;
import com.collector.ruleengine.api.IFactsFactory;
import com.collector.tmp.PaymentRequest;
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
