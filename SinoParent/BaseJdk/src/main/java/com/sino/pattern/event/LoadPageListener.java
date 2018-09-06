package com.sino.pattern.event;

import java.util.EventListener;

//页面加载事件监听器
class LoadPageListener implements EventListener {

    //加载
    public void onSuccess(LoadPageEvent e){
        System.out.println("页面加载成功");
    }

    //开始
    public void onStart(LoadPageEvent e){
        System.out.println("页面开始加载");
    }

    //关闭
    public void onClose(LoadPageEvent e){
        System.out.println("页面关闭");
    }

    //异常
    public void onError(LoadPageEvent e){
        System.out.println("页面加载出错");
    }
}

//页面点击监听器
class ClickListener implements EventListener{

    //单击
    public void onSingle(ClickEvent clickEvent){
        System.out.println("鼠标单击");
    }
    
     //双击
    public void onDouble(ClickEvent clickEvent){
        System.out.println("鼠标双击");
    }
}

//鼠标移动监听器
class MouseMovationListener implements EventListener{
    
    //左移
    public void onLeft(MouseMovationEvent mouseMovationEvent){
        System.out.println("鼠标左划");
    }
    
    //右移
    public void onRight(MouseMovationEvent mouseMovationEvent){
        System.out.println("鼠标右划");
    }
}

