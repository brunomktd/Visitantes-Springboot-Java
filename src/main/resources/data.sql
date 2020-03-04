INSERT INTO CLIENT(id, name, address) VALUES('1', 'Caroline', 'Estrada Nações');
INSERT INTO CLIENT(id, name, address) VALUES('2', 'Dilza', 'R. Amadeu amaral');
INSERT INTO CLIENT(id, name, address) VALUES('3', 'Bruna', 'Não sei o endereço');
INSERT INTO CLIENT(id, name, address) VALUES('4', 'Margarida', 'Juscelino K...');

INSERT INTO REPRESENTATIVE(id, name) VALUES('1', 'Bruno');
INSERT INTO REPRESENTATIVE(id, name) VALUES('2', 'Carol');

INSERT INTO VISIT(id, cost, visit, client_id, representative_id) values('1', '28.30', '2020-04-05 18:00:00', '1', '1');
INSERT INTO VISIT(id, cost, visit, client_id, representative_id) values('2', '50.30', '2020-02-18 11:00:00', '4', '2');