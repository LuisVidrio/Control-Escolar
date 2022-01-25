
GO
CREATE DATABASE Ctrl_Escolar
GO
USE [Ctrl_Escolar]
GO
/****** Object:  Table [dbo].[ALUMNOS]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ALUMNOS](
	[ID_Matricula] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Paterno] [varchar](50) NULL,
	[Materno] [varchar](50) NULL,
	[Tel] [nchar](10) NULL,
	[Email] [varchar](50) NULL,
	[ID_Grupo] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Matricula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CALIFICACIONES]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CALIFICACIONES](
	[ID_Materia] [int] NOT NULL,
	[ID_Matricula] [int] NOT NULL,
	[Calificacion] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Materia] ASC,
	[ID_Matricula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DIRECTORIO]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DIRECTORIO](
	[ID_Materia] [int] NOT NULL,
	[ID_Maestro] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Maestro] ASC,
	[ID_Materia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GRUPOS]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GRUPOS](
	[ID_Grupo] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Limite] [nchar](2) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Grupo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HORARIOS]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HORARIOS](
	[ID_Horario] [int] IDENTITY(1,1) NOT NULL,
	[ID_Materia] [int] NOT NULL,
	[ID_Maestro] [int] NOT NULL,
	[Hora_Ini] [time](7) NULL,
	[Hora_Fin] [time](7) NULL,
	[ID_Grupo] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Horario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MAESTROS]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAESTROS](
	[ID_Maestro] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Paterno] [varchar](50) NULL,
	[Materno] [varchar](50) NULL,
	[Tel] [nchar](10) NULL,
	[Email] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Maestro] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MATERIAS]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MATERIAS](
	[ID_Materia] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Materia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ALUMNOS]  WITH CHECK ADD FOREIGN KEY([ID_Grupo])
REFERENCES [dbo].[GRUPOS] ([ID_Grupo])
GO
ALTER TABLE [dbo].[CALIFICACIONES]  WITH CHECK ADD FOREIGN KEY([ID_Materia])
REFERENCES [dbo].[MATERIAS] ([ID_Materia])
GO
ALTER TABLE [dbo].[CALIFICACIONES]  WITH CHECK ADD FOREIGN KEY([ID_Matricula])
REFERENCES [dbo].[ALUMNOS] ([ID_Matricula])
GO
ALTER TABLE [dbo].[DIRECTORIO]  WITH CHECK ADD  CONSTRAINT [IDir_Maestro] FOREIGN KEY([ID_Maestro])
REFERENCES [dbo].[MAESTROS] ([ID_Maestro])
GO
ALTER TABLE [dbo].[DIRECTORIO] CHECK CONSTRAINT [IDir_Maestro]
GO
ALTER TABLE [dbo].[DIRECTORIO]  WITH CHECK ADD  CONSTRAINT [IDir_Materia] FOREIGN KEY([ID_Materia])
REFERENCES [dbo].[MATERIAS] ([ID_Materia])
GO
ALTER TABLE [dbo].[DIRECTORIO] CHECK CONSTRAINT [IDir_Materia]
GO
ALTER TABLE [dbo].[HORARIOS]  WITH CHECK ADD FOREIGN KEY([ID_Maestro], [ID_Materia])
REFERENCES [dbo].[DIRECTORIO] ([ID_Maestro], [ID_Materia])
GO
ALTER TABLE [dbo].[HORARIOS]  WITH CHECK ADD FOREIGN KEY([ID_Grupo])
REFERENCES [dbo].[GRUPOS] ([ID_Grupo])
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Alumnos]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



--CONSULTAR



-- PA: MOSTRAR: CONSULTAR REGISTROS => ALUMNOS
CREATE PROCEDURE [dbo].[SPConsultar_Alumnos]
AS
SELECT * FROM ALUMNOS
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Calificaciones]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: MOSTRAR: CONSULTAR REGISTROS => CALIFICACIONES
CREATE PROCEDURE [dbo].[SPConsultar_Calificaciones]
AS
SELECT * FROM CALIFICACIONES
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Directorio]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: MOSTRAR: CONSULTAR REGISTROS => DIRECTORIO
CREATE PROCEDURE [dbo].[SPConsultar_Directorio]
AS
SELECT * FROM DIRECTORIO
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Grupo]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SPConsultar_Grupo]
@ID_Grupo int
AS
SELECT * FROM GRUPOS WHERE  ID_Grupo = @ID_Grupo
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Grupos]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: MOSTRAR: CONSULTAR REGISTROS => GRUPOS
CREATE PROCEDURE [dbo].[SPConsultar_Grupos]
AS
SELECT * FROM GRUPOS
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Horarios]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: MOSTRAR: CONSULTAR REGISTROS => HORARIOS
CREATE PROCEDURE [dbo].[SPConsultar_Horarios]
AS
SELECT * FROM HORARIOS
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Maestros]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: MOSTRAR: CONSULTAR REGISTROS => MAESTROS
CREATE PROCEDURE [dbo].[SPConsultar_Maestros]
AS
SELECT * FROM MAESTROS
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Materia]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[SPConsultar_Materia]
@ID_Materia int
AS
SELECT * FROM MATERIAS WHERE  ID_Materia = @ID_Materia
GO
/****** Object:  StoredProcedure [dbo].[SPConsultar_Materias]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: MOSTRAR: CONSULTAR REGISTROS => MATERIAS
CREATE PROCEDURE [dbo].[SPConsultar_Materias]
AS
SELECT * FROM MATERIAS
GO
/****** Object:  StoredProcedure [dbo].[SPEditar_Alumnos]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO




--ACTUALIZAR




-- PA: EDITAR: ACTUALIZAR REGISTROS => ALUMNOS
CREATE PROCEDURE [dbo].[SPEditar_Alumnos]
@ID_Matricula int,
@Nombre varchar(50),
@Paterno varchar(50),
@Materno varchar(50),
@Telefono nchar(10),
@Email	varchar(10),
@ID_Grupo int
AS
UPDATE ALUMNOS SET	Nombre	 = @Nombre,
					Paterno  = @Paterno,
					Materno  = @Materno,
					Tel		 = @Telefono,
					Email	 = @Email,
					ID_Grupo = @ID_Grupo
WHERE ID_Matricula = @ID_Matricula
GO
/****** Object:  StoredProcedure [dbo].[SPEditar_Calificaciones]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: EDITAR: ACTUALIZAR REGISTROS => CALIFICACIONES
CREATE PROCEDURE [dbo].[SPEditar_Calificaciones]
@ID_Materia int,
@ID_Matricula int,
@Calificacion float
AS
UPDATE CALIFICACIONES SET Calificacion  = @Calificacion
WHERE ID_Materia = @ID_Materia AND ID_Matricula = @ID_Matricula
GO
/****** Object:  StoredProcedure [dbo].[SPEditar_Directorio]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: EDITAR: ACTUALIZAR REGISTROS => DIRECTORIO
CREATE PROCEDURE [dbo].[SPEditar_Directorio]
@ID_Materia int,
@ID_Maestro int
AS
UPDATE DIRECTORIO SET	ID_Materia  = @ID_Materia,
						ID_Maestro = @ID_Maestro
WHERE ID_Materia = @ID_Materia AND ID_Maestro = @ID_Maestro
GO
/****** Object:  StoredProcedure [dbo].[SPEditar_Grupos]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: EDITAR: ACTUALIZAR REGISTROS => GRUPOS
CREATE PROCEDURE [dbo].[SPEditar_Grupos]
@ID_Grupo int,
@Nombre varchar(50),
@Limite nchar(2)
AS
UPDATE GRUPOS SET	Nombre = @Nombre,
					Limite = @Limite
WHERE ID_Grupo = @ID_Grupo 
GO
/****** Object:  StoredProcedure [dbo].[SPEditar_Horarios]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: EDITAR: ACTUALIZAR REGISTROS => HORARIOS
CREATE PROCEDURE [dbo].[SPEditar_Horarios]
@ID_Horario int,
@ID_Materia int,
@ID_Maestro int,
@Hora_Ini time,
@Hora_Fin time,
@ID_Grupo int
AS
UPDATE HORARIOS SET	ID_Materia	= @ID_Materia,
					ID_Maestro	= @ID_Maestro,
					Hora_Ini	= @Hora_Ini,
					Hora_Fin	= @Hora_Fin,
					ID_Grupo	= @ID_Grupo
WHERE ID_Horario = @ID_Horario 
GO
/****** Object:  StoredProcedure [dbo].[SPEditar_Maestros]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: EDITAR: ACTUALIZAR REGISTROS => MAESTROS
CREATE PROCEDURE [dbo].[SPEditar_Maestros]
@ID_Maestro int,
@Nombre varchar(50),
@Paterno varchar(50),
@Materno varchar(50),
@Telefono nchar(10),
@Email	varchar(10)
AS
UPDATE MAESTROS SET	Nombre	 = @Nombre,
					Paterno  = @Paterno,
					Materno  = @Materno,
					Tel		 = @Telefono,
					Email	 = @Email
WHERE ID_Maestro = @ID_Maestro
GO
/****** Object:  StoredProcedure [dbo].[SPEditar_Materias]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: EDITAR: ACTUALIZAR REGISTROS => MATERIAS
CREATE PROCEDURE [dbo].[SPEditar_Materias]
@ID_Materia int,
@Nombre varchar(50)
AS
UPDATE MATERIAS SET	Nombre = @Nombre
WHERE ID_Materia = @ID_Materia
GO
/****** Object:  StoredProcedure [dbo].[SPEliminar_Alumnos]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO




-- ELIMINAR




-- PA: ELIMINAR: BORRAR REGISTROS => ALUMNOS
CREATE PROCEDURE [dbo].[SPEliminar_Alumnos]
@ID_Matricula int
AS
DELETE ALUMNOS WHERE ID_Matricula = @ID_Matricula
GO
/****** Object:  StoredProcedure [dbo].[SPEliminar_Calificaciones]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: ELIMINAR: BORRAR REGISTROS => CALIFICACIONES
CREATE PROCEDURE [dbo].[SPEliminar_Calificaciones]
@ID_Materia int,
@ID_Matricula int
AS
DELETE CALIFICACIONES WHERE ID_Materia = @ID_Materia AND @ID_Matricula =  @ID_Matricula
GO
/****** Object:  StoredProcedure [dbo].[SPEliminar_Directorio]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: ELIMINAR: BORRAR REGISTROS => DIRECTORIO
CREATE PROCEDURE [dbo].[SPEliminar_Directorio]
@ID_Materia int,
@ID_Maestro int
AS
DELETE DIRECTORIO WHERE ID_Materia = @ID_Materia AND ID_Maestro = @ID_Maestro
GO
/****** Object:  StoredProcedure [dbo].[SPEliminar_Grupos]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: ELIMINAR: BORRAR REGISTROS => GRUPOS
CREATE PROCEDURE [dbo].[SPEliminar_Grupos]
@ID_Grupo int
AS
DELETE GRUPOS WHERE ID_Grupo = @ID_Grupo
GO
/****** Object:  StoredProcedure [dbo].[SPEliminar_Horarios]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: ELIMINAR: BORRAR REGISTROS => HORARIOS
CREATE PROCEDURE [dbo].[SPEliminar_Horarios]
@ID_Horario int
AS
DELETE HORARIOS WHERE ID_Horario = @ID_Horario
GO
/****** Object:  StoredProcedure [dbo].[SPEliminar_Maestros]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: ELIMINAR: BORRAR REGISTROS => MAESTROS
CREATE PROCEDURE [dbo].[SPEliminar_Maestros]
@ID_Maestro int
AS
DELETE MAESTROS WHERE ID_Maestro = @ID_Maestro
GO
/****** Object:  StoredProcedure [dbo].[SPEliminar_Materias]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: ELIMINAR: BORRAR REGISTROS => MATERIAS
CREATE PROCEDURE [dbo].[SPEliminar_Materias]
@ID_Materia int
AS
DELETE MATERIAS WHERE ID_Materia = @ID_Materia
GO
/****** Object:  StoredProcedure [dbo].[SPInsertar_Alumnos]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


--INSERTAR



-- PA: INSERTAR: AGREGAR REGISTROS => ALUMNOS
CREATE PROCEDURE [dbo].[SPInsertar_Alumnos](
@Nombre varchar(50),
@Paterno varchar(50),
@Materno varchar(50),
@Telefono nchar(10),
@Email	varchar(10),
@ID_Grupo int
)
AS
INSERT INTO ALUMNOS VALUES (@Nombre,@Paterno,@Materno,@Telefono,@Email,@ID_Grupo)
GO
/****** Object:  StoredProcedure [dbo].[SPInsertar_Calificaciones]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: INSERTAR: AGREGAR REGISTROS => CALIFICACIONES
CREATE PROCEDURE [dbo].[SPInsertar_Calificaciones](
@ID_Materia int,
@ID_Matricula int,
@Calificacion float
)
AS
INSERT INTO CALIFICACIONES VALUES (@ID_Materia,@ID_Matricula,@Calificacion)
GO
/****** Object:  StoredProcedure [dbo].[SPInsertar_Directorio]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
	

-- PA: INSERTAR: AGREGAR REGISTROS => DIRECTORIO
CREATE PROCEDURE [dbo].[SPInsertar_Directorio](
@ID_Materia int,
@ID_Maestro int
)
AS
INSERT INTO DIRECTORIO VALUES (@ID_Materia,@ID_Maestro)
GO
/****** Object:  StoredProcedure [dbo].[SPInsertar_Grupos]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
	

-- PA: INSERTAR: AGREGAR REGISTROS => GRUPOS
CREATE PROCEDURE [dbo].[SPInsertar_Grupos](
@Nombre varchar(50),
@Limite int
)
AS
INSERT INTO GRUPOS VALUES (@Nombre,@Limite)
GO
/****** Object:  StoredProcedure [dbo].[SPInsertar_Horarios]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- PA: INSERTAR: AGREGAR REGISTROS => HORARIOS
CREATE PROCEDURE [dbo].[SPInsertar_Horarios](
@ID_Horario int,
@ID_Materia int,
@ID_Maestro int,
@Hora_Ini time,
@Hora_Fin time,
@ID_Grupo int
)
AS
INSERT INTO HORARIOS VALUES (@ID_Materia,@ID_Maestro,@Hora_Ini,@Hora_Fin,@ID_Grupo)
GO
/****** Object:  StoredProcedure [dbo].[SPInsertar_Maestros]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

	
-- PA: INSERTAR: AGREGAR REGISTROS => MAESTROS
CREATE PROCEDURE [dbo].[SPInsertar_Maestros](
@Nombre varchar(50),
@Paterno varchar(50),
@Materno varchar(50),
@Telefono nchar(10),
@Email	varchar(10)
)
AS
INSERT INTO MAESTROS VALUES (@Nombre,@Paterno,@Materno,@Telefono,@Email)
GO
/****** Object:  StoredProcedure [dbo].[SPInsertar_Materias]    Script Date: 25/01/2022 03:01:07 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

	
-- PA: INSERTAR: AGREGAR REGISTROS => MATERIAS
CREATE PROCEDURE [dbo].[SPInsertar_Materias](
@Nombre varchar(50)
)
AS
INSERT INTO MATERIAS VALUES (@Nombre)
GO
