CREATE TABLE IF NOT EXISTS persona
(
    personaId varchar(30) NOT NULL ,
    nombre varchar(30) NOT NULL,
    genero varchar(1) NOT NULL,
    edad numeric NOT NULL ,
    identificacion numeric NOT NULL,
    direccion varchar(50) NOT NULL ,
    telefono numeric NOT NULL,
    PRIMARY KEY (personaId)
);
CREATE TABLE IF NOT EXISTS cliente
(
    contrasena varchar(30) NOT NULL,
    estado boolean NOT NULL
)INHERITS (persona);
CREATE TABLE IF NOT EXISTS cuenta
(
    numeroCuenta numeric NOT NULL ,
    tipoCuenta varchar(30) NOT NULL,
    saldoInicial numeric NOT NULL,
    estado varchar(30) NOT NULL,
    PRIMARY KEY (numeroCuenta)
);
CREATE TABLE IF NOT EXISTS movimientos
  (
      movimientoId varchar(30) NOT NULL ,
      fecha date NOT NULL ,
      tipoMovimiento varchar(30) NOT NULL ,
      valor numeric NOT NULL ,
      saldo numeric NOT NULL ,
      PRIMARY KEY (movimientoId)
  );
