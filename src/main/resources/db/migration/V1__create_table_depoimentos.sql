CREATE TABLE depoimentos(
	id SERIAL PRIMARY KEY,
	comentario TEXT NOT NULL,
	autor VARCHAR(255),
	foto VARCHAR(255)
);