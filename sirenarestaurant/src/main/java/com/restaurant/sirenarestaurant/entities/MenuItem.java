package com.restaurant.sirenarestaurant.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="MENU")
public class MenuItem{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemNumber;

    // Category Column
    @Column(name="CATEGORY")
    private String category;

    // Item Column
    @Column(name="ITEM")
    private String item;

    // Description Column
    @Column(name="DESCRIPTION")
    private String description;

    // Price Column
    @Column(name="PRICE")
    private Double price;


    /* Getter Methods
     * getItemNumber, getCategory, getItem, getDescription, getSymbol, getPrice.
    */

    // getItemNumber
    public Integer getItemNumber(){return this.itemNumber;}


    // getCategory
    public String getCategory(){return this.category;}

    // getItem
    public String getItem(){return this.item;}

    // getDescription
    public String getDescription(){return this.description;}

    // getPrice
    public Double getPrice(){return this.price;}

    /* Setter Methods
     * setId, setItem, setDescription, setSymbol,setPrice.
    */

    // setItemNumber 
    public void setItemNumber(Integer itemNumber){this.itemNumber = itemNumber;}

    // setCategory
    public void setCategory(String category){this.category = category;}

    // setItem
    public void setItem(String item){this.item = item;}

    // setDescription
    public void setDescription(String description){this.description = description;}

    // setPrice
    public void setSymbol(Double price){this.price = price;}

}
