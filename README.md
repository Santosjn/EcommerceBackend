# EcommerceBackend

Ecommerce Backend API Documentation.

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

DELETE http://localhost:8080/product/delete/:id

HEADERS
Content-Typeapplication/json

----------------------------------------------