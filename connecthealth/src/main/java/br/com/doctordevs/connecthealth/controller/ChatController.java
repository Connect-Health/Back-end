package br.com.doctordevs.connecthealth.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctordevs.connecthealth.model.ChatRequest;
import br.com.doctordevs.connecthealth.model.ChatResponse;
import br.com.doctordevs.connecthealth.service.ChatService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ChatResponse> chat(@RequestBody ChatRequest request) {
        return chatService.sendMessageToChatGPT(request.message())
                .map(responseText -> new ChatResponse(responseText));
    }
}