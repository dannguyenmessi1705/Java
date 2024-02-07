package com.example.demo.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.example.demo.entity.Chat;
import com.example.demo.entity.keys.ChatId;
import com.example.demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service // Đánh dấu đây là một service
public class SocketService { // Khai báo một service để xử lý logic
    private final ChatService chatService; // Khai báo một service để xử lý logic
    @Autowired // Đánh dấu đây là một dependency và Spring sẽ tự động inject vào
    public SocketService(ChatService chatService){ // Inject service vào
        this.chatService = chatService; // Gán service
    }

    public void sendSocketMessage(String roomId, String eventName, SocketIOClient senderClient, Chat chat){ // Hàm gửi tin nhắn qua socket cho tất cả client trong phòng
        for (
                SocketIOClient client : senderClient.getNamespace().getRoomOperations(roomId).getClients() // Lấy ra tất cả client trong phòng
        ) {
            if(!client.getSessionId().toString().equals(senderClient.getSessionId().toString())){ // Nếu client không phải là người gửi
                client.sendEvent(eventName, chat); // Gửi tin nhắn qua socket cho client
            }
        }
    }

    public void saveMessage(String roomId, String eventName, SocketIOClient senderClient, Chat chat){ // Hàm lưu tin nhắn vào database và gửi lại tin nhắn đó cho tất cả client khác trong phòng
//        Chat storeChat = chatService.saveMessage(chat); // Lưu tin nhắn vào database
        sendSocketMessage(roomId, eventName, senderClient, chat); // Gửi lại tin nhắn đó cho tất cả client khác trong phòng
    }

    public void saveInfoMessage(String roomId, String eventName, SocketIOClient senderClient, String message){ // Hàm lưu tin nhắn thông báo đã kết nối và gửi đó cho tất cả client khác trong phòng
        Chat chat = new Chat(); // Khai báo một đối tượng tin nhắn
        chat.setNickname("SERVER"); // Đặt tên cho tin nhắn
        chat.setRoomId(roomId); // Đặt phòng cho tin nhắn
        chat.setContent(message); // Đặt nội dung cho tin nhắn
        chat.setChatId(new ChatId(message, "SERVER", roomId));
        sendSocketMessage(roomId, eventName, senderClient, chat); // Gửi tin nhắn qua socket cho tất cả client trong phòng
    }
}
