package cn.moon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Classmate {
    private int classId;
    private int id;
    private String password;
    private String name;
    private String nickname;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String sign;
    private String hobby;
    private String message;
    private String profile;
    private String address;
    private String qq;
    private String wechat;
    private String phone;
    private String email;
    private String video;
}
