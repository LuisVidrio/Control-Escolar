package Modelo_Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;

import BaseDatos.ConexionBD;
import Entidades.*;


public class Modelo 
{

	PreparedStatement Ps;
	ResultSet Rs;
	Statement St;
	
	
	//AÑADIR REGISTRO A LA TABLA ALUMNOS EN LA BASE DE DATOS
	public boolean AddAlumno(Alumno Alumno){		
		//Optimizar mejor esto
		if(Alumno == null)
			return false;
		
		String 	nombre		= Alumno.getNombre();
		String 	paterno 	= Alumno.getPaterno();
		String 	materno		= Alumno.getMaterno();
		String  tel			= Alumno.getTel();
		String  email		= Alumno.getEmail();
		String  grupo		= Alumno.getGrupo();
			
		String sql = "INSERT INTO ALUMNOS(Nombre, Paterno, Materno, Tel, Email, ID_Grupo) "
				   + "values('"+nombre+"','"+paterno+"','"+materno+"','"+tel+"','"+email+"','"+grupo+"')";
		try{
			Ps = ConexionBD.getConnection().prepareStatement(sql);
			Ps.executeUpdate();
			return true;
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return false;
		}
	}
	
	
	//AÑADIR REGISTRO A LA TABLA MAESTROS EN LA BASE DE DATOS
	public boolean AddMaestro(Maestro Maestro){		
		//?????
		if(Maestro == null)
			return false;
		
		String 	nombre		= Maestro.getNombre();
		String 	paterno 	= Maestro.getPaterno();
		String 	materno		= Maestro.getMaterno();
		String  tel			= Maestro.getTel();
		String  email		= Maestro.getEmail();
		
		String sql = "INSERT INTO MAESTROS(Nombre, Paterno, Materno, Tel, Email) "
				   + "values('"+nombre+"','"+paterno+"','"+materno+"','"+tel+"','"+email+"')";	
		try{
			Ps = ConexionBD.getConnection().prepareStatement(sql);
			Ps.executeUpdate();
			return true;
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return false;
		}
	}
	
	
	//AÑADIR REGISTRO A LA TABLA GRUPOS EN LA BASE DE DATOS
	public boolean AddGrupo(Grupo Grupo){	
		//?????
		if(Grupo == null)
			return false;
		
		String 	nombre		= Grupo.getNombre();
		int 	limite   	= Grupo.getLimite();

		String sql = "INSERT INTO GRUPOS(Nombre, Limite) "
				   + "values('"+nombre+"','"+limite+"')";
		try{
			Ps = ConexionBD.getConnection().prepareStatement(sql);
			Ps.executeUpdate();
			return true;
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return false;
		}
	}
	
	
	//AÑADIR REGISTRO A LA TABLA MATERIAS EN LA BASE DE DATOS
	public boolean AddMateria(Materia Materia){		
		//?????
		if(Materia == null)
			return false;

		String 	nombre		= Materia.getNombre();

		String sql = "INSERT INTO MATERIAS(Nombre) "
				   + "values('"+nombre+"')";
		try{
			Ps = ConexionBD.getConnection().prepareStatement(sql);
			Ps.executeUpdate();
			return true;
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return false;
		}
	}
	
	
	//RECUPERAR DATOS DE LA TABLA GRUPOS "ID"
	public ArrayList<String> llenarGrupo(){			
		ArrayList<String> lista = new ArrayList<String>();
				
		String sql = "SELECT * FROM GRUPOS";
		    		    
		try{
			St = ConexionBD.getConnection().createStatement();  
			Rs = St.executeQuery(sql);
					 
			while(Rs.next())
				lista.add(Rs.getString("ID_Grupo"));
			return lista;
		}catch(SQLException ex){
			 System.out.println(ex.toString());
			 return null;
		}	
	}
	
	
	//RECUPERAR DATOS DE LA TABLA ALUMNOS "MATRICULA"
	public ArrayList<String> llenarMatricula(){			
		ArrayList<String> lista = new ArrayList<String>();
			
        String sql = "SELECT * FROM ALUMNOS";
	    		    
		try{
			St = ConexionBD.getConnection().createStatement();  
			Rs = St.executeQuery(sql);
				 
			while(Rs.next()) 
				lista.add(Rs.getString("ID_Matricula"));
			return lista;			 
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}	
			
	}
	
	
	//RECUPERAR DATOS DE LA TABLA MAESTROS "ID"
	public ArrayList<String> llenarMaestro(){			
		ArrayList<String> lista = new ArrayList<String>();
			
		String sql = "SELECT * FROM MAESTROS";
		    		    
	    try{
		   	St = ConexionBD.getConnection().createStatement();  
			Rs = St.executeQuery(sql);
					 
			while(Rs.next()) 
					lista.add(Rs.getString("ID_Maestro"));
			return lista;
	    }catch(SQLException ex){
		    	System.out.println(ex.toString());
		    	return null;
			}		
	}
		
			
	//RECUPERAR DATOS DE LA TABLA MATERIAS "ID"
	public ArrayList<String> llenarMateria(){						
		ArrayList<String> lista = new ArrayList<String>();
				
		String sql = "SELECT * FROM MATERIAS";
		    		    
		try{
			St = ConexionBD.getConnection().createStatement();  
			Rs = St.executeQuery(sql);
					 
			while(Rs.next()) 
				lista.add(Rs.getString("ID_Materia"));
			return lista;
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}	
	}

	
	//RECUPERAR TABLA GRUPOS
	public DefaultTableModel Grupos(){					
		DefaultTableModel modelo = new DefaultTableModel();
				
		String sql = "SELECT * FROM GRUPOS";
		    		    
		try{
			St = ConexionBD.getConnection().createStatement();  
			Rs = St.executeQuery(sql);
					 
			ResultSetMetaData Rsm = Rs.getMetaData();	 
			int Cant_Columnas = Rsm.getColumnCount();

			modelo.addColumn("ID_Grupo");
			modelo.addColumn("Nombre");
			modelo.addColumn("Limite");
						
			while(Rs.next()){	
				Object[] lista = new Object[Cant_Columnas];
						 
				for(int i=0;i<Cant_Columnas;i++) 
					lista[i] = Rs.getObject(i+1);
				
				modelo.addRow(lista);
			}		 		
		 
			return modelo;
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}	
				
	}
		
	//ACCION: TERMINAR EL PROGRAMA "SALIR"
	public void Salir(){
		System.exit(0);
	}
			

}
