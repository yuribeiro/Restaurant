package com.restaurant.sirenarestaurant.controllers;

import com.restaurant.sirenarestaurant.entities.Order;
import com.restaurant.sirenarestaurant.entities.MenuItem;
import com.restaurant.sirenarestaurant.entities.TableOrder;
import com.restaurant.sirenarestaurant.entities.MainCommands;

import com.restaurant.sirenarestaurant.repositories.OrderRepository;
import com.restaurant.sirenarestaurant.repositories.MenuRepository;
import com.restaurant.sirenarestaurant.repositories.TableRepository;
import com.restaurant.sirenarestaurant.repositories.MainCommandsRepository;


import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/sirenarestaurants")
public class MenuController {

    // Instance fields
    private MenuRepository menuRepository;
    private OrderRepository orderRepository;
    private TableRepository tableRepository;
    private MainCommandsRepository mainCommandsRepository;

    // Constructor Method
    public MenuController(
        MenuRepository menuRepository,
        OrderRepository orderRepository,
        TableRepository tableRepository,
        MainCommandsRepository mainCommandsRepository){

        this.menuRepository = menuRepository; 
        this.orderRepository = orderRepository; 
        this.tableRepository = tableRepository;
        this.mainCommandsRepository = mainCommandsRepository;
    }

    /*Returns a list of commands
     * localhost:8080/sirenarestaurants/commands
    */
    @GetMapping("/commands")
    public Iterable<MainCommands> getAllCommands(){return this.mainCommandsRepository.findAll();}
    
    /* Returns a list of menu item options
     *  localhost:8080/sirenarestaurants/menu 
    */
    @GetMapping("/menu")
    public Iterable<MenuItem> getAllItems(){return this.menuRepository.findAll();}

    /* Returns a list of orders
     *  localhost:8080/sirenarestaurants/orders
    */
    @GetMapping("/orders")
    public Iterable<Order> getAllOrders(){return this.orderRepository.findAll();}

    /* Return a list of Tables closed or open
     *  localhost:8080/sirenarestaurants/tables
    */
    @GetMapping("/tables")
    public Iterable<TableOrder> getAllTableORders(){return this.tableRepository.findAll();}

    /* Returns a list of tables by table number
     *  localhost:8080/sirenarestaurants/table/1 - Return total order from table Integer 1
     *  localhost:8080/sirenarestaurants/table/2 - Return total order from table Integer 2
     *  localhost:8080/sirenarestaurants/table/3 - Return total order from table Integer 3
     *  localhost:8080/sirenarestaurants/table/4 - Return total order from table Integer 4
     *  localhost:8080/sirenarestaurants/table/5 - Return total order from table Integer 5
    */
    @GetMapping("/table/{id}")
    public Iterable<Order> getTotalTableOrder(@PathVariable("id") Integer id){

        // Get table orders by id
        Optional<TableOrder> tableOptional = this.tableRepository.findById(id);

        if(!tableOptional.isPresent()){
            return null;
        }

        // Get Order by id
        Optional<Order> orderOptional = this.orderRepository.findById(id);

        if(!orderOptional.isPresent()){
            return null;
        }
        return this.orderRepository.getListByNumberTable(id);

    }

    /* Switch table status to open, to receive orders or closed to close the table, to not receive orders
     *  OPEN TABLE - To open table for orders
     *  curl -X PUT localhost:8080/sirenarestaurants/table/X
     *  -H "Content-Type: application/json"
     *  -d "{\"statusTable\": \"open\"}"
     * 
     * CLOSE TABLE - To close table for orders 
     *  curl -X PUT localhost:8080/sirenarestaurants/table/X
     *  -H "Content-Type: application/json"
     *  -d "{\"statusTable\": \"closed\"}"
    */
    @PutMapping("/table/{id}")
    public TableOrder openOrCloseTables(@RequestBody TableOrder tableOrder, @PathVariable("id") Integer id){
        
        // Get table orders by id
        Optional<TableOrder> tableOptional = this.tableRepository.findById(id);

        if(!tableOptional.isPresent()){
            return null;
        }

        TableOrder getTable = tableOptional.get();

        // Set Status Table
        if(getTable.getStatusTable()!=null){
            getTable.setStatusTable(tableOrder.getStatusTable());}

        // Set Total Table
        if(getTable.getTotalTable()!=null){
            getTable.setTotalTable(tableOrder.getTotalTable());}
        else{
            getTable.setTotalTable(0.0);
        }

        // Open or Close table
        if(tableOrder.getStatusTable()== "closed"){getTable.setTotalTable(0.0);}

        TableOrder updatedTable = this.tableRepository.save(getTable);
        return updatedTable;
    }

