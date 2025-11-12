package io.github.rikiyaishikawa.Stripe_demo.paymentintent;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
class PaymentIntentService {
    @Value("${stripe.api.key}")
    private String stripeApiKey;

    public PaymentIntent createPaymentIntent(Long amount, String currency) throws Exception {
        Stripe.apiKey = stripeApiKey;

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
            .setAmount(amount)
            .setCurrency(currency)
            .setAutomaticPaymentMethods(
                PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                    .setEnabled(true)
                    .build()
            )
            .build();

        return PaymentIntent.create(params);
    }
}
