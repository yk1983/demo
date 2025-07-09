package com.example.demo.service.impl;

import com.example.demo.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage() {
        return "Hello from MessageService!";
    }
}
