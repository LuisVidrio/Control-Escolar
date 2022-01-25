package Interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
	private JTextField 	txtID_B_Grupo;
	private JButton btn_Actualizar, btn_Modificar, btn_Eliminar, btn_Buscar;
	
	public Registrar_Grupo() 
	{		
		setLayout(new BorderLayout(0, 0));
		
		//Panel
		Pnl_01 = new JPanel();
		Pnl_01.setBorder(null);
		Pnl_01.setBackground(new Color(238,237,237));
		add(Pnl_01, BorderLayout.CENTER);
		Pnl_01.setLayout(null);
		
		JPanel Pnl_Buscar = new JPanel();
		Pnl_Buscar.setBorder(new LineBorder(new Color(18,35,158), 1, true));
		Pnl_Buscar.setBounds(489, 28, 455, 218);
		Pnl_01.add(Pnl_Buscar);
		Pnl_Buscar.setLayout(null);
		
		JPanel Pnl_Registrar = new JPanel();
		Pnl_Registrar.setBorder(new LineBorder(new Color(18,35,158), 1, true));
		Pnl_Registrar.setBounds(35, 28, 427, 296);
		Pnl_01.add(Pnl_Registrar);
		Pnl_Registrar.setLayout(null);

		//C-RUD	
		JLabel R_Alumno = new JLabel("REGISTRAR GRUPO");
		R_Alumno.setBounds(24, 25, 309, 20);
		Pnl_Registrar.add(R_Alumno);
		R_Alumno.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		JLabel lbl_IDGrupo = new JLabel("ID:");
		lbl_IDGrupo.setBounds(24, 76, 29, 16);
		Pnl_Registrar.add(lbl_IDGrupo);
		lbl_IDGrupo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txt_IDGrupo = new JTextField();
		txt_IDGrupo.setBounds(50, 74, 110, 22);
		Pnl_Registrar.add(txt_IDGrupo);
		txt_IDGrupo.setEditable(false);
		txt_IDGrupo.setForeground(Color.GRAY);
		txt_IDGrupo.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_IDGrupo.setColumns(10);
		txt_IDGrupo.setBorder(null);

		JLabel lbl_Nombre = new JLabel("NOMBRE:");
		lbl_Nombre.setBounds(24, 131, 68, 16);
		Pnl_Registrar.add(lbl_Nombre);
		lbl_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txt_Nombre = new JTextField();
		txt_Nombre.setBounds(91, 128, 176, 22);
		txt_Nombre.setBorder(new LineBorder(new Color(13,106,191)));
		Pnl_Registrar.add(txt_Nombre);
		txt_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Nombre.setForeground(Color.BLACK);
		txt_Nombre.setBackground(Color.WHITE);
		txt_Nombre.setColumns(10);

		JLabel lbl_Limite = new JLabel("LIMITE:");
		lbl_Limite.setBounds(24, 188, 50, 16);
		Pnl_Registrar.add(lbl_Limite);
		lbl_Limite.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		Sp_Limite = new JSpinner();
		Sp_Limite.setBounds(91, 185, 50, 20);
		Sp_Limite.setBorder(new LineBorder(new Color(13,106,191)));
		Pnl_Registrar.add(Sp_Limite);
		Sp_Limite.setModel(new SpinnerNumberModel(25, 15, 40, 1));
		
		
		//RUD
		JLabel B_Alumno = new JLabel("BUSCAR GRUPO");
		B_Alumno.setBounds(31, 22, 309, 20);
		Pnl_Buscar.add(B_Alumno);
		B_Alumno.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		
		JLabel lbl_ID_B_Grupo = new JLabel("ID:");
		lbl_ID_B_Grupo.setBounds(31, 72, 29, 16);
		Pnl_Buscar.add(lbl_ID_B_Grupo);
		lbl_ID_B_Grupo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txtID_B_Grupo = new JTextField();
		txtID_B_Grupo.setBounds(56, 70, 110, 22);
		Pnl_Buscar.add(txtID_B_Grupo);
		txtID_B_Grupo.setBorder(new LineBorder(new Color(13,106,191)));
		txtID_B_Grupo.setForeground(Color.BLACK);
		txtID_B_Grupo.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txtID_B_Grupo.setColumns(10);
		
		//BOTONES
		btn_Guardar = new JButton("GUARDAR");
		btn_Guardar.setBounds(91, 236, 101, 35);
		Pnl_Registrar.add(btn_Guardar);
		btn_Guardar.setForeground(Color.WHITE);
		btn_Guardar.setBackground(new Color(18,35,158));
		btn_Guardar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn_Cargar = new JButton("CARGAR");
		btn_Cargar.setBounds(242, 236, 101, 35);
		Pnl_Registrar.add(btn_Cargar);
		btn_Cargar.setForeground(Color.WHITE);
		btn_Cargar.setBackground(new Color(18,35,158));
		btn_Cargar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn_Actualizar = new JButton("ACTUALIZAR");
		btn_Actualizar.setForeground(Color.WHITE);
		btn_Actualizar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btn_Actualizar.setBackground(new Color(18, 35, 158));
		btn_Actualizar.setBounds(653, 276, 132, 35);
		Pnl_01.add(btn_Actualizar);
		
		btn_Modificar = new JButton("MODIFICAR");
		btn_Modificar.setForeground(Color.WHITE);
		btn_Modificar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btn_Modificar.setBackground(new Color(18, 35, 158));
		btn_Modificar.setBounds(489, 276, 132, 35);
		Pnl_01.add(btn_Modificar);
		
		btn_Eliminar = new JButton("ELIMINAR");
		btn_Eliminar.setForeground(Color.WHITE);
		btn_Eliminar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btn_Eliminar.setBackground(new Color(18, 35, 158));
		btn_Eliminar.setBounds(812, 276, 132, 35);
		Pnl_01.add(btn_Eliminar);
		
		btn_Buscar = new JButton("BUSCAR");
		btn_Buscar.setBounds(185, 141, 116, 35);
		Pnl_Buscar.add(btn_Buscar);
		btn_Buscar.setBackground(new Color(18,35,158));
		btn_Buscar.setForeground(Color.WHITE);
		btn_Buscar.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		//TABLA SCROLL
		JScrollPane ScrollPane = new JScrollPane();
		ScrollPane.setBounds(35, 343, 909, 187);
		Pnl_01.add(ScrollPane);

		table = new JTable();
		table.setEnabled(false);
		ScrollPane.setViewportView(table);	
		table.setFont(new Font("Arial", Font.PLAIN, 14));
	
}
	
	public void llenarTabla(DefaultTableModel T){
		M_V_C.llenarTabla(T, table);
	}
	
	public void llenarID(ArrayList<String> lista){
		M_V_C.llenar_Texto(lista,txt_IDGrupo);
	}
	

	public void Blancos() {
		M_V_C.Blancos(txt_Nombre);
		M_V_C.Blancos(txtID_B_Grupo);
		
	}

	public void ShowMensaje(boolean B){
		M_V_C.Result(B);
		if(B)Blancos();
	}

	public void Modificar() {
		table.setEnabled(true);
	}
	
	public DefaultTableModel Actualizar() {
		table.setEnabled(false);
		DefaultTableModel T = (DefaultTableModel) table.getModel();
		return T;
	}

	public Grupo Buscar_Grupo() 
	{
			Grupo.setID_Grupo(Integer.parseInt(txtID_B_Grupo.getText()));
			return Grupo;
	}
	
	public Grupo Recupera_Datos()
	{		
		if(M_V_C.Validar_Campos(txt_Nombre)){
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

	public JButton getBtn_Actualizar() {
		return btn_Actualizar;
	}

	public JButton getBtn_Modificar() {
		return btn_Modificar;
	}

	public JButton getBtn_Eliminar() {
		return btn_Eliminar;
	}

	public JButton getBtn_Buscar() {
		return btn_Buscar;
	}

	
	
}