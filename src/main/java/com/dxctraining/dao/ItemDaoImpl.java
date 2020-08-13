package com.dxctraining.dao;

import com.dxctraining.entities.Item;
import com.dxctraining.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ItemDaoImpl implements IItemDao{

    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Item findItemById(int idArg) {
        Item item=entityManager.find(Item.class,idArg);
        if(item==null){
            throw new ItemNotFoundException("item not found for id="+idArg);
        }
        return item;
    }

    @Override
    public Item update(Item item) {
       item=entityManager.merge(item);
        return item;
    }

    @Override
    public Item save(Item item) {
        entityManager.persist(item);
        return item;
    }

    @Override
    public void remove(int id) {
     Item item= findItemById(id) ;
     entityManager.remove(item);
    }

   
}