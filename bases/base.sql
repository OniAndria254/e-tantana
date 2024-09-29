CREATE TABLE nature_rubrique (
   id_nature_rubrique SERIAL,
   nom VARCHAR(50) NOT NULL,
   PRIMARY KEY(id_nature_rubrique)
);

CREATE TABLE type_rubrique (
   id_type_rubrique SERIAL,
   nom VARCHAR(30) NOT NULL,
   PRIMARY KEY(id_type_rubrique)
);

CREATE TABLE type_centre (
   id_type_centre SERIAL,
   nom VARCHAR(30) NOT NULL,
   PRIMARY KEY(id_type_centre)
);


CREATE TABLE rubrique (
   id_rubrique SERIAL,
   nom VARCHAR(30) NOT NULL,
   unite_oeuvre VARCHAR(20) NOT NULL,
   prix_unitaire DECIMAL(15,2) NOT NULL,
   id_nature_rubrique INT NOT NULL,
   id_type_rubrique INT NOT NULL,
   quantite DECIMAL(10,0) NOT NULL,
   PRIMARY KEY(id_rubrique),
   FOREIGN KEY(id_nature_rubrique) REFERENCES nature_rubrique(id_nature_rubrique),
   FOREIGN KEY(id_type_rubrique) REFERENCES type_rubrique(id_type_rubrique)
);

CREATE TABLE exercice (
   id_exercice SERIAL,
   date_debut DATE NOT NULL,
   date_fin DATE NOT NULL,
   nb_centres INT NOT NULL,
   PRIMARY KEY(id_exercice)
);

CREATE TABLE centre (
   id_centre SERIAL,
   nom VARCHAR(30) NOT NULL,
   id_type_centre INT NOT NULL,
   id_exercice INT NOT NULL,
   PRIMARY KEY(id_centre),
   FOREIGN KEY(id_type_centre) REFERENCES type_centre(id_type_centre),
   FOREIGN KEY(id_exercice) REFERENCES exercice(id_exercice)
);

CREATE TABLE liaison (
   id_liaison SERIAL,
   taux DECIMAL(15,2),
   id_exercice INT NOT NULL,
   id_centre INT NOT NULL,
   cout_fixe DECIMAL(15,2),
   cout_variable DECIMAL(15,2),
   id_rubrique INT NOT NULL,
   PRIMARY KEY(id_liaison),
   FOREIGN KEY(id_exercice) REFERENCES exercice(id_exercice),
   FOREIGN KEY(id_centre) REFERENCES centre(id_centre),
   FOREIGN KEY(id_rubrique) REFERENCES rubrique(id_rubrique)
);


insert into type_centre(nom) values
('Centre operationnel'),
('Centre de structure');


insert into type_rubrique(nom) values
('Charge incorporable'),
('Charge non incorporable'),
('Charge suppletive');


insert into nature_rubrique(nom) values
('Charge directe'),
('Charge indirecte');