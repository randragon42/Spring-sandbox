# Spring-sandbox

## How to Run
### Set Up
Before running **myRetail RESTful service**, ensure that Mongo is installed and running locally.
You can follow the instructions at [https://docs.mongodb.com/manual/installation/](https://docs.mongodb.com/manual/installation/)
for your operating system.

Once Mongo is up and running open the Project in your IDE and run **MyRetailRestfulServiceApplication**.
In IntelliJ IDEA, this is done by right clicking the class located at **src>main>java>com.myretail>MyRetailResfulServiceApplication**

### Usage
Once the app is running, a browser can be used to test the GET endpoints at localhost:8080/products/{id}, where {id} is the id of
a product you are looking up. A GET for a product id that exists will return a JSON object about that product such as the one below.
```
{
    "id": "13860428",
    "item": {
        "product_description": {
            "title": "The Big Lebowski (Blu-ray)"
        }
    },
    "price": {
        "value": 42.15,
        "currency_code": "USD"
    }
}
```

Valid GET: [localhost:8080/products/13860428](http://localhost:8080/products/13860428)

Invalid GET: [localhost:8080/products/15117729](http://localhost:8080/products/15117729)

A Postman collection has also been included [here](https://github.com/randragon42/Spring-sandbox/blob/master/My%20Retail%20Restful%20Service.postman_collection.json)
for testing both the GET and PUT endpoints of this service. 

Simply download the file from the link (or find it in the root of this repository), and import it into Postman.

## How to Test
To run all tests in IntelliJ IDEA, right click on **com.myretail** and select *Run 'Tests in 'com.myretail''*
