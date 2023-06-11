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

-- mock
INSERT INTO car (plate, model, brand, current_km, vehicle_year) VALUES ( 'MODELO1', 'GOL', 'VOLKSWAGEN', 2000.0, '2012-01-01');
INSERT INTO car ( plate, model, brand, current_km, vehicle_year) VALUES ('MODELO2', 'HB20', 'HYUNDAI', 2000.0, '2015-01-01');
INSERT INTO car (plate, model, brand, current_km, vehicle_year) VALUES ('MODELO3', 'FOX', 'VOLKSWAGEN', 2000.0, '2010-01-01');
INSERT INTO car (plate, model, brand, current_km, vehicle_year) VALUES ('MODELO4', 'RENEGADE', 'JEEP', 2000.0, '2020-01-01');

INSERT INTO client (id, name, email, cpf, phone) VALUES (1, 'Eduardo Valencio', 'eduardo.valencio.santos@gmail.com', '123.123.123-43', '14998989889');
INSERT INTO client (id, name, email, cpf, phone) VALUES (2, 'Leonardo Valencio', 'leonardo.valencio@gmail.com', '223.123.123-43', '149989089889');