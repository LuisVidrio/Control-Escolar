package Modelo_Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Interfaz.Vista;

public class Controlador implements ActionListener{

	private Modelo modelo;
	private Vista vista;
	
	public Controlador(){};
	public Controlador(Modelo modelo, Vista vista) 
	{
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		//ACCION: 'GUARDAR' ALUMNO
		if(e.getSource() == vista.getR_Alumno().getBtn_Guardar()) { 		
			vista.getR_Alumno().ShowMensaje(modelo.AddAlumno(vista.getR_Alumno().Recupera_Datos()));
			vista.getR_Alumno().llenarMatricula(modelo.llenarMatricula());
		}
			
		
		//ACCION: 'GUARDAR' MAESTRO
		if(e.getSource() == vista.getR_Maestro().getBtn_Guardar()) 	{	
			vista.getR_Maestro().ShowMensaje(modelo.AddMaestro(vista.getR_Maestro().Recupera_Datos()));
			vista.getR_Maestro().llenarID(modelo.llenarMaestro());
		}
		
		
		//ACCION: 'GUARDAR' MATERIA
		if(e.getSource() == vista.getR_Materia().getBtn_Guardar()) 	{
			vista.getR_Materia().ShowMensaje(modelo.AddMateria(vista.getR_Materia().Recupera_Datos()));
			vista.getR_Materia().llenarID(modelo.llenarMateria());
		}
			
			
		//ACCION: 'GUARDAR' GRUPO
		if(e.getSource() == vista.getR_Grupo().getBtn_Guardar()) 	{
			vista.getR_Grupo().ShowMensaje(modelo.AddGrupo(vista.getR_Grupo().Recupera_Datos()));
			vista.getR_Grupo().llenarID(modelo.llenarGrupo());
		}
	
		
		//CARGA LA TABLA DE GRUPOS
		if(e.getSource() == vista.getR_Grupo().getBtn_Cargar())
			vista.getR_Grupo().llenarTabla(modelo.Grupos());
		
		
		//CARGA LA TABLA DE GRUPO
		if(e.getSource() == vista.getR_Grupo().getBtn_Buscar())
			vista.getR_Grupo().llenarTabla(modelo.Buscar_Grupo(vista.getR_Grupo().Buscar_Grupo()));
		
		
		//CARGA LA TABLA DE MATERIA
		if(e.getSource() == vista.getR_Materia().getBtn_Buscar())
			vista.getR_Materia().llenarTabla(modelo.Buscar_Materia(vista.getR_Materia().Buscar_Materia()));
				
		//CARGA LA TABLA DE MATERIAS
		if(e.getSource() == vista.getR_Materia().getBtn_Cargar())
			vista.getR_Materia().llenarTabla(modelo.Materias());

		
		//ACCION: CAMBIAR DE PANEL: REGISTRAR ALUMNO
		if(e.getSource() == vista.getItem_Al_Registrar()) 
		{
			vista.nuevoPanel(vista.getR_Alumno());			
			vista.getR_Alumno().Blancos();
			vista.getR_Alumno().llenarGrupos(modelo.llenarGrupo());
			vista.getR_Alumno().llenarMatricula(modelo.llenarMatricula());
		}
		
		
		//CAMBIA AL PANEL REGISTRAR MAESTRO
		if(e.getSource() == vista.getItem_Ma_Registrar()) 
		{
			vista.nuevoPanel(vista.getR_Maestro());	
			vista.getR_Maestro().Blancos();
			vista.getR_Maestro().llenarID(modelo.llenarMaestro());
		}

		
		//CAMBIA AL PANEL REGISTRAR GRUPO
		if(e.getSource() == vista.getItem_G_Registrar()) 
		{
			vista.nuevoPanel(vista.getR_Grupo());
			vista.getR_Grupo().Blancos();
			vista.getR_Grupo().llenarID(modelo.llenarGrupo());
			vista.getR_Grupo().llenarTabla(modelo.Grupos());
		}

		
		//CAMBIA AL PANEL REGISTRAR MATERIA
		if(e.getSource() == vista.getItem_Mt_Registrar()) 
		{
			vista.nuevoPanel(vista.getR_Materia());		
			vista.getR_Materia().Blancos();
			vista.getR_Materia().llenarID(modelo.llenarMateria());
			vista.getR_Materia().llenarTabla(modelo.Materias());
		}

		if(e.getSource() == vista.getM_INICIO()){
			vista.nuevoPanel(vista.getPnl_Inicio());
		}
		
		//ACCION: TERMINA EL PROGRAMA "SALIR"  
		if(e.getSource() == vista.getBtnSalir()) 
			modelo.Salir();

	}
	
}
