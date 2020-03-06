INSERT INTO CLIENT(id, name, address) VALUES('1', 'Caroline', 'Rua de casa 1');
INSERT INTO CLIENT(id, name, address) VALUES('2', 'Dilza', 'Rua de casa 2');
INSERT INTO CLIENT(id, name, address) VALUES('3', 'Bruna', 'Não sei o endereço');
INSERT INTO CLIENT(id, name, address) VALUES('4', 'Margarida', 'Rua de casa 3');

INSERT INTO REPRESENTATIVE(id, name) VALUES('1', 'Bruno');
INSERT INTO REPRESENTATIVE(id, name) VALUES('2', 'Carol');

INSERT INTO VISIT(id, cost, visit, client_id, representative_id) values('1', '28.30', '2020-04-05 18:00:00', '1', '1');
INSERT INTO VISIT(id, cost, visit, client_id, representative_id) values('2', '50.30', '2020-02-18 11:00:00', '4', '2');