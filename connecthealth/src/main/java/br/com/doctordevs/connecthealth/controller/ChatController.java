package br.com.doctordevs.connecthealth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "*")
public class ChatController {
    
    @RequestMapping
    public String getChat() {
        return "lBIe7pQX3BgKE0EIEyNiT3BlbkFJEQURQib7RSwXhC64Z9Qu";
    }
}
