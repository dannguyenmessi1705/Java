package com.example.demo.service.impl;

import com.example.demo.entity.Chat;

import java.util.List;

public interface ChatServiceImpl {
    Chat saveMessage(Chat chat);
    List<Chat> getMessages(String roomId);
}
