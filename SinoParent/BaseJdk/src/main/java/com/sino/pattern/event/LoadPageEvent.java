package com.sino.pattern.event;

import java.util.EventObject;

/**
 *事件对象-页面加载
 */
class LoadPageEvent extends EventObject{

    
	private static final long serialVersionUID = 1L;

	private int id; //表示具体事件的类型

    public static final int PAGELOAD_SUCCESS = 1;  //页面加载成功事件
    public static final int PAGELOAD_ERROR = 2; //页面加载失败事件
    public static final int PAGELOAD_START = 3; //页面开始加载事件
    public static final int PAGELOAD_CLOSE = 4; //页面关闭事件

    //建立LoadPageEvent实例对象，要指明具体的id类型，构造函数根据id来指定具体的事件类型
    public LoadPageEvent(Object source,int id){
        super(source);
        switch (id){
            case PAGELOAD_CLOSE:this.id = PAGELOAD_CLOSE;break;
            case PAGELOAD_ERROR:this.id = PAGELOAD_ERROR;break;
            case PAGELOAD_START:this.id = PAGELOAD_START;break;
            case PAGELOAD_SUCCESS:this.id = PAGELOAD_SUCCESS;break;
        }
    }

    public LoadPageEvent(Object source){
        super(source);
    }
    
    //获取事件的具体的事件类型
    public int getId(){
        return this.id;
    }
}

/**
 * 事件对象-点击事件
 */
class ClickEvent extends EventObject {
    
    
	private static final long serialVersionUID = 1L;

	//具体的事件类型
    private int id;

    public final static int SINGLE_CLICK = 1; //单击事件
    public final static int DOUBLE_CLICK = 2; //双击事件


    public ClickEvent(Object source){
        super(source);
    }

    //建立ClickEvent实例对象，要指明具体的id类型，构造函数根据id来指定具体的事件类型
    public ClickEvent(Object source,int id){
        super(source);
        switch(id){
            case SINGLE_CLICK:this.id = SINGLE_CLICK;break;
            case DOUBLE_CLICK:this.id = DOUBLE_CLICK;break;
        }
    }

    public int getId(){
        return this.id;
    }

}

/**
 * 事件对象-鼠标移动
 */

class MouseMovationEvent extends EventObject{
    
	private static final long serialVersionUID = 1L;

	//具体的事件类型
    private int id;

    public static final int MOVE_LEFT = 0; //鼠标左移事件
    public static final int MOVE_RIGHT = 1; //鼠标右移事件

    //建立MouseMovationEvent实例对象，要指明具体的id类型，构造函数根据id来指定具体的事件类型
    public MouseMovationEvent(Object source,int id){
        super(source);
        switch(id){
            case MOVE_LEFT:this.id = MOVE_LEFT;break;
            case MOVE_RIGHT:this.id = MOVE_RIGHT;break;
        }
    }

    public MouseMovationEvent(Object source){
        super(source);
    }

    public int getId(){
        return this.id;
    }
}

