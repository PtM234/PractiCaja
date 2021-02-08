# PractiCaja

Guía para el correcto funcionamiento del programa Practicaja
Ver: 1.0.1 08/02/2021
1-	Descargue e instale XAMPP desde aquí: https://www.apachefriends.org/es/download.html.

2-	Una vez instalado iniciamos los servicios Apache y MySQL vea imagen 1.

3-	En el Localhost desde el navegador importe la base de datos cliente.sql desde apartado importar.

4-	Una vez exportado la base de datos, lo siguiente es abrir el NetBeans y 
luego abrir el proyecto PractiCaja-PantallasFuncionales cuando se abra marcara un error que le falta un jar, 
seleccione resolver problemas y seleccione .jar en la carpeta mysql-connector-java-8.0.23.
descargue aqui el mysql-connector https://dev.mysql.com/downloads/connector/j/ y selecione Platform Independent

5-	Una resuelto eso, solo queda ejecutar el programa ejecutamos en este orden la clase Servidor y luego la interfaz Login.

Nota: En caso que el archivo SQL, este dañado se procede a 
crear una nueve base en phpMyAdmin con la siguiente información: Crear una base de datos que se llame 
"clientes" Dentro de esta creas una tabla que se llame "cuentas" y que tenga por columnas: 
idCuenta (esta debe de tener autoincremento) int, nombreCliente varchar, password varchar y saldo int, La otra tabla es la de "movimientos", en esta debes de incluir: fecha DATE, idMovimiento (Esta debe de llevar autoincremento) int, nombreCliente varchar, tipoMovimiento varchar. vea imagen 3.
 

