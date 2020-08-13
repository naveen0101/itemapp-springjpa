package com.dxctraining.ui;

import com.dxctraining.entities.Item;
import com.dxctraining.exceptions.ItemNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Ui {
    @Autowired
    private Service service;


    @PostConstruct
    public void runUi(){
        try {
        	Item item1 = new Item("pen");
        	Item item2 = new Item("book");
        	item1 = service.save(item1);
        	item2 = service.save(item2);

            int id1 = item1.getId();
            Item fetched = service.findItemById(id1);
            System.out.println("fetched iteam =" + fetched.getName() );
        }catch (ItemNotFoundException e){
            e.printStackTrace();
        }

        catch (InvalidArgumentException e){
            e.printStackTrace();
        }
    }



}