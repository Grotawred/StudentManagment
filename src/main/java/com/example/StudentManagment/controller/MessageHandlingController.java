//package com.example.StudentManagment.controller;
//
//import com.example.StudentManagment.entities.Greeting;
//import com.example.StudentManagment.entities.HelloMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.util.HtmlUtils;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Controller
//public class MessageHandlingController {
//    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
//    public Greeting send(HelloMessage message) throws Exception{
//        Thread.sleep(1000);
//        return new Greeting("Hello, "+
//                HtmlUtils.htmlEscape(message.getName()) + "!");
//
//    }
//}
