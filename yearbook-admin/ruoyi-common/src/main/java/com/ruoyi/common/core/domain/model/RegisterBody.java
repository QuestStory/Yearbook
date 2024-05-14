package com.ruoyi.common.core.domain.model;

/**
 * 用户注册对象
 * 
 * @author ruoyi
 */
public class RegisterBody extends LoginBody
{
    /* 班级账号 */
    private String username;

    /* 班级名称 */
    private String nickname;

    /* 学校名称 */
    private String schoolname;

    /* 学校层次 */
    private String schoollayer;

    /* 班级密码 */
    private String password;

    /* 验证码 */
    private String code;

    /* 唯一标识 */
    private String uuid;

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getSchoollayer() {
        return schoollayer;
    }

    public void setSchoollayer(String schoollayer) {
        this.schoollayer = schoollayer;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
