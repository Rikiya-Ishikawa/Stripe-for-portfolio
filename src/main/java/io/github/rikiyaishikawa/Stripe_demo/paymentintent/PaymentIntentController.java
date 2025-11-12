package io.github.rikiyaishikawa.Stripe_demo.paymentintent;

import com.stripe.model.PaymentIntent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment-intents")
public class PaymentIntentController {
    private final PaymentIntentService service;

    public PaymentIntentController(PaymentIntentService service) {
        this.service = service;
    }

    @PostMapping
    public PaymentIntentResponse create(@RequestParam Long amount,
                                @RequestParam(defaultValue = "jpy") String currency) throws Exception {
        PaymentIntent pi = service.createPaymentIntent(amount, currency);
        return new PaymentIntentResponse(pi.getAmount(), pi.getCurrency());
    }
}
