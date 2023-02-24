CREATE TABLE IF NOT EXISTS persona
(
    personaId varchar(50) NOT NULL UNIQUE ,
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
    estado boolean NOT NULL,
    PRIMARY KEY (personaId)
)INHERITS (persona);
CREATE TABLE IF NOT EXISTS cuenta
(
    numeroCuenta serial NOT NULL ,
    tipoCuenta varchar(30) NOT NULL,
    saldoInicial numeric NOT NULL,
    estado boolean NOT NULL,
    personaId varchar(50) NOT NULL,
    PRIMARY KEY (numeroCuenta),
    FOREIGN KEY (personaId) REFERENCES cliente(personaId)
);
CREATE TABLE IF NOT EXISTS movimientos
  (
      movimientoId varchar(50) NOT NULL ,
      fecha date NOT NULL ,
      tipoMovimiento varchar(30) NOT NULL ,
      valor numeric NOT NULL ,
      saldo numeric NOT NULL ,
      numeroCuenta serial NOT NULL,
      FOREIGN KEY (numeroCuenta) REFERENCES cuenta(numeroCuenta),
      PRIMARY KEY (movimientoId)
  );