    // Get the total balance for table
    /*  localhost:8080/sirenarestaurants/table/total/1 - table 1
     *  localhost:8080/sirenarestaurants/table/total/2 - table 2
     *  localhost:8080/sirenarestaurants/table/total/3 - table 3
     *  localhost:8080/sirenarestaurants/table/total/4 - table 4
     *  localhost:8080/sirenarestaurants/table/total/5 - table 5
    */
    @GetMapping("/table/total/{id}")
    public TableOrder getTotalSoldFromTable(@PathVariable("id") Integer id){

        // Get table orders by id
        Optional<TableOrder> totalOptional = this.tableRepository.findById(id);
        if(!totalOptional.isPresent()){return null;}

        TableOrder totalOrder = totalOptional.get();

        return totalOrder;
        
    }
    
    /* Return a list of menu categories
     *  localhost:8080/sirenarestaurants/menu/categories
    */
    @GetMapping("/menu/categories")
    public List<Map<String, String>> getAllCategories(){
        
        Iterable<MenuItem> iterableMenuItem = this.menuRepository.findAll();  
        Set<String> uniqueCategories = new HashSet<>();      
        List<Map<String, String>> categories = new ArrayList<>();

        // Iterates over each item in iterableMenuItem
        for (MenuItem menuItem : iterableMenuItem) {
            String category = menuItem.getCategory();

            // Check if the category has already been added
            if (!uniqueCategories.contains(category)) {
                uniqueCategories.add(category);

                // Create a Map with the "category" property
                Map<String, String> categoryMap = new HashMap<>();
                categoryMap.put("category", category);
                categoryMap.put("items", "localhost:8080/sirenarestaurants/menu/category/" + category);
                categories.add(categoryMap);
            }
        }
        return categories;
    
    }

    /* Returns a item list by category 
     *  localhost:8080/sirenarestaurants/menu/appetizers
     *  localhost:8080/sirenarestaurants/menu/desserts
     *  localhost:8080/sirenarestaurants/menu/drinks
     *  localhost:8080/sirenarestaurants/menu/main course
    */
    @GetMapping("/menu/{category}")
    public Iterable<MenuItem> getByCategory(@PathVariable String category){return this.menuRepository.findByCategory(category.toLowerCase());}

    /* Add a new order (numberTable: 1 to 5, itemNumber: 1 to 20, unitOrder: X)
     *  curl -X POST localhost:8080/sirenarestaurants/orders
     *  -H "Content-Type: application/json"
     *  -d "{\"numberTable\": Integer,  \"itemNumber\": Integer, \"unitOrder\": Integer"}"
    */
    @PostMapping("/orders")
    public TableOrder addNewOrder(
        @RequestBody Order order
    ){     
        // Get table orders by id
        Optional<TableOrder> tableOptional = this.tableRepository.findById(order.getNumberTable());

        // get table from tables
        TableOrder verifyStatusTable = tableOptional.get();

        // get status from table (open or closed)
        String status = verifyStatusTable.getStatusTable();

        if(!tableOptional.isPresent()){
            return null;
        }

        // save a new order if the table is opened
        if(status.equals("open")){

            // Add order
            Order addOrder = order;

            // getter methods addOrder
            Integer numItem =  addOrder.getItemNumber(); // get item number
            Integer unitItem = addOrder.getUnitOrder(); // get item unity


            // Get menu item by id
            Optional<MenuItem> itemOptional = this.menuRepository.findById(numItem);

            // get item form menu
            MenuItem item = itemOptional.get();

            // get String item menu
            String nameItem = item.getItem();
            // get Double value price item menu
            Double valuePriceItem = item.getPrice();
            // get Double total value price order
            Double totalPrice = valuePriceItem * unitItem;

            if(addOrder.getItem()==null || addOrder.getItem().isEmpty()){addOrder.setItem(nameItem);} // set item name
            if(addOrder.getPrice()==null){addOrder.setPrice(totalPrice);} // set total price order

            // Update table order to save
            // get order Updated
            Order updatedOrder = addOrder;

            // Saving new order 
            this.orderRepository.save(updatedOrder);  

            // UPDATE TOTAL BALANCE

            // Get table orders by id
            Optional<TableOrder> tableOrderOptional = this.tableRepository.findById(addOrder.getNumberTable());

            // Get table order
            TableOrder updateBalanceTable = tableOrderOptional.get();

            // Get current total balance
            Double currBalanceTable = updateBalanceTable.getTotalTable();
            
            // Set the new table balance
            updateBalanceTable.setTotalTable(currBalanceTable+=totalPrice); // set a new balance total in table 

            // Set balance updated
            TableOrder updatedTableOrder = updateBalanceTable;

            // Save balance updated in repository
            return this.tableRepository.save(updatedTableOrder);
            }else{
                return null;
        }

    }   
    
