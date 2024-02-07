package com.example.demo.socket;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.example.demo.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SocketModule {
    private final SocketIOServer server; // Khai báo một server socket
    private final SocketService socketService; // Khai báo một service để xử lý logic
    @Autowired
    public SocketModule(SocketIOServer server, SocketService socketService){ // Inject server socket và service vào
        this.server = server; // Gán server socket
        this.socketService = socketService; // Gán service
        server.addConnectListener(onConnected()); // Thêm listener khi có client kết nối
        server.addDisconnectListener(onDisconnected()); // Thêm listener khi có client ngắt kết nối
        server.addEventListener("send_message", Chat.class, onChatReceived()); // Thêm listener khi có client gửi tin nhắn, với tên sự kiện là send_message và kiểu dữ liệu là Chat 
    }

    private DataListener<Chat> onChatReceived(){ // Hàm xử lý khi có tin nhắn được gửi đến
        return (senderClient, data, ackServer) -> { // Trả về một listener xử lý khi có tin nhắn được gửi đến 
            System.out.println(String.format("%s -> %s", senderClient.getSessionId().toString(), data.toString())); // In ra màn hình console thông tin của session và tin nhắn được gửi đến
            socketService.saveMessage(data.getRoomId(), "get_message", senderClient, data); // Lưu tin nhắn vào database và gửi lại tin nhắn đó cho tất cả client khác trong phòng qua hàm saveMessage của service
        };
    }

    private ConnectListener onConnected(){ // Hàm xử lý khi có client kết nối
        return (client) -> { // Trả về một listener xử lý khi có client kết nối
            String roomId = client.getHandshakeData().getSingleUrlParam("room"); // Lấy ra các tham số và giá trị của URL mà client gửi lên
            //var params = client.getHandshakeData().getUrlParams(); // Lấy ra các tham số và giá trị của URL mà client gửi lên
            //String roomId = params.get("room").stream().collect(Collectors.joining()); // Lấy ra giá trị của tham số room từ URL
            //String nickname = params.get("nickname").stream().collect(Collectors.joining()); // Lấy ra giá trị của tham số nickname từ URL
            client.joinRoom(roomId); // Thêm client vào phòng chat với id là roomId
            socketService.saveInfoMessage(roomId, "get_message", client, String.format("%s joined to chat", client.getSessionId().toString())); // Lưu tin nhắn thông báo đã kết nối và gửi đó cho tất cả client khác trong phòng qua hàm saveInfoMessage của service
            System.out.println(String.format("Socket ID[{}] - room[{}] - username [{}]  Connected to chat module through", client.getSessionId().toString(), roomId)); // In ra màn hình console thông tin của session, phòng và tên của client vừa kết nối
        };
    }

    private DisconnectListener onDisconnected(){ // Hàm xử lý khi có client ngắt kết nối
        return (client) -> { // Trả về một listener xử lý khi có client ngắt kết nối
            String roomId = client.getHandshakeData().getSingleUrlParam("room"); // Lấy ra các tham số và giá trị của URL mà client gửi lên
            //var params = client.getHandshakeData().getUrlParams(); // Lấy ra các tham số và giá trị của URL mà client gửi lên
            //String roomId = params.get("room").stream().collect(Collectors.joining()); // Lấy ra giá trị của tham số room từ URL
            //String nickname = params.get("nickname").stream().collect(Collectors.joining()); // Lấy ra giá trị của tham số nickname từ URL
            socketService.saveInfoMessage(roomId, "get_message", client, String.format("%s disconnected", client.getSessionId().toString())); // Lưu tin nhắn thông báo đã kết nối và gửi đó cho tất cả client khác trong phòng qua hàm saveInfoMessage của service
            client.leaveRoom(roomId);
            System.out.println(String.format("Socket ID[{}] - room[{}] - username [{}]  Disconnected to chat module through", client.getSessionId().toString(), roomId)); // In ra màn hình console thông tin của session, phòng và tên của client vừa ngắt kết nối
        };
    }
}
