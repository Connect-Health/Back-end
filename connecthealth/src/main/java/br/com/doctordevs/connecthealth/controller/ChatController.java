package br.com.doctordevs.connecthealth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    @GetMapping
    public String getChat() {
        return "sk-KqE4a2i5neuqldm8t0QjT3BlbkFJOtSAhXU8NNB1yC7JJ9lia";
    }
}
