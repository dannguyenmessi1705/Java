package com.example.demo.payload;

// Class trả về cho User
public class Payload {
    private int statusCode = 200;
    private String description;
    private Object data;

    public Payload() {
    }

    public Payload(int statusCode, String description, Object data) {
        this.statusCode = statusCode;
        this.description = description;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
