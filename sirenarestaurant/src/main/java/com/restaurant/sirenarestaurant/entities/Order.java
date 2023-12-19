package com.restaurant.sirenarestaurant.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NUMBER_TABLE")
    private Integer numberTable;

    @Column(name="ITEM_NUMBER")
    private Integer itemNumber;

    @Column(name="NUMBER_ITEM")
    private String item;

    @Column(name="UNIT_ITEM")
    private Integer unitOrder;

    @Column(name="PRICE")
    private Double price;

    

    /*Getter Methods
     * getId, getNumberTable, getItemNumber, getItem, getUnitOrder, getPrice
    */

    // getID
    public Integer getId(){return this.id;}
    
    // getNumberTable
    public Integer getNumberTable(){return this.numberTable;}

    // getItemNumber
    public Integer getItemNumber(){return this.itemNumber;}

    // getItem
    public String getItem(){return this.item;}

    // getUnitOrder
    public Integer getUnitOrder(){return this.unitOrder;}

    // getPrice
    public Double getPrice(){return this.price;}


    /* Setter Methods
     * setId, setNumberTable, setNameOrder,setItem, setUnitOrder
    */

    // setId
    public void setId(Integer id){this.id = id;}

    // setNumberTable
    public void setNumberTable(Integer numberTable){ this.numberTable = numberTable;}
  
    // setItemNumber
    public void setItemNumber(Integer itemNumber){this.itemNumber = itemNumber;}

    // setItem
    public void setItem(String item){this.item = item;}

    // setUnitOrder
    public void setUnitOrder(Integer unitOrder){this.unitOrder = unitOrder;}

    // setPrice
    public void setPrice(Double price){this.price = price;}

}
