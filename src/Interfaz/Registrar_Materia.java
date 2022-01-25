package Interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Entidades.Materia;

public class Registrar_Materia extends javax.swing.JPanel 
{	
	private static final long serialVersionUID = 1L;
	
	private Materia Materia = new Materia();
	
	private JTextField 	txt_IDMateria;
	private JTextField 	txt_Nombre;
	private JButton	   	btn_Guardar;
	private JPanel 	   	Pnl_01;
	private JTable 		table;
	private JButton		btn_Cargar;
	private JTextField 	txtID_B_Materia;
	private JButton btn_Actualizar, btn_Modificar, btn_Eliminar, btn_Buscar;
	
	public Registrar_Materia() 
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
		JLabel R_Materia = new JLabel("REGISTRAR MATERIA");
		R_Materia.setBounds(24, 25, 309, 20);
		Pnl_Registrar.add(R_Materia);
		R_Materia.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		
		JLabel lbl_IDMateria = new JLabel("ID:");
		lbl_IDMateria.setBounds(24, 76, 29, 16);
		Pnl_Registrar.add(lbl_IDMateria);
		lbl_IDMateria.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txt_IDMateria = new JTextField();
		txt_IDMateria.setBounds(50, 74, 110, 22);
		Pnl_Registrar.add(txt_IDMateria);
		txt_IDMateria.setEditable(false);
		txt_IDMateria.setForeground(Color.GRAY);
		txt_IDMateria.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_IDMateria.setColumns(10);
		txt_IDMateria.setBorder(null);

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
		
		
		//RUD
		JLabel B_Materia = new JLabel("BUSCAR MATERIA");
		B_Materia.setBounds(31, 22, 309, 20);
		Pnl_Buscar.add(B_Materia);
		B_Materia.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		
		JLabel lbl_ID_B_Materia = new JLabel("ID:");
		lbl_ID_B_Materia.setBounds(31, 72, 29, 16);
		Pnl_Buscar.add(lbl_ID_B_Materia);
		lbl_ID_B_Materia.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txtID_B_Materia = new JTextField();
		txtID_B_Materia.setBounds(56, 70, 110, 22);
		Pnl_Buscar.add(txtID_B_Materia);
		txtID_B_Materia.setBorder(new LineBorder(new Color(13,106,191)));
		txtID_B_Materia.setForeground(Color.BLACK);
		txtID_B_Materia.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txtID_B_Materia.setColumns(10);
		
		//BOTONES
		btn_Guardar = new JButton("GUARDAR");
		btn_Guardar.setBounds(91, 207, 101, 35);
		Pnl_Registrar.add(btn_Guardar);
		btn_Guardar.setForeground(Color.WHITE);
		btn_Guardar.setBackground(new Color(18,35,158));
		btn_Guardar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn_Cargar = new JButton("CARGAR");
		btn_Cargar.setBounds(243, 207, 101, 35);
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
		M_V_C.llenar_Texto(lista,txt_IDMateria);
	}
	

	public void Blancos() {
		M_V_C.Blancos(txt_Nombre);
		M_V_C.Blancos(txtID_B_Materia);
		
	}

	public void ShowMensaje(boolean B){
		M_V_C.Result(B);
		if(B)Blancos();
	}

	public void Modificar() {
		table.setEnabled(true);
	}
	

	public Materia Buscar_Materia() 
	{
			Materia.setID(Integer.parseInt(txtID_B_Materia.getText()));
			return Materia;
	}
	
	public Materia Recupera_Datos()
	{		
		if(M_V_C.Validar_Campos(txt_Nombre)){
			Materia.setNombre(txt_Nombre.getText());
			return Materia;
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