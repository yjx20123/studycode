package com.yang.blog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tb_images")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image implements Serializable,Cloneable {
    @Id
    private String id;
    private String user_id;
    private String url;
    private String state;
    private Date createTime;
    private Date updateTime;
}