    /* Delete order
     *  localhost:8080/sirenarestaurants/order/X/paid - for order paid
     *  localhost:8080/sirenarestaurants/order/X/wrong - for wrong orders
    */
    @DeleteMapping("/order/{id}/{reason}")
    public String removeOrder(
        @PathVariable("id") Integer id,
        @PathVariable("reason") String reason){

        // Get orders by id
        Optional<Order> orderOptional = this.orderRepository.findById(id);


        if(!orderOptional.isPresent()){return null;}

        // order to delete
        Order orderToDelete = orderOptional.get();

        if(reason.equals("paid") || reason.equals("wrong")){
            this.orderRepository.delete(orderToDelete);
        }else{
            return null;
        }
        return "Order: " + orderToDelete.getId() + " Item: " + orderToDelete.getItem() + " was deletede because the order was " + reason;

    }

    /* Add a new Table 
     *  curl -X POST localhost:8080/sirenarestaurants/tables
     *  -H "Content-Type: application/json" -d "{}"
    */
    @PostMapping("/tables")
    public TableOrder addNewTable(@RequestBody TableOrder tableOrder){
        if(tableOrder.getStatusTable()==null){
            tableOrder.setStatusTable("closed");
        }
        if(tableOrder.getTotalTable()==null){
            tableOrder.setTotalTable(0.0);
        }

        TableOrder tableAdded = tableOrder;
        return this.tableRepository.save(tableAdded);
    }

    /* Remove a table from the table list
     *  curl -X DELETE localhost:8080/sirenarestaurants/tables/ X
    */
    @DeleteMapping("/table/{id}")
    public String removeTable(@PathVariable("id") Integer id){
        Optional<TableOrder> tableOptional = this.tableRepository.findById(id);
        if(!tableOptional.isPresent()){return null;}

        TableOrder tableToDelete = tableOptional.get();
        String result = "";

        if(tableToDelete.getId()<6){
            result = " Can't be removed";
        }

        if(tableToDelete.getId()>5){
            result = " Was Deleted";
            this.tableRepository.delete(tableToDelete);
            
        }
        return "Table: " + tableToDelete.getId() + result;
        
    }
    
    /* Add menu item
     *  curl -X POST localhost:8080/sirenarestaurants/menu
     *  -H "Content-Type: application/json"
     *  -d "{\"category\": String, \"item\": String, \"description\": String, \"price\": Double}"
    */
    @PostMapping("/menu")
    public MenuItem addNewItem(@RequestBody MenuItem menuItem){
        return this.menuRepository.save(menuItem);
    }

    /*Delete menu item
     * curl -X DELETE localhost:8080/sirenarestaurants/menu/X
    */
    @DeleteMapping("/menu/{id}")
    public String deleteItem(@PathVariable("id") Integer id){
        Optional<MenuItem> itemOptional = this.menuRepository.findById(id);

        if(!itemOptional.isPresent()){return null;}

        MenuItem deleteItem = itemOptional.get();
        this.menuRepository.delete(deleteItem);
        return "Id Item: " + deleteItem.getItemNumber() + "Name Item: " + deleteItem.getItem() + " was deleted";

    }
}