package Interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Entidades.Grupo;

public class Registrar_Grupo extends javax.swing.JPanel 
{	
	private static final long serialVersionUID = 1L;
	
	private Grupo Grupo = new Grupo();
	
	private JTextField 	txt_IDGrupo;
	private JTextField 	txt_Nombre;
	private JButton	   	btn_Guardar;
	private JPanel 	   	Pnl_01;
	private JSpinner 	Sp_Limite;
	private JTable 		table;
	private JButton		btn_Cargar;
	
	public Registrar_Grupo() 
	{		
		setLayout(new BorderLayout(0, 0));
		
		//Panel
		Pnl_01 = new JPanel();
		Pnl_01.setBorder(null);
		Pnl_01.setBackground(Color.WHITE);
		add(Pnl_01, BorderLayout.CENTER);
		Pnl_01.setLayout(null);
		

		//TITULO
		JLabel R_Alumno = new JLabel("REGISTRAR GRUPO");
		R_Alumno.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		R_Alumno.setBounds(21, 34, 309, 20);
		Pnl_01.add(R_Alumno);	
		
		//FORMULARIO:COMPONENTES CON DATOS DE GRUPO
		JLabel lbl_IDGrupo = new JLabel("ID:");
		lbl_IDGrupo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_IDGrupo.setBounds(21, 85, 29, 16);
		Pnl_01.add(lbl_IDGrupo);
		txt_IDGrupo = new JTextField();
		txt_IDGrupo.setEditable(false);
		txt_IDGrupo.setForeground(Color.GRAY);
		txt_IDGrupo.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_IDGrupo.setBounds(47, 83, 110, 22);
		Pnl_01.add(txt_IDGrupo);
		txt_IDGrupo.setColumns(10);
		txt_IDGrupo.setBorder(null);
		
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
		
		//LIMITE
		JLabel lbl_Limite = new JLabel("LIMITE:");
		lbl_Limite.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_Limite.setBounds(21, 197, 50, 16);
		Pnl_01.add(lbl_Limite);
		Sp_Limite = new JSpinner();
		Sp_Limite.setModel(new SpinnerNumberModel(25, 15, 40, 1));
		Sp_Limite.setBounds(88, 194, 50, 20);
		Pnl_01.add(Sp_Limite);	
		
		//GUARDAR
		btn_Guardar = new JButton("Guardar");
		btn_Guardar.setBounds(21, 259, 92, 22);
		Pnl_01.add(btn_Guardar);
		
		//CARGAR
		btn_Cargar = new JButton("Cargar");
		btn_Cargar.setBounds(131, 259, 92, 22);
		Pnl_01.add(btn_Cargar);
		
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
			
		//CONTENEDOR DE TABLA
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 36, 546, 292);
		Pnl_01.add(scrollPane);
		
		//TABLA GRUPOS
		table = new JTable();
		scrollPane.setViewportView(table);	
		table.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		
}
	
	public void llenarTabla(DefaultTableModel T){
		M_V_C.llenarTabla(T, table);
	}
	
	public void llenarID(ArrayList<String> lista){
		M_V_C.llenar_Texto(lista,txt_IDGrupo);
	}

	public void Blancos() 
	{		
		M_V_C.Blancos(txt_IDGrupo);
		M_V_C.Blancos(txt_Nombre);
	}

	public void ShowMensaje(boolean B){
		M_V_C.Result(B,Pnl_01);
		if(B) Blancos();
	}

	public Grupo Recupera_Datos()
	{		
		boolean A;
		A = M_V_C.Validar_Campos(txt_Nombre);		
			
		if(A){
			Grupo.setNombre(txt_Nombre.getText());
			Grupo.setLimite((Integer)Sp_Limite.getValue());
			return Grupo;
		}
		return null;
	}
	
	//Getters & Setters
	public JButton getBtn_Guardar() {
		return btn_Guardar;
	}
	
	public JButton getBtn_Cargar() {
		return btn_Cargar;
	}
}