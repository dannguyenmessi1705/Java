package com.example.demo.service;

import com.example.demo.entity.Chat;
import com.example.demo.repository.ChatRepository;
import com.example.demo.service.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService implements ChatServiceImpl {
    private final ChatRepository chatRepository;


    @Autowired
    public ChatService(ChatRepository chatRepository){
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat saveMessage(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public List<Chat> getMessages(String roomId) {
        return chatRepository.findAllByRoomId(roomId);
    }
}
