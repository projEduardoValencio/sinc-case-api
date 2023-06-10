CREATE TABLE car (
    id SERIAL PRIMARY KEY,
    plate VARCHAR(10) NOT NULL,
    model TEXT NOT NULL,
    brand TEXT NOT NULL,
    current_km NUMERIC NOT NULL,
    vehicle_year DATE NOT NULL
)