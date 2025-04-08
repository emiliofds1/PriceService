Prices API - Spring Java Application
====================================
Welcome to the Prices API! This REST API allows you to query product prices based on the product ID, brand ID, and query date. It's built using Spring Boot and follows the OpenAPI 3.0 specification, making it easy to integrate and document.

🚀 Features
-----------
* Retrieve Product Prices: Get the price of a product based on its ID, the brand ID, and the query date.
* OpenAPI 3.0 Documentation: Fully documented to help you integrate quickly and clearly.
* Automatic Code Generation: Uses OpenAPI Generator to create controllers and DTOs from the YAML specification.

🛠️ API Endpoints
-----------------
**GET /price**

**Description**:
Retrieve the price of a product based on the product ID, brand ID, and the query date.

**Query Parameters**:
- `productId` (required): The unique ID of the product.
- `brandId` (required): The ID of the brand associated with the product.
- `date` (required): The date and time for which the price is being queried (format: yyyy-MM-dd'T'HH:mm:ss'Z').

**Example Request**:
```
GET /price?productId=35455&brandId=1&date=2020-12-31T23:59:59Z
```

**Responses**:
- **200 OK**: Successfully retrieved the price.
```json
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 1,
  "price": 35.50
}
```
- **400 Bad Request**: Missing or invalid parameters.
```json
{
  "code": 400,
  "message": "Invalid request parameters."
}
```
- **404 Not Found**: Product not found.
```json
{
  "code": 404,
  "message": "Product with id 35455 not found"
}
```

🔧 Installation and Setup
-------------------------
To run the application locally, follow these steps:

**Prerequisites**
- Java 17 or higher
- Maven for building the project
- Spring Boot for the application framework

**Steps to Run**
1. Clone the repository:
```
git clone https://github.com/emiliofds1/PriceService.git
cd pricesService
```

2. Build the project with Maven:
```
mvn clean install
```

3. Run the application:
```
mvn spring-boot:run
```

Your API should now be running locally at [http://localhost:8080](http://localhost:8080).

📚 OpenAPI Code Generation
-------------------------
This project is configured to automatically generate controllers and DTOs from an OpenAPI specification (located in the prices_api.yml file) using the OpenAPI Generator plugin. This ensures that the code stays up-to-date with the latest specification.

The OpenAPI specification file is located at:
```css
src/main/resources/static/openapi/prices_api.yml
```

To regenerate the code for controllers and DTOs, run the following Maven command:
```
mvn clean generate-sources
```

🛠️ Dependencies and Tools
-------------------------
**Key Dependencies**:
- Spring Boot: Framework used for building the application.
- springdoc-openapi: Library that automatically generates the OpenAPI documentation.
- OpenAPI Generator: Generates controllers and models from the OpenAPI specification.

**Maven Plugins**:
- spring-boot-maven-plugin: For building and running the Spring Boot application.
- openapi-generator-maven-plugin: For generating controllers and DTOs from the OpenAPI specification.
- jacoco-maven-plugin: For test coverage analysis.
- maven-surefire-plugin: For running tests.

**Example OpenAPI Specification**:
The OpenAPI contract is defined in the prices_api.yml file and follows the OpenAPI 3.0 standard. You can inspect and modify it to suit your needs.

🧪 Testing
-----------
To run tests for the project, use the following command:
```
mvn test
```