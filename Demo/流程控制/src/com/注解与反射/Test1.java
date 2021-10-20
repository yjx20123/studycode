package com.注解与反射;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import java.net.URL;
//练习Thread,实现多线程 同步下载图片

public class Test1 extends Thread{
        private String url;
        private String name;
        public Test1(){

        }
        public Test1(String url,String name){
            this.name=name;
            this.url=url;
        }

    @Override
    //执行体
    public void run() {
        WebFile webFile = new WebFile();
        webFile.downloader(url,name);
        System.out.println("下载名为："+name);

    }

    public static void main(String[] args) {
        Test1 test1 = new Test1("https://picsum.photos/200/300","1.jpg");
        Test1 test2 = new Test1("https://picsum.photos/200/300","2.jpg");
        Test1 test3 = new Test1("https://picsum.photos/200/300","3.jpg");
        test1.start();
        test2.start();
        test3.start();
    }
}
//下载器
class WebFile{
    //下载方法
    public void downloader(String url,String name)  {
       try{
           FileUtils.copyURLToFile(new URL(url),new File(name));
       }catch (IOException e){
           e.printStackTrace();
           System.out.println("IO异常，download方法");
       }
    }
}