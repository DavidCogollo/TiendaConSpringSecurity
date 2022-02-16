-- articulos
INSERT INTO articulos(nombre,descripcion,precio_unidad,unidades_stock,stock_seguriad) VALUES ("Movil","best movil del mundo",200,10000,2000);
INSERT INTO articulos(nombre,descripcion,precio_unidad,unidades_stock,stock_seguriad) VALUES ("Ordenador","best ordenador del mundo",3000,10000,2000);
INSERT INTO articulos(nombre,descripcion,precio_unidad,unidades_stock,stock_seguriad) VALUES ("Monitor","best monitor del mundo",900,10000,2000);
INSERT INTO articulos(nombre,descripcion,precio_unidad,unidades_stock,stock_seguriad) VALUES ("Mesa","best mesa del mundo",500,10000,2000);


-- clientes
INSERT INTO clientes(nombre,apellidos,empresa,puesto,cp,provincia,telefono,fecha_nacimiento) VALUES ("Jose","Perez","Indra","Manager","28024","Madrid", "642775959",'1940-10-22');
INSERT INTO clientes(nombre,apellidos,empresa,puesto,cp,provincia,telefono,fecha_nacimiento) VALUES ("Maria","Lopez","Indra","Recursos Humanos","28024","Madrid", "642776060",'1960-10-22');


-- compras
INSERT INTO compras(fecha,unidades,cod_cliente,cod_articulo) VALUES ('2020-10-22',4,1,1);
INSERT INTO compras(fecha,unidades,cod_cliente,cod_articulo) VALUES ('2020-10-22',2,2,2);
INSERT INTO compras(fecha,unidades,cod_cliente,cod_articulo) VALUES ('2020-10-22',3,2,1);
INSERT INTO compras(fecha,unidades,cod_cliente,cod_articulo) VALUES ('2020-10-22',3,2,3);
INSERT INTO compras(fecha,unidades,cod_cliente,cod_articulo) VALUES ('2020-10-22',6,2,3);