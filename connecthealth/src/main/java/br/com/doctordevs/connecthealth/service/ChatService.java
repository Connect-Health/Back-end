package br.com.doctordevs.connecthealth.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ChatService {
    private final WebClient webClient;

    public ChatService(WebClient.Builder builder, @Value("${openai.api.key}") String apiKey) {
        this.webClient = builder.baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization",
                        String.format("Bearer %s", apiKey))
                .defaultHeader("Content-Type", "application/json")
                .build();
        ;
    }

    public Mono<String> sendMessageToChatGPT(String message) {
        var requestBody = Map.of(
                "model", "gpt-4o-mini",
                "messages", new Object[] {
                        Map.of("role", "user", "content", message)
                });

        return webClient.post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {
                    Object choicesObj = response.get("choices");
                    if (choicesObj instanceof List<?>) {
                        @SuppressWarnings("unchecked")
                        List<Map<String, Object>> choices = (List<Map<String, Object>>) choicesObj;
                        if (!choices.isEmpty()) {
                            Object messageObj = choices.get(0).get("message");
                            if (messageObj instanceof Map<?, ?>) {
                                @SuppressWarnings("unchecked")
                                Map<String, Object> messageMap = (Map<String, Object>) messageObj;
                                return (String) messageMap.get("content");
                            }
                        }
                    }
                    return "No response from OpenAI";
                });
    }
}
