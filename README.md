1) Configure mysql properties in ```application.properties```
2) Run application to initialize table of books
3) Execute this query to local mySQL database:
```USE books;
INSERT INTO books(title, author, release_year, average_rating)
VALUES ("Animal Farm", "George Orwell", 1945, 4.1),
("The Republic", "Plato", -375, 3.9),
("Thus Spoke Zarathustra", "Friedrich Nietzsche", 1883, 4.1),
("Friedrich Nietzsche", "George Orwell", 1949, 4.0),
("Crime and Punishment", "Fyodor Dostoevsky", 1866, 4.3),
("The Idiot", "Fyodor Dostoevsky", 1869, 4.2),
("One Hundred Years of Solitude", "Gabriel García Márquez", 1967, 4.1),
("The Stranger", "Albert Camus", 1942, 5.0),
("The Metamorphosis", "Franz Kafka", 1915, 3.9),
("The Castle", "Franz Kafka", 1915, 3.8),
("The Great Gatsby", "F. Scott Fitzgerald", 1924, 5.0),
("The Illiad", "Homer", -800, 5.0),
("Don Quixote", "Miguel de Cervantes", 1605, 3.9),
("Dievų miškas", "Balys Sruoga", 1957, 4.9),
("Meditations", "Miguel de Cervantes", 121, 4.5);
````


Filter querying is done by query parameters.

Example endpoints
1) Find All ```http://localhost:8080/books```
2) Set user rating ```http://localhost:8080/books/{id}``
2) Filter by year ```http://localhost:8080/books?minYear=1900&maxYear=2000```
3) Filter by average rating ```http://localhost:8080/books?minRating=4&maxRating=5```
4) Filter by average user rating ```http://localhost:8080/books?minUserRating=3&maxUserRating=5```

Can filter by multiple different parameters.