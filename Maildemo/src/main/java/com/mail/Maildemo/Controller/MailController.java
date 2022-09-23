package com.mail.Maildemo.Controller;

import com.mail.Maildemo.Service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private EmailSenderService senderService;

    @GetMapping("/sendMail")
    public void sendEmail(){
        senderService.sendEmail("mail@gmail.com","This is Soooooo Fun","Hello World");
    }
}
