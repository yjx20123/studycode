package com.注解与反射;

import org.apache.commons.io.FileUtils;

import javax.naming.Name;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;

public class TestThread3  implements Callable<Boolean>{
    private String url;
    private String name;

    public TestThread3(String url, String name) {
        this.name = name;
        this.url = url;
    }

    public void WebDownload(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Boolean call() throws Exception {
      WebDownload(url,name);
    return true;
    }
}

