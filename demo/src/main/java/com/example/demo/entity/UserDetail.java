package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity(name = "user_detail")
public class UserDetail {
    @Id
    private int user_id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "id_card")
    private String idCard;

    // Nó có quan hệ 1-1 với User qua user_id, mà user_id là khóa chính của
    // UserDetail nên ta thêm annotation @MapsId
    // để nói với JPA là user_id là khóa chính của UserDetail và nó cũng là khóa
    // ngoại của User
    // Nếu không có @MapsId thì JPA sẽ tạo thêm 1 cột user_id trong bảng user_detail
    // @MapsId chỉ dùng cho quan hệ 1-1
    @OneToOne // Quan hệ 1-1 với User
    @JoinColumn(name = "user_id") // user_id là khóa ngoại của UserDetail
    @MapsId // user_id là khóa chính của UserDetail nên ta dùng @MapsId để nói với JPA là
            // user_id là khóa chính của UserDetail và nó cũng là khóa ngoại của User
    private Users user; // Quan hệ 1-1 với User

    public UserDetail() {}

    public UserDetail(int user_id, String gender, String address, String idCard, Users user) {
        this.user_id = user_id;
        this.gender = gender;
        this.address = address;
        this.idCard = idCard;
        this.user = user;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
