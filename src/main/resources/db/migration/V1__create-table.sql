CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    plate VARCHAR(10) NOT NULL UNIQUE,
    model TEXT NOT NULL,
    brand TEXT NOT NULL,
    current_km NUMERIC NOT NULL,
    vehicle_year DATE NOT NULL
);

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    cpf TEXT NOT NULL UNIQUE,
    phone TEXT NOT NULL
);

CREATE TABLE car_rental (
    id SERIAL PRIMARY KEY,
    client_id INT,
    car_id INT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    CONSTRAINT fk_client
        FOREIGN KEY(client_id)
            REFERENCES client(id),
    CONSTRAINT fk_car
        FOREIGN KEY(car_id)
            REFERENCES car(id)
);
