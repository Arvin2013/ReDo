package com.buaa.arvin.mobilemsg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangmu on 2015/12/29.
 */
public class Contact {

    private String name;
    public Contact(){

    }
    public String getName(){
    return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Contact> generateSampleList(){
        List<Contact> list = new ArrayList<>();
        for (int i = 0 ;i<30;i++){
            Contact contact = new Contact();
            contact.setName("Name -" +i);
            list.add(contact);
        }
        return list;
    }
}
