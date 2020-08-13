package com.dxctraining.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Itemlist")
public class Item {

    @Id
    @GeneratedValue
private int id;
private String name;

 public Item(int id, String name) {
	 this.id=id;
	 this.name=name;
	 
 }
 public Item() {
 
 }

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
@Override
public boolean equals(Object arg) {
		if(this==arg) {
			return true;
		}
		
	   if(arg==null || !(arg instanceof Item) ) {
			return false;
	   }
		
	Item that=(Item)arg;	
		boolean isequal=this.id==that.id;
		return isequal;
	}

@Override
public int hashCode() {
    return id;
}

}
