package com.email.emaiApi.controller;

import com.email.emaiApi.model.EmailRequest;
import com.email.emaiApi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailRequest request;

    @RequestMapping("/welcome")
    public String welcome(){
        return "Welcome to NEIR";
    }

    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
       boolean result = this.emailService.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
        System.out.println(request);
       if (result){
           return ResponseEntity.ok("Email Sent Succesfully");
       }
       else{
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
       }


    }

}
