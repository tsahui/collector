package com.payoneer.ensemble.collector.ruleengine.api;

import com.payoneer.ensemble.collector.ruleengine.api.Facts;
import com.payoneer.ensemble.collector.tmp.PaymentRequest;

public interface IFactsFactory {

    Facts buildFacts(PaymentRequest paymentRequest);

}
