package com.yang.blog.utils;

public interface Constants {
    int DEFAULT_SIZE=30;
     interface TimeValue{
          int HOUR_2=60*60*2*1000;
     }
    interface User{
        String ROLE_ADMIN="rolen_admin";
        String ROLE_NORMAL="role_normal";
        String DEFAULT_AVATAR="https://img1.baidu.com/it/u=1925715390,133119052&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400";
        String DEFAULT_STATE="1";
        String KEY_CAPTCHA_CONTENT="key_captcha_content_";
        String KEY_EMAIL_SEND_IP="key_email_send_ip";
        String KEY_EMAIL_SEND_ADDRESS="key_email_send_address";
        String key_TOKEN_="key_TOKEN_";
    }
    interface Settings{
        String MANAGER_ACCOUNT_INIT_STATE="manager_account_init_state";
    }
}
