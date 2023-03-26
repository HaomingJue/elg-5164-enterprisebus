# elg5164-enterprisebus-microservice
This is a microservice for managing accounts, products, and orders in a SOA microservice architecture e-commerce platform. The microservice provides APIs for performing CRUD operations on those three services and monitor them.
## API Endpoints
### Account Service
Get all accounts: 
```
[Get] <Base URL>/accounts
```
Get account by ID:
```
[Get] <Base URL>/accounts/<id>
```
Create a account:
```
[Post] <Base URL>/accounts
```
```
request body
{
    "username": "testname",
    "password": "1"
}
```
Creates a new account. The request body should be a JSON object containing the following fields:

- `username` (string, required): The username of the new account.
- `password` (string, required): The password of the new account.

Delete account by ID:
```
[Delete] <Base URL>/accounts/<id>
```
Delete all accounts:
```
[Delete] <Base URL>/accounts
```
### Product Service
Get all products: 
```
[Get] <Base URL>/products
```
Get product by ID:
```
[Get] <Base URL>/products/<id>
```
Create a product:
```
[Post] <Base URL>/products
```
```
request body
{
    "productName": "testname",
    "userId": "1",
    "description": "test description number 1",
    "price": "232"
}
```
Creates a new product. The request body should be a JSON object containing the following fields:

- `productName` (string, required): The name of the product.
- `userId` (number, required): The ID of the user who created the product.
- `description` (string, optional): A description of the product.
- `price` (number, required): The price of the product.

Delete product by ID:
```
[Delete] <Base URL>/products/<id>
```
Delete all products:
```
[Delete] <Base URL>/products
```
### Order Service
Get all orders: 
```
[Get] <Base URL>/orders
```
Get order by ID:
```
[Get] <Base URL>/orders/<id>
```
Create a order:
```
[Post] <Base URL>/orders
```
```
request body
{
    "productName": "testname",
    "postUserId": "1",
    "purchaseUserId": "2"
}
```
Creates a new order. The request body should be a JSON object containing the following fields:

- `productName` (string, required): The name of the product in the order.
- `postUserId` (number, required): The ID of the user who created the order.
- `purchaseUserId` (number, required): The ID of the user who purchased the order.

Delete order by ID:
```
[Delete] <Base URL>/orders/<id>
```
Delete all orders:
```
[Delete] <Base URL>/orders
```
### Monitor Service
Get monitor of CPU usage: 
```
[Get] <Base URL>/cpu-usage
```
## Getting Started

To get a local copy up and running follow these simple steps:

1. Clone the repository.
2. Build the project with Maven: `mvn clean install`.
3. Run the application: `java -jar target/elg5164-account-microservice-1.0.0.jar`.
4. Test the API endpoints using a tool like [Postman](https://www.postman.com/) or `curl`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
