1. RESTful Book Store API :
        A Spring Boot–based RESTful application to manage Books and Authors with full CRUD operations, pagination, sorting, filtering, global exception handling, DTO mapping, and Swagger documentation.

2. Tech Stack :
          Spring Boot
          Spring Data JPA
          Hibernate/JPA
          MySQL (or any JPA-supported DB)
          Swagger OpenAPI
          Postman (for testing)

3. Configure Database (application.properties)  :
          spring.datasource.url=jdbc:mysql://localhost:3306/bookstore
          spring.datasource.username=root
          spring.datasource.password=yourpassword
          spring.jpa.hibernate.ddl-auto=update
4. Run Application :
          mvn spring-boot:run
5. Features :
    Book Module:
            Create new book
            Get book by ID
            Get all books
            Update book
            Delete book
            Pagination
            Sorting (id, title, price, authorId)
            Search / filter by title

    Author Module :
            Create author with book
            Create author without book
            Get author by ID
            Get all authors
            Pagination
            Common Features
            DTOs for clean API responses

6. Common Features :
            DTOs for clean API responses
            Global exception handling
            Separate layered architecture
            Swagger UI documentation
            Postman collection included
            Global exception handling
            Separate layered architecture
            Swagger UI documentation
            Postman collection included
            
7. Project Structure :
            
            src/main/java/com/example
            │
            ├── configuration
            │   └── SwaggerConfig.java
            │
            ├── controller
            │   ├── AuthorController.java
            │   └── BookController.java
            │
            ├── DTO
            │   ├── ApiErrorResponse.java
            │   ├── AuthorDTO.java
            │   ├── AuthorResponseDTO.java
            │   ├── AuthorWithoutBookDTO.java
            │   ├── BookDTO.java
            │   ├── BookResponseDTO.java
            │   └── BookWithAuthorDTO.java
            │
            ├── entity
            │   ├── Author.java
            │   └── Book.java
            │
            ├── exception
            │   ├── GlobalExceptions.java
            │   └── ResourcesNotFoundException.java
            │
            ├── repository
            │   ├── AuthorRepository.java
            │   └── BookRepository.java
            │
            ├── service
            │   ├── AuthorService.java
            │   └── BookService.java
            │
            └── serviceImpl
                ├── AuthorServiceImpl.java
                └── BookServiceImpl.java

8. API Endpoints :
              Book APIs :

                    | Method | Endpoint                | Description                                    |
                    | ------ | ----------------------- | ---------------------------------------------- |
                    | GET    | `/api/book/{id}`        | Get book by ID                                 |
                    | GET    | `/api/book/all-books`   | Get all books (pagination + sorting supported) |
                    | POST   | `/api/book/create-book` | Create new book                                |
                    | PUT    | `/api/book/{id}`        | Update book                                    |
                    | DELETE | `/api/book/{id}`        | Delete book                                    |


              Author APIs :
                    | Method | Endpoint                                 | Description                     |
                    | ------ | ---------------------------------------- | ------------------------------- |
                    | GET    | `/api/author/{id}`                       | Get author by ID                |
                    | GET    | `/api/author/all-authors`                | Get all authors with pagination |
                    | POST   | `/api/author/create-author-with-book`    | Insert author with book         |
                    | POST   | `/api/author/create-author-without-book` | Insert author without book      |
9. Pagination & Sorting
            Books Pagination Example
                    GET /api/book/all-books?pageNo=0&pageSize=5
            Sorting Books :
                    GET /api/book/all-books?pageNo=0&pageSize=10&sortBy=title&sortDir=asc
            Filtering by Title :
                    GET /api/book/all-books?title=English
            Author Pagination :
                    GET /api/author/all-authors?pageNo=0&pageSize=5
10. Postman Collection :
            Postman collection includes :
                    All Book
                    Get Book by ID
                    Delete Book
                    Create Book
                    Get Authors
                    Get Author by ID
                    Create Author With Book
                    Create Author Without Book
11. Swagger UI : 
      Swagger is enabled for API testing and documentation.
      URL: http://localhost:8080/api-docs




