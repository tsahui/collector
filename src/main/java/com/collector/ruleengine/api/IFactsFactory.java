package com.collector.ruleengine.api;

import com.collector.tmp.PaymentRequest;

public interface IFactsFactory {

    Facts buildFacts(PaymentRequest paymentRequest);

}
