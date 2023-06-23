package br.com.doctordevs.connecthealth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
@CrossOrigin(origins = "*")
public class PagamentoController {

    private static String publishableKey = "pk_test_51NLysPECStP5J8BJTWwRSyqnIMR6He5lvETBFvEbxw1iPbRE9Xt1aLBRLUAdDURQOJG44MkPWdesV7P4TFTK4uYT00KvuwgENo";
    private static String secretKey = "sk_test_51NLysPECStP5J8BJ4029t49ahBdSXLhYojE47Fh2OqRO5o0R4Mx2Bvg2FBwEixFoNgmDvsPojQO7RN72AaOKvYvy00v5bGL8BFo";

    static {
        publishableKey = publishableKey.substring(0, publishableKey.length() - 1);
        secretKey = secretKey.substring(0, secretKey.length() - 1);
    }

    private static final Map<String, String> stripeKeys = new HashMap<>();
    static {
        stripeKeys.put("STRIPE_PUBLISHABLE_KEY", publishableKey);
        stripeKeys.put("STRIPE_SECRET_KEY", secretKey);
    }

    @GetMapping("/chaves")
    public List<Map<String, String>> getStripeKeys() {
        List<Map<String, String>> keysList = new ArrayList<>();
        keysList.add(stripeKeys);
        return keysList;
    }
}
