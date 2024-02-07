package com.example.demo.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChatId implements Serializable {
    @Column(name = "content")
    private String content;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "room_id")
    private String roomId;

    public ChatId() {
    }

    public ChatId(String content, String nickname, String roomId) {
        this.content = content;
        this.nickname = nickname;
        this.roomId = roomId;
    }
}
