package com.payoneer.ensemble.collector.bl;

import com.payoneer.ensemble.collector.tmp.PaymentRequest;

public interface IPaymentsManager {

    String getLegalEntityForPayment(PaymentRequest paymentRequest);

}
