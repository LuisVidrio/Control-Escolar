package Modelo_Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;

import BaseDatos.ConexionBD;
import Entidades.*;


public class Modelo 
{
	private ResultSet 			Rs	= null;
	private CallableStatement 	Cst	= null;
	private Connection 			Con = null;
	

	//CONSIDERAR LOS USOS ESPECIFICOS
	
	//AÑADIR REGISTRO A LA TABLA ALUMNOS EN LA BASE DE DATOS
	public boolean AddAlumno(Alumno Alumno){			
		try{
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPInsertar_Alumnos(?,?,?,?,?,?)}");		
			Cst.setString(1,Alumno.getNombre());
			Cst.setString(2,Alumno.getPaterno());
			Cst.setString(3,Alumno.getMaterno());
			Cst.setString(4,Alumno.getTel());
			Cst.setString(5,Alumno.getEmail());
			Cst.setString(6,Alumno.getGrupo());	
			Cst.execute();			
			return true;
		}catch(SQLException e){
			System.out.println(e.toString());
			return false;
		}catch(NullPointerException p){
			System.out.println(p);
			return false;
		}finally{
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
	//AÑADIR REGISTRO A LA TABLA MAESTROS EN LA BASE DE DATOS
	public boolean AddMaestro(Maestro Maestro){		
		try{
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPInsertar_Maestros(?,?,?,?,?)}");		
			Cst.setString(1,Maestro.getNombre());
			Cst.setString(2,Maestro.getPaterno());
			Cst.setString(3,Maestro.getMaterno());
			Cst.setString(4,Maestro.getTel());
			Cst.setString(5,Maestro.getEmail());	
			Cst.execute();	
			return true;
		}catch(SQLException e){
			System.out.println(e.toString());
			return false;
		}catch(NullPointerException p){
			System.out.println(p);
			return false;
		}finally{
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
	//AÑADIR REGISTRO A LA TABLA GRUPOS EN LA BASE DE DATOS
	public boolean AddGrupo(Grupo Grupo){		
		try{
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPInsertar_Grupos(?,?)}");		
			Cst.setString(1,Grupo.getNombre());
			Cst.setInt(2,Grupo.getLimite());
			Cst.execute();	
			return true;
		}catch(SQLException e){
			System.out.println(e.toString());
			return false;
		}catch(NullPointerException p){
			System.out.println(p);
			return false;
		}finally{
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
	//AÑADIR REGISTRO A LA TABLA MATERIAS EN LA BASE DE DATOS
	public boolean AddMateria(Materia Materia){			
		try{
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPInsertar_Materias(?)}");		
			Cst.setString(1,Materia.getNombre());
			Cst.execute();	
			return true;
		}catch(SQLException e){
			System.out.println(e.toString());
			return false;
		}catch(NullPointerException p){
			System.out.println(p);
			return false;
		}finally{
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
	
	
	
	
	
	//RECUPERAR DATOS DE LA TABLA ALUMNOS "MATRICULA"
	public ArrayList<String> llenarMatricula(){			    
		try{
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPConsultar_Alumnos}");
			Rs = Cst.executeQuery();
				
			//USO ESPECIFICO
			ArrayList<String> lista = new ArrayList<String>();
			while(Rs.next()) 
				lista.add(Rs.getString("ID_Matricula"));
			return lista;	
			//USO ESPECIFICO
			
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}finally{
			try {Rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}	
			
	}
	
	
	//RECUPERAR DATOS DE LA TABLA MAESTROS "ID"
	public ArrayList<String> llenarMaestro(){					    
	    try{ 	
	    	Con = ConexionBD.getConnection();
	    	Cst = Con.prepareCall("{CALL SPConsultar_Maestros}");
			Rs = Cst.executeQuery();
			
			//USO ESPECIFICO
			ArrayList<String> lista = new ArrayList<String>();
			while(Rs.next()) 
					lista.add(Rs.getString("ID_Maestro"));
			return lista;
			//USO ESPECIFICO
			
	    }catch(SQLException ex){
		    	System.out.println(ex.toString());
		    	return null;
		}finally{
			try {Rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}			
	}
		
			
	//RECUPERAR DATOS DE LA TABLA MATERIAS "ID"
	public ArrayList<String> llenarMateria(){						    
		try{
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPConsultar_Materias}");
			Rs = Cst.executeQuery();
			
			//USO ESPCIFICO
			ArrayList<String> lista = new ArrayList<String>(); 		
			while(Rs.next()) 
				lista.add(Rs.getString("ID_Materia"));
			return lista;
			//USO ESPECIFICO
			
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}finally{
			try {Rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}		
	}

	
	//RECUPERAR DATOS DE LA TABLA GRUPOS   "ID"
	public ArrayList<String> llenarGrupo(){					    		    
		try{
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPConsultar_Grupos}");
			Rs = Cst.executeQuery();
			
			//USO ESPECIFICO
			ArrayList<String> lista = new ArrayList<String>();
			while(Rs.next())
				lista.add(Rs.getString("ID_Grupo"));
			return lista;
			//USO ESPECIFICO
			
		}catch(SQLException ex){
			 System.out.println(ex.toString());
			 return null;
		}finally{
			try {Rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}		
	}

	
	
	

	//RECUPERAR TABLA GRUPOS
	public DefaultTableModel Grupos(){										    		    
		try{	
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPConsultar_Grupos}");
			Rs = Cst.executeQuery();
			
			//USO ESPECIFICO
			DefaultTableModel modelo = new DefaultTableModel();
			ResultSetMetaData Rsm = Rs.getMetaData();	 

			modelo.addColumn("ID_Grupo");
			modelo.addColumn("Nombre");
			modelo.addColumn("Limite");
						
			while(Rs.next()){	
				Object[] lista = new Object[Rsm.getColumnCount()];
						 
				for(int i=0;i<Rsm.getColumnCount();i++) 
					lista[i] = Rs.getObject(i+1);
				
				modelo.addRow(lista);
			}		 		
			return modelo;
			//USO ESPECIFICO
			
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}finally{
			try {Rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}		
				
	}
		
	
	public DefaultTableModel Buscar_Grupo(Grupo Grupo) {
		try{	
			
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPConsultar_Grupo(?)}");
			Cst.setInt(1,Grupo.getID_Grupo());
			Rs = Cst.executeQuery();	
			
			//USO ESPECIFICO
			DefaultTableModel modelo = new DefaultTableModel();
			ResultSetMetaData Rsm = Rs.getMetaData();	 

			modelo.addColumn("ID_Grupo");
			modelo.addColumn("Nombre");
			modelo.addColumn("Limite");
						
			while(Rs.next()){	
				Object[] lista = new Object[Rsm.getColumnCount()];
						 
				for(int i=0;i<Rsm.getColumnCount();i++) 
					lista[i] = Rs.getObject(i+1);
				
				modelo.addRow(lista);
			}		 		
			return modelo;
			//USO ESPECIFICO
			
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}finally{
			try {Rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
		
	

	public DefaultTableModel Buscar_Materia(Materia Materia) {
		try{	
			
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPConsultar_Materia(?)}");
			Cst.setInt(1,Materia.getID());
			Rs = Cst.executeQuery();	
			
			//USO ESPECIFICO
			DefaultTableModel modelo = new DefaultTableModel();
			ResultSetMetaData Rsm = Rs.getMetaData();	 

			modelo.addColumn("ID_Materia");
			modelo.addColumn("Nombre");
						
			while(Rs.next()){	
				Object[] lista = new Object[Rsm.getColumnCount()];
						 
				for(int i=0;i<Rsm.getColumnCount();i++) 
					lista[i] = Rs.getObject(i+1);
				
				modelo.addRow(lista);
			}		 		
			return modelo;
			//USO ESPECIFICO
			
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}finally{
			try {Rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	

	public DefaultTableModel Materias(){										    		    
		try{	
			Con = ConexionBD.getConnection();
			Cst = Con.prepareCall("{CALL SPConsultar_Materias}");
			Rs = Cst.executeQuery();
			
			//USO ESPECIFICO
			DefaultTableModel modelo = new DefaultTableModel();
			ResultSetMetaData Rsm = Rs.getMetaData();	 

			modelo.addColumn("ID_Materia");
			modelo.addColumn("Nombre");
						
			while(Rs.next()){	
				Object[] lista = new Object[Rsm.getColumnCount()];
						 
				for(int i=0;i<Rsm.getColumnCount();i++) 
					lista[i] = Rs.getObject(i+1);
				
				modelo.addRow(lista);
			}		 		
			return modelo;
			//USO ESPECIFICO
			
		}catch(SQLException ex){
			System.out.println(ex.toString());
			return null;
		}finally{
			try {Rs.close();} catch (SQLException e) {e.printStackTrace();}
			try {Cst.close();} catch (SQLException e) {e.printStackTrace();}
			try {Con.close();} catch (SQLException e) {e.printStackTrace();}
		}		
				
	}


	
	//ACCION: TERMINAR EL PROGRAMA "SALIR"
	public void Salir(){
		System.exit(0);
	}
	

}
