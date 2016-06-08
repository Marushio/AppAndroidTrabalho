--Apaga as tabelas
DROP TABLE IF EXISTS emp CASCADE;
DROP TABLE IF EXISTS dep CASCADE;
DROP TABLE IF EXISTS faixa_sal CASCADE;

--Tabela dep
CREATE TABLE dep (
    n_dep serial,
    nome_dep varchar(20),
    local_dep varchar(30),
    PRIMARY KEY (n_dep)
);

INSERT INTO dep VALUES (DEFAULT, 'Administracao', 'Campinas');
INSERT INTO dep VALUES (DEFAULT, 'Pesquisa', 'Campinas');
INSERT INTO dep VALUES (DEFAULT, 'Vendas', 'Sao Paulo');
INSERT INTO dep VALUES (DEFAULT, 'Producao', 'Sao Paulo');

--Tabela emp
CREATE TABLE emp (
    n_emp serial,
    nome_emp varchar(30) NOT NULL,
    cargo varchar(10) NOT NULL,
    chefe integer,
    data_adm date,
    sal numeric(10,2) NOT NULL,
    com numeric(10,2),
    n_dep integer,
    PRIMARY KEY (n_emp),
    FOREIGN KEY(n_dep) REFERENCES dep(n_dep),    
    CHECK (sal > 0)
);

INSERT INTO emp VALUES (DEFAULT, 'Pedro', 'Presidente', NULL, '2004-02-23', 15000.00, NULL, 1);
INSERT INTO emp VALUES (DEFAULT, 'Ubaldo', 'Diretor', 1, '2003-03-27', 8000.00, NULL, 2);
INSERT INTO emp VALUES (DEFAULT, 'Rosa', 'Diretor', 1, '2004-12-21', 3300.00, 5000.00, 3);
INSERT INTO emp VALUES (DEFAULT, 'Eduardo', 'Vendedor', 3, '2003-04-11', 2000.00, 3000.00, 3);
INSERT INTO emp VALUES (DEFAULT, 'Sérgio', 'Vendedor', 3, '2003-10-30', 1500.00, 9000.00, 3);
INSERT INTO emp VALUES (DEFAULT, 'Augusta', 'Secretária', 1, '2005-06-10', 1200.00, NULL, 1);
INSERT INTO emp VALUES (DEFAULT, 'Ronaldo', 'Analista', 2, '2004-04-17', 5000.00, NULL, 2);
INSERT INTO emp VALUES (DEFAULT, 'Sílvia', 'Analista', 2, '2003-03-17', 1500.00, NULL, 2);

--Chave estrangeira chefe para n_emp
ALTER TABLE emp ADD FOREIGN KEY (chefe) REFERENCES emp(n_emp);

--Tabela faixa_sal
CREATE TABLE faixa_sal (
		n_faixa serial, 
    faixa character(1) NOT NULL,
    salmin numeric(10,2) NOT NULL,
    salmax numeric(10,2) NOT NULL,
    PRIMARY KEY(n_faixa)
);

INSERT INTO faixa_sal VALUES (DEFAULT, 'A', 0.00, 999.99);
INSERT INTO faixa_sal VALUES (DEFAULT, 'B', 1000, 1999.99);
INSERT INTO faixa_sal VALUES (DEFAULT, 'C', 2000, 2999.99);
INSERT INTO faixa_sal VALUES (DEFAULT, 'D', 3000, 3999.99);
INSERT INTO faixa_sal VALUES (DEFAULT, 'E', 4000, 1000000);

--View para os dados do funcionário
CREATE VIEW v_emp AS
SELECT e.n_emp AS f_n_emp,
       e.nome_emp AS f_nome_emp,
       e.cargo AS f_cargo,
       e.chefe AS f_chefe,
       e.data_adm AS f_data_adm,
       e.sal AS f_sal,
       e.com AS f_com,
       e.n_dep AS f_n_dep,
       c.n_emp AS c_n_emp,
       c.nome_emp AS c_nome_emp,
       c.cargo AS c_cargo,
       c.chefe AS c_chefe,
       c.data_adm AS c_data_adm,
       c.sal AS c_sal,
       c.com AS c_com,
       c.n_dep AS c_n_dep,
       d.n_dep AS d_n_dep,
       d.nome_dep AS d_nome_dep,
       d.local_dep AS d_local_dep      
FROM       emp e
INNER JOIN dep d
        ON (e.n_dep = d.n_dep)
LEFT JOIN emp c
       ON (e.chefe = c.n_emp);
