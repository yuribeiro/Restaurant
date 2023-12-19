package com.restaurant.sirenarestaurant.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="TABLE_CLIENT")
public class TableOrder {
    
    // Column table number
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Column name table status - "open" or "closed"
    @Column(name="STATUS_TABLE")
    private String statusTable;

    // Column name total - Sald orders
    @Column(name="TOTAL_TABLE")
    private Double totalTable = 0.0;


    /*Getter Methods
     * getId, getStatusTable, getTotalTable
    */

    // getId
    public Integer getId(){return this.id;}

    // getStatusTable -  "open" or "closed"
    public String getStatusTable(){return this.statusTable;}

    // getTotalTable
    public Double getTotalTable(){return this.totalTable;}

    /*Setter Methods
     * setId, setStatusTable, setTotalTable
    */

    // setId - 1 - 5
    public void setId(Integer id){this.id = id;}

    // setStatusTable -  "open" or "closed"
    public void setStatusTable(String statusTable){this.statusTable = statusTable;}

    // setTotalTable
    public void setTotalTable(Double totalTable){this.totalTable = totalTable;}
}

