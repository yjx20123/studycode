package com.yang.blog.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_user")
public class BlogUser {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name="password")
    private String password;
    @Column(name = "roles")
    private String roles;
    @Column(name ="avatar")
    private String avatar;
    @Column(name = "email")
    private String email;
    @Column(name = "sign")
    private String sign;
    @Column(name = "state")
    private String state;
    @Column(name = "reg_ip")
    private String reg_ip;
    @Column(name = "log_ip")
    private String log_ip;
    @Column(name="create_time")
    private Date create_time;
    @Column(name = "update_time")
    private Date update_time;

}
