package com.collector.controller;

import com.collector.bl.IPaymentsManager;
import com.collector.tmp.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/payment")
public class PaymentController {

    @Autowired
    private IPaymentsManager paymentsManager;

    @PostMapping
    public String getPaymentLegalEntity(@RequestBody PaymentRequest request){
        return paymentsManager.getLegalEntityForPayment(request);
    }
}
