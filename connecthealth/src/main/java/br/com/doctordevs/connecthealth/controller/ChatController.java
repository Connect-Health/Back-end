package br.com.doctordevs.connecthealth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    private static final String STRIPE_PUBLISHABLE_KEY = "pk_test_51NLysPECStP5J8BJTWwRSyqnIMR6He5lvETBFvEbxw1iPbRE9Xt1aLBRLUAdDURQOJG44MkPWdesV7P4TFTK4uYT00KvuwgENo";
    private static final String STRIPE_SECRET_KEY = "sk_test_51NLysPECStP5J8BJ4029t49ahBdSXLhYojE47Fh2OqRO5o0R4Mx2Bvg2FBwEixFoNgmDvsPojQO7RN72AaOKvYvy00v5bGL8BF";

    @GetMapping("/chaves")
    public String getStripeKeys() {
        return "Stripe Publishable Key: " + STRIPE_PUBLISHABLE_KEY + "\n" +
                "Stripe Secret Key: " + STRIPE_SECRET_KEY;
    }
}
