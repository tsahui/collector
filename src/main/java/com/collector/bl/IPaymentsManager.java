package com.collector.bl;

import com.collector.tmp.PaymentRequest;

public interface IPaymentsManager {

    String getLegalEntityForPayment(PaymentRequest paymentRequest);

}
