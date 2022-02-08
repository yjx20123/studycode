package com.yang.blog;

import com.yang.blog.utils.EmailSender;

import javax.mail.MessagingException;

public class TestEmailSender {
    public static void main(String[] args) throws MessagingException {
        EmailSender.subject("邮件发送").from("阳光沙滩博客系统")
                .text("这是发送的内容：Ab12rf").to("1835271170@qq.com").send();

    }
}
