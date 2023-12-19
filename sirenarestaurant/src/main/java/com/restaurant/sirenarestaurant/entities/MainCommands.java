package com.restaurant.sirenarestaurant.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="COMMANDS")
public class MainCommands {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Function column
    @Column(name="FUNCTION")
    private String function;

    /* Type Column
     *  type: curl or URL
    */
    @Column(name="TYPE")
    private String type;

    /* Code Column
     *  Code text to command
    */
    @Column(name="CODE")
    private String code;

    /* Getter Methods
     *  getId,getFunction, getType, getCode
    */

    // getId
    public Integer getId(){return this.id;}

    // getFunction
    public String getFunction(){return this.function;}

    // getType
    public String getType(){return this.type;}

    // getCode
    public String getCode(){return this.code;}

    /* Setter Methods
     *  setId, setFunction, setType, setCode
    */

    // setId
    public void setId(Integer id){this.id = id;}

    // setFunction
    public void setFunction(String function){this.function = function;}
    
    // setType
    public void setType(String type){this.type = type;} 

    // setCode
    public void setCode(String code){this.code = code;}

}