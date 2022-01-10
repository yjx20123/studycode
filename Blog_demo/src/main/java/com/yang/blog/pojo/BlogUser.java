package com.yang.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class BlogUser implements Serializable,Cloneable {
    @Id
    private String id;
    @Column(name = "user_name")
    private String username;
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
    private String logip;
    @Column(name="create_time")
    private Date createtime;
    @Column(name = "update_time")
    private Date updatetime;

}