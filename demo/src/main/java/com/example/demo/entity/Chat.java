package com.example.demo.entity;

import com.example.demo.entity.keys.ChatId;
import jakarta.persistence.*;


@Entity(name = "chat")
public class Chat {
    @EmbeddedId
    private ChatId chatId;

    @Column(name = "nickname", updatable = false, insertable = false)
    private String nickname;

    @Column(name = "content", updatable = false, insertable = false)
    private String content;

    @Column(name = "room_id", updatable = false, insertable = false)
    private String roomId;

    public Chat() {
    }

    public Chat(ChatId chatId) {
        this.chatId = chatId;
    }

    public ChatId getChatId() {
        return chatId;
    }

    public void setChatId(ChatId chatId) {
        this.chatId = chatId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
