package com.sino.pattern.event;

import java.util.EventObject;

/**
 * 事件源 添加删除监听器  触发事件
 */
class Page{

    private LoadPageListener loadPageListener;
    private ClickListener clickListener;
    private MouseMovationListener mouseMovationListener;

    //为自身注册事件监听器
    public void addLoadPageListener(LoadPageListener loadPageListener){
        this.loadPageListener = loadPageListener;
    }

    public void addClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    public void addMouseMovationListener(MouseMovationListener mouseMovationListener){
        this.mouseMovationListener = mouseMovationListener;
    }
    
    //触发事件
    public void trigger(EventObject e){

        //判断事件类型，确定使用的事件监听器类，并且确定调用事件监听器类的哪个方法。
        if(e instanceof LoadPageEvent){
            LoadPageEvent le = (LoadPageEvent)e;
            switch(le.getId()){
                case LoadPageEvent.PAGELOAD_CLOSE:this.loadPageListener.onClose(le);break;
                case LoadPageEvent.PAGELOAD_ERROR:this.loadPageListener.onError(le);break;
                case LoadPageEvent.PAGELOAD_START:this.loadPageListener.onStart(le);break;
                case LoadPageEvent.PAGELOAD_SUCCESS:this.loadPageListener.onSuccess(le);break;
            }
        }
        else if(e instanceof ClickEvent){
            ClickEvent ce = (ClickEvent)e;
            switch(ce.getId()){
                case ClickEvent.DOUBLE_CLICK:this.clickListener.onDouble(ce);break;
                case ClickEvent.SINGLE_CLICK:this.clickListener.onSingle(ce);break;
            }
        }
        else if(e instanceof  MouseMovationEvent){
            MouseMovationEvent me = (MouseMovationEvent)e;
            switch(me.getId()){
                case MouseMovationEvent.MOVE_LEFT:this.mouseMovationListener.onLeft(me);break;
                case MouseMovationEvent.MOVE_RIGHT:this.mouseMovationListener.onRight(me);break;
            }
        }
    }
}
