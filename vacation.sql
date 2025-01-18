CREATE DATABASE VacationDB;
USE VacationDB;

-- Table for Countries
CREATE TABLE Country (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table for Destinations
CREATE TABLE Destination (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES Country(id)
);

-- Table for Travel Types
CREATE TABLE TravelType (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table for Trip Types
CREATE TABLE TripType (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Table for Trips
CREATE TABLE Trip (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    photo VARCHAR(255),
    price_per_person DECIMAL(10, 2) NOT NULL,
    destination_id INT NOT NULL,
    travel_type_id INT NOT NULL,
    trip_type_id INT NOT NULL,
    FOREIGN KEY (destination_id) REFERENCES Destination(id),
    FOREIGN KEY (travel_type_id) REFERENCES TravelType(id),
    FOREIGN KEY (trip_type_id) REFERENCES TripType(id)
);

-- Table for Users
CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Table for Reservations
CREATE TABLE Reservation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    trip_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (trip_id) REFERENCES Trip(id)
);

-- Table for Travellers
CREATE TABLE Traveller (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    EGN VARCHAR(10) NOT NULL UNIQUE,
    age INT NOT NULL,
    phone VARCHAR(15),
    reservation_id INT NOT NULL,
    FOREIGN KEY (reservation_id) REFERENCES Reservation(id)
);

-- Insert Countries
INSERT INTO Country (name) VALUES ('France'), ('Italy'), ('USA');

-- Insert Destinations
INSERT INTO Destination (name, country_id) VALUES 
('Paris', 1), 
('Rome', 2), 
('New York', 3);

-- Insert Travel Types
INSERT INTO TravelType (name) VALUES ('Airplane'), ('Train'), ('Car');

-- Insert Trip Types
INSERT INTO TripType (name) VALUES ('Business'), ('Leisure'), ('Adventure');

-- Insert Trips
INSERT INTO Trip (name, start_date, end_date, photo, price_per_person, destination_id, travel_type_id, trip_type_id) VALUES
('Paris Business Trip', '2025-05-01', '2025-05-10', 'paris.jpg', 1500.00, 1, 1, 1),
('Rome Leisure Getaway', '2025-06-15', '2025-06-25', 'rome.jpg', 1200.00, 2, 2, 2),
('New York Adventure', '2025-07-10', '2025-07-20', 'newyork.jpg', 1800.00, 3, 1, 3);

-- Insert Users
INSERT INTO User (email, password) VALUES ('user1@example.com', 'password123'), ('user2@example.com', 'mypassword456');

-- Insert Reservations
INSERT INTO Reservation (user_id, trip_id) VALUES (1, 1), (2, 2);

-- Insert Travellers
INSERT INTO Traveller (name, EGN, age, phone, reservation_id) VALUES
('John Doe', '1234567890', 30, '555-1234', 1),
('Jane Smith', '0987654321', 25, '555-5678', 2);
