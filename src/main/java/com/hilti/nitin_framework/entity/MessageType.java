package com.hilti.nitin_framework.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageType {
    private String content;
    
    public MessageType(String content){
        this.content = content;
    }

    @Override
    public boolean equals(Object m2){
        if(m2 instanceof MessageType){
            return content.equals(((MessageType)m2).content);
        }
        else{
            return false;
        }
    }

}
