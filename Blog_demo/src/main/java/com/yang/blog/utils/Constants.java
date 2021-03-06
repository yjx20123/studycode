package com.yang.blog.utils;

public interface Constants {
    int DEFAULT_SIZE=30;
     interface TimeValue{
          int HOUR_2=60*60*2;
          int MIN=60;
          int HOUR=60*MIN;
          int Day=24*HOUR;
          int WEEK=7*Day;
          int MONTH=Day*30;
     }
    interface User{
        String ROLE_ADMIN="role_admin";
        String ROLE_NORMAL="role_normal";
        String DEFAULT_AVATAR="https://img1.baidu.com/it/u=1925715390,133119052&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400";
        String DEFAULT_STATE="1";
        String KEY_CAPTCHA_CONTENT="key_captcha_content_";
        String KEY_EMAIL_SEND_IP="key_email_send_ip";
        String KEY_EMAIL_SEND_ADDRESS="key_email_send_address";
        String TOKEN_KEY="token_key";
        String COOKIE_TOKEN_KEY ="cookie_token_key" ;
    }
    interface Settings{
        String MANAGER_ACCOUNT_INIT_STATE="manager_account_init_state";
    }
    interface Page{
         int DEFAULT_PAGE=1;
         int MIN_SIZE=2;
    }


}
