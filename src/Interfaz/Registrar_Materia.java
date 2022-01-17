package Interfaz;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import Entidades.Materia;

public class Registrar_Materia extends javax.swing.JPanel 
{
	private static final long serialVersionUID = 1L;
	
	private  Materia Materia = new Materia();
	
	private JTextField 	txt_IDMateria;
	private JTextField 	txt_Nombre;
	private JButton	   	btn_Guardar;
	private JPanel 		Pnl_01;
	
	public Registrar_Materia() 
	{		
		setLayout(new BorderLayout(0, 0));
		
		//Panel
		Pnl_01 = new JPanel();
		Pnl_01.setBorder(null);
		Pnl_01.setBackground(Color.WHITE);
		add(Pnl_01, BorderLayout.CENTER);
		Pnl_01.setLayout(null);
		
		//TITULO
		JLabel R_Grupo = new JLabel("REGISTRAR MATERIA");
		R_Grupo.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		R_Grupo.setBounds(21, 34, 309, 20);
		Pnl_01.add(R_Grupo);		
		
		//FORMULARIO:COMPONENTES CON DATOS DE MATERIA
		JLabel lbl_IDMateria = new JLabel("ID:");
		lbl_IDMateria.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_IDMateria.setBounds(21, 85, 29, 16);
		Pnl_01.add(lbl_IDMateria);
		txt_IDMateria = new JTextField();
		txt_IDMateria.setEditable(false);
		txt_IDMateria.setForeground(Color.GRAY);
		txt_IDMateria.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_IDMateria.setBounds(47, 83, 110, 22);
		Pnl_01.add(txt_IDMateria);
		txt_IDMateria.setColumns(10);
		txt_IDMateria.setBorder(null);
				
		//NOMBRE
		JLabel lbl_Nombre = new JLabel("NOMBRE:");
		lbl_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_Nombre.setBounds(21, 140, 68, 16);
		Pnl_01.add(lbl_Nombre);
		txt_Nombre = new JTextField();
		txt_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Nombre.setForeground(Color.LIGHT_GRAY);
		txt_Nombre.setBackground(Color.WHITE);
		txt_Nombre.setBounds(88, 137, 176, 22);
		Pnl_01.add(txt_Nombre);
		txt_Nombre.setColumns(10);
		txt_Nombre.setBorder(null);
				
		//GUARDAR
		btn_Guardar = new JButton("Guardar");
		btn_Guardar.setBounds(411, 441, 155, 47);
		Pnl_01.add(btn_Guardar);
		
		//SEPARADORES
		JSeparator SP_01 = new JSeparator();
		SP_01.setForeground(Color.BLACK);
		SP_01.setBackground(Color.BLACK);
		SP_01.setBounds(88, 159, 176, 2);
		Pnl_01.add(SP_01);
		JSeparator SP_07 = new JSeparator();
		SP_07.setForeground(Color.BLACK);
		SP_07.setBackground(Color.BLACK);
		SP_07.setBounds(47, 105, 110, 2);
		Pnl_01.add(SP_07);	
		
}
	
	
	public void llenarID(ArrayList<String> lista){
		M_V_C.llenar_Texto(lista,txt_IDMateria);
	}

	public void Blancos(){		
		M_V_C.Blancos(txt_IDMateria);
		M_V_C.Blancos(txt_Nombre);
	}

	public void ShowMensaje(boolean B){
		M_V_C.Result(B,Pnl_01);
		if(B) Blancos();
	}
			
	public Materia Recupera_Datos(){		
		boolean A;
		A = M_V_C.Validar_Campos(txt_Nombre);		
			
		if(A){
			Materia.setNombre(txt_Nombre.getText());
			return Materia;
		}
		return null;
	}
	
	//Getters & Setters
	public JButton getBtn_Guardar() {
		return btn_Guardar;
	}
	
}