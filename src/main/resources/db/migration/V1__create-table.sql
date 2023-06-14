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

-- mock
INSERT INTO car (plate, model, brand, current_km, vehicle_year) VALUES ( 'MODELO1', 'GOL', 'VOLKSWAGEN', 18900.53, '2012-01-01');
INSERT INTO car ( plate, model, brand, current_km, vehicle_year) VALUES ('MODELO2', 'HB20', 'HYUNDAI', 1239.14, '2015-01-01');
INSERT INTO car (plate, model, brand, current_km, vehicle_year) VALUES ('MODELO3', 'FOX', 'VOLKSWAGEN', 26835.12, '2010-01-01');
INSERT INTO car (plate, model, brand, current_km, vehicle_year) VALUES ('MODELO4', 'RENEGADE', 'JEEP', 17998.12, '2020-01-01');
INSERT INTO car (plate, model, brand, current_km, vehicle_year) VALUES ('MODELO5', 'COMPASS', 'JEEP', 998.2, '2022-01-01');

INSERT INTO client (id, name, email, cpf, phone) VALUES (1, 'Eduardo Valencio', 'eduardo.valencio.santos@gmail.com', '123.123.123-41', '2342342234234');
INSERT INTO client (id, name, email, cpf, phone) VALUES (2, 'Leonardo Valencio', 'leonardo.valencio@gmail.com', '223.123.123-42', '123123123124');
INSERT INTO client (id, name, email, cpf, phone) VALUES (3, 'Fabiano Valencio', 'fabiano.valencio@gmail.com', '223.123.123-43', '78912374612');
INSERT INTO client (id, name, email, cpf, phone) VALUES (4, 'Maria Aparecida', 'maria.aparecida@gmail.com', '223.123.123-44', '12678634162');