package com.kuang.listen;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCountListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount  =(Integer) ctx.getAttribute("OnlineCount");
        if(onlineCount==null){
            onlineCount=new Integer(1);
        }else{
            int count=onlineCount.intValue();
            onlineCount=new Integer(count+1);
        }
        ctx.setAttribute("OnlineCount",onlineCount);

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        Integer onLineCount = (Integer) ctx.getAttribute("OnLineCount");
        if(onLineCount==null){
            onLineCount=new Integer(0);
        }
        else{
            int count=onLineCount.intValue();
            onLineCount=new Integer(count-1);
        }
        ctx.setAttribute("OnlineCount",onLineCount);

    }
}
