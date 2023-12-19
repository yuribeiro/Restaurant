INSERT INTO MENU(CATEGORY, ITEM, DESCRIPTION, PRICE) 
VALUES
    ('appetizers', 'Seafood Platter', 'Assorted seafood including shrimp, oysters, and crab legs', 35.98),
    ('appetizers', 'Crispy Calamari', 'Fried calamari rings served with marinara sauce', 14.50),
    ('main course', 'Lobster Thermidor', 'Lobster cooked with a creamy white wine sauce', 55.00),
    ('main course', 'Grilled Swordfish', 'Swordfish steak grilled to perfection', 28.75),
    ('main course', 'Seafood Linguine', 'Linguine pasta with mixed seafood in garlic sauce', 19.98),
    ('drinks', 'Sea Breeze Cocktail', 'Vodka-based cocktail with cranberry and grapefruit juice', 10.98),
    ('drinks', 'White Wine - Chardonnay', 'Chardonnay wine to complement seafood dishes', 25.00),
    ('desserts', 'Key Lime Pie', 'Classic key lime pie with a graham cracker crust', 8.98),
    ('desserts', 'Sea Salt Caramel Gelato', 'Creamy gelato with swirls of sea salt caramel', 6.50),
    ('appetizers', 'Coconut Shrimp', 'Shrimp coated in coconut flakes, fried to golden perfection', 16.25),
    ('main course', 'Crab Stuffed Salmon', 'Salmon fillet stuffed with crab meat and baked', 32.50),
    ('drinks', 'Mango Tango Mocktail', 'Refreshing non-alcoholic drink with mango and citrus flavors', 7.98),
    ('appetizers', 'Tuna Poke Bowl', 'Marinated tuna served over rice with vegetables', 18.98),
    ('main course', 'Seafood Paella', 'Traditional Spanish rice dish with assorted seafood', 34.00),
    ('drinks', 'Sparkling Water - Perrier', 'Refreshing sparkling water', 3.50),
    ('desserts', 'Chocolate Lava Cake', 'Warm chocolate cake with a gooey chocolate center', 9.75),
    ('appetizers', 'Clam Chowder', 'Cream-based soup with clams and potatoes', 12.50),
    ('main course', 'Grilled Mahi-Mahi', 'Mahi-Mahi fish fillet grilled with herbs', 26.98),
    ('drinks', 'Craft Beer - IPA', 'India Pale Ale with a hoppy and citrusy flavor', 6.75),
    ('desserts', 'Tiramisu', 'Classic Italian dessert with coffee and mascarpone', 10.50);

INSERT INTO TABLE_CLIENT(STATUS_TABLE, TOTAL_TABLE)
VALUES
    ('closed', 0.0),
    ('closed', 0.0),
    ('closed', 0.0),
    ('closed', 0.0),
    ('closed', 0.0);

INSERT INTO COMMANDS(FUNCTION, TYPE, CODE)
VALUES
    ('Returns a list of commands', 'URL', 'localhost:8080/sirenarestaurants/commands'),
    ('Returns a list of menu item options', 'URL', 'localhost:8080/sirenarestaurants/menu'),
    ('Returns a list of orders', 'URL', 'localhost:8080/sirenarestaurants/orders'),
    ('Return a list of Tables closed or open', 'URL', 'localhost:8080/sirenarestaurants/tables'),
    ('Return total order from table Integer 1','URL','localhost:8080/sirenarestaurants/table/1'),
    ('Return total order from table Integer 2','URL','localhost:8080/sirenarestaurants/table/2'),
    ('Return total order from table Integer 3','URL','localhost:8080/sirenarestaurants/table/3'),
    ('Return total order from table Integer 4','URL','localhost:8080/sirenarestaurants/table/4'),
    ('Return total order from table Integer 5','URL','localhost:8080/sirenarestaurants/table/5'),
    ('Switch table status to open, to receive orders','CURL','curl -X PUT localhost:8080/sirenarestaurants/table/X'),
    ('Switch table status to close the table, to not receive orders','CURL','curl -X PUT localhost:8080/sirenarestaurants/table/X'),
    ('Get the total balance for table 1','URL','localhost:8080/sirenarestaurants/table/1'),
    ('Get the total balance for table 2','URL','localhost:8080/sirenarestaurants/table/2'),
    ('Get the total balance for table 3','URL','localhost:8080/sirenarestaurants/table/3'),
    ('Get the total balance for table 4','URL','localhost:8080/sirenarestaurants/table/4'),
    ('Get the total balance for table 5','URL','localhost:8080/sirenarestaurants/table/5'),
    ('Return a list of menu categories','URL','localhost:8080/sirenarestaurants/menu/categories'),
    ('Returns a item list by category Appetizers','URL','localhost:8080/sirenarestaurants/menu/appetizers'),
    ('Returns a item list by category Desserts','URL','localhost:8080/sirenarestaurants/menu/desserts'),
    ('Returns a item list by category Drinks','URL','localhost:8080/sirenarestaurants/menu/drinks'),
    ('Returns a item list by category Main Course','URL','localhost:8080/sirenarestaurants/menu/main course'),
    ('Add a new order - numberTable: 1 to 5 -  itemNumber: 1 to 20 - unitOrder: 1 to 99', 'CURL', 'curl -X POST localhost:8080/sirenarestaurants/table/X');