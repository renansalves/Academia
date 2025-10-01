CREATE TABLE veiculo (
    id BIGINT Not Null PRIMARY KEY,
    tipo VARCHAR(50),
    marca VARCHAR(100),
    modelo VARCHAR(100),
    ano_fabricacao INT
);
CREATE TABLE moto(
 id BIGINT NOT NULL PRIMARY KEY,
 tem_partida_eletrica BOOLEAN,
 FOREIGN KEY(id) REFERENCES veiculo(id)
);
CREATE TABLE carro(
 id BIGINT NOT NULL PRIMARY KEY,
 numero_portas INT,
 FOREIGN KEY(id) REFERENCES veiculo(id)
);
CREATE TABLE caminhao(
 id BIGINT NOT NULL PRIMARY KEY,
 capacidade_carga INT,
 FOREIGN KEY(id) REFERENCES veiculo(id)
);
