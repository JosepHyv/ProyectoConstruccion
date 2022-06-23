create database SistemaDeTutoriasFei;

use SistemaDeTutoriasFei;

create table roles(
    idRol int auto_increment not null comment "llave primaria",
    nombreRol varchar(100) not null,
    primary key(idRol)
);

create table academico(
    idAcademico int not null auto_increment comment "llave primaria",
    nombres varchar(100) not null,
    apellidoPaterno varchar(100) not null, 
    apellidoMaterno varchar(100) not null, 
    correo varchar(100) not null, 
    esActivo tinyint(1) default NULL,
    primary key(idAcademico)
);

create table rolesAcademicoUsuarios(
    idRolUsuario int not null auto_increment comment "llave primaria",
    idRol int not null ,
    idAcademico int not null, 
    primary key(idRolUsuario),
    foreign key(idRol) references roles(idRol),
    foreign key(idAcademico) references academico(idAcademico)
);


create table usuarios(
    idUsuario int not null auto_increment comment "llave primaria", 
    username varchar(100) not null,
    password varchar(32) not null,
    idRolUsuario int not null,
    primary key(idUsuario),
    foreign key(idRolUsuario) references rolesAcademicoUsuarios(idRolUsuario)
);


 /* creando tablas secundarias*/

 create table periodo(
    idPeriodo int not null auto_increment,
    fechaInicio date not null, 
    fechaFin date not null, 
    primary key(idPeriodo)
);

create table experienciaEducativa(
    idExperienciaEducativa int not null auto_increment,
    nrc int(5) not null, 
    programaEducativo varchar(100) not null, 
    esOfertada tinyint(1) default null, 
    semestreRecomendado int default null,
    area varchar(100) not null, 
    idPeriodo int default null,
    primary key(idExperienciaEducativa),
    foreign key(idPeriodo) references periodo(idPeriodo)
);


create table imparte(
    idAcademico int not null, 
    idExperienciaEducativa int(5) not null, 
    foreign key(idAcademico) references academico(idAcademico),
    foreign key(idExperienciaEducativa) references experienciaEducativa(idExperienciaEducativa)
);

create table estudiante(
    idEstudiante int not null auto_increment,
    nombres varchar(100) not null, 
    apellidoPaterno varchar(100) not null, 
    apellidoMaterno varchar(100) not null,
    correo varchar(100) not null, 
    matricula varchar(10) not null, 
    semestre varchar(100) not null,
    idTutorAcademico int not null, 
    idPeriodo int not null,
    primary key(idEstudiante),
    foreign key(idTutorAcademico) references academico(idAcademico),
    foreign key (idPeriodo) references periodo(idPeriodo)
);

/* ultimas tablas */

create table reporteGeneral(
    idReporteGeneral int not null auto_increment,
    fecha date not null, 
    objetivo text not null, 
    totalAlumnosRegistrados int not null, 
    totalAlumnosAsistencia int not null, 
    comentarios text default null,
    primary key(idReporteGeneral)
);

create table sesionTutoria(
    idSesionTutoria int not null auto_increment,
    fechaLimiteEntrega date not null,
    numSesion int not null,
    idTutorAcademico int not null, 
    idPeriodo int not null, 
    primary key(idSesionTutoria),
    foreign key(idTutorAcademico) references academico(idAcademico),
    foreign key(idPeriodo) references periodo(idPeriodo)
);

create table horarioSesion(
    idHorarioSesion int not null auto_increment comment "llave primaria",
    horaInicio time not null,
    horaFin time not null, 
    modalidad varchar(100) not null, 
    locacion varchar(100) not null, 
    idSesionTutoria int not null,
    primary key(idHorarioSesion),
    foreign key(idSesionTutoria) references sesionTutoria(idSesionTutoria)
);

create table reporteTutoria(
    idReporteTutoria int not null auto_increment,
    fecha date not null, 
    programaEducativo varchar(100) not null, 
    numAsistencia int not null, 
    numRiesgo int not null, 
    comentarios text default null, 
    idReporteGeneral int not null, 
    primary key(idReporteTutoria),
    foreign key(idReporteGeneral) references reporteGeneral(idReporteGeneral)
);

create table problematicaAcademica(
    idProblematicaAcademica int not null auto_increment,
    numAlum int default null, 
    descripcion text default null, 
    gravedad varchar(100) not null, 
    categoria varchar(100) not null, 
    solucion text default null, 
    idPeriodo int not null, 
    idReporteTutoria int not null, 
    primary key(idProblematicaAcademica),
    foreign key(idPeriodo) references periodo(idPeriodo),
    foreign key(idReporteTutoria) references reporteTutoria(idReporteTutoria)
);







