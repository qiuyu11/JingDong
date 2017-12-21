package com.example.jingdong.eventbus;

/**
 * 作者：邱宇
 * 时间：2017-12-13 20:20
 * 类的用途：
 */

public class MessageEvent {
    private boolean checked;

    public boolean ischecked(){
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
