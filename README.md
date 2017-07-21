# EcommerceBackend

##Ecommerce Backend Setup

----> Running the Backend Project

1 - Download the project and import it from the Eclipse IDE.
    Another possible option would be deploy the generated 'war'/'jar'
    file to a Tomcat Web Server( not tested yet )
    
2 - It's necessary a pre installed PostgresSql database.
    The username and password for access the datatase should
    the defalt ones:  username = postgres, password = postgres.
    A database with name 'maindb' needs to be created.
    
    OBS: The configurations above can be adjusted in the 
    /resources/hibernate.cfg.xml file.
    
    
2 - In the eclipse IDE wait for the maven depencies to be downloaded.
    
3 - Run the project as an Java Application, or click the green button
    on the ide top.
    
4 - The aplication uses Spring Boot wich has a Tomcat embedded server.
    Wait for the application to load and the backend Api's can now
    be acessed.




##Ecommerce Backend API Documentation.

----------------------------------------------
Description: Adds a new Product.

POST http://localhost:8080/product/new

HEADERS
Content-Typeapplication/json

BODY
{
    "nome": "Product xl",
    "valor": 33.01
}

----------------------------------------------
Description: Retrieves a product information,
             using its 'id'.

GET http://localhost:8080/product/get/:id

HEADERS
Content-Typeapplication/json

----------------------------------------------
Description: Updates a product information.             

PUT http://localhost:8080/product/update

HEADERS
Content-Typeapplication/json

BODY
{
    "id": 603,
    "nome": "New Name",
    "valor": 45.11
}

----------------------------------------------
Description: Returns all the products list. 

GET http://localhost:8080/product/list

HEADERS
Content-Typeapplication/json

----------------------------------------------
Description: Deletes a product using its 'id'.

DELETE http://localhost:8080/product/delete?id=301

HEADERS
Content-Typeapplication/json

----------------------------------------------
Description: Returns a list of ShoppingCart items

GET http://localhost:8080/shoppingcart/list

HEADERS
Content-Typeapplication/json

----------------------------------------------
Descrition: Creates a new item in the ShoppingCart

POST http://localhost:8080/shoppingcart/new

HEADERS
Content-Typeapplication/json

BODY
{ 
	"valor": 12.25, 
	"nome": "Produto 1", 
	"id": 679, 
	"amount": 2
	
}

----------------------------------------------
Description: Deletes a ShoppingCart item using its 'id'.

DELETE http://localhost:8080/shoppincart/delete?id=704

HEADERS
Content-Typeapplication/json
