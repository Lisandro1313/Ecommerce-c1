package org.example.service;
import org.example.model.Order;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${stripe.apiKey}")
    private String apiKey;

    public boolean processPayment(Order order, String token) {
        Stripe.apiKey = apiKey;

        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", order.getTotalAmount());
        chargeParams.put("currency", "usd");
        chargeParams.put("description", "Payment for Order ID: " + order.getId());
        chargeParams.put("source", token);

        try {
            Charge charge = Charge.create(chargeParams);
            return charge.getPaid();
        } catch (StripeException e) {
            e.printStackTrace();
            return false;
        }
    }
}