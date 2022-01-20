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
	private JTextField 	txt_B_Nombre;
	
	public Registrar_Grupo() 
	{		
		setLayout(new BorderLayout(0, 0));
		
		//Panel
		Pnl_01 = new JPanel();
		Pnl_01.setBorder(null);
		Pnl_01.setBackground(new Color(238,237,237));
		add(Pnl_01, BorderLayout.CENTER);
		Pnl_01.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(18,35,158), 1, true));
		panel_1.setBounds(489, 28, 455, 218);
		Pnl_01.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(18,35,158), 1, true));
		panel.setBounds(35, 28, 427, 296);
		Pnl_01.add(panel);
		panel.setLayout(null);

		//C-RUD	
		JLabel R_Alumno = new JLabel("REGISTRAR GRUPO");
		R_Alumno.setBounds(24, 25, 309, 20);
		panel.add(R_Alumno);
		R_Alumno.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		JLabel lbl_IDGrupo = new JLabel("ID:");
		lbl_IDGrupo.setBounds(24, 76, 29, 16);
		panel.add(lbl_IDGrupo);
		lbl_IDGrupo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txt_IDGrupo = new JTextField();
		txt_IDGrupo.setBounds(50, 74, 110, 22);
		panel.add(txt_IDGrupo);
		txt_IDGrupo.setEditable(false);
		txt_IDGrupo.setForeground(Color.GRAY);
		txt_IDGrupo.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_IDGrupo.setColumns(10);
		txt_IDGrupo.setBorder(null);

		JLabel lbl_Nombre = new JLabel("NOMBRE:");
		lbl_Nombre.setBounds(24, 131, 68, 16);
		panel.add(lbl_Nombre);
		lbl_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txt_Nombre = new JTextField();
		txt_Nombre.setBounds(91, 128, 176, 22);
		txt_Nombre.setBorder(new LineBorder(new Color(13,106,191)));
		panel.add(txt_Nombre);
		txt_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Nombre.setForeground(Color.BLACK);
		txt_Nombre.setBackground(Color.WHITE);
		txt_Nombre.setColumns(10);

		JLabel lbl_Limite = new JLabel("LIMITE:");
		lbl_Limite.setBounds(24, 188, 50, 16);
		panel.add(lbl_Limite);
		lbl_Limite.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		Sp_Limite = new JSpinner();
		Sp_Limite.setBounds(91, 185, 50, 20);
		Sp_Limite.setBorder(new LineBorder(new Color(13,106,191)));
		panel.add(Sp_Limite);
		Sp_Limite.setModel(new SpinnerNumberModel(25, 15, 40, 1));
		
		
		//RUD
		JLabel B_Alumno = new JLabel("BUSCAR GRUPO");
		B_Alumno.setBounds(31, 11, 309, 20);
		panel_1.add(B_Alumno);
		B_Alumno.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		
		JLabel lbl_ID_B_Grupo = new JLabel("ID:");
		lbl_ID_B_Grupo.setBounds(31, 58, 29, 16);
		panel_1.add(lbl_ID_B_Grupo);
		lbl_ID_B_Grupo.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txtID_B_Grupo = new JTextField();
		txtID_B_Grupo.setBounds(56, 56, 110, 22);
		panel_1.add(txtID_B_Grupo);
		txtID_B_Grupo.setBorder(new LineBorder(new Color(13,106,191)));
		txtID_B_Grupo.setForeground(Color.BLACK);
		txtID_B_Grupo.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txtID_B_Grupo.setColumns(10);
		
		JLabel lbl_B_Nombre = new JLabel("NOMBRE:");
		lbl_B_Nombre.setBounds(31, 113, 68, 16);
		panel_1.add(lbl_B_Nombre);
		lbl_B_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		txt_B_Nombre = new JTextField();
		txt_B_Nombre.setBounds(98, 111, 176, 22);
		panel_1.add(txt_B_Nombre);
		txt_B_Nombre.setForeground(Color.BLACK);
		txt_B_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_B_Nombre.setColumns(10);
		txt_B_Nombre.setBorder(new LineBorder(new Color(13,106,191)));
		txt_B_Nombre.setBackground(Color.WHITE);
		
		//BOTONES
		btn_Guardar = new JButton("GUARDAR");
		btn_Guardar.setBounds(91, 236, 101, 35);
		panel.add(btn_Guardar);
		btn_Guardar.setForeground(Color.WHITE);
		btn_Guardar.setBackground(new Color(18,35,158));
		btn_Guardar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		btn_Cargar = new JButton("CARGAR");
		btn_Cargar.setBounds(242, 236, 101, 35);
		panel.add(btn_Cargar);
		btn_Cargar.setForeground(Color.WHITE);
		btn_Cargar.setBackground(new Color(18,35,158));
		btn_Cargar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JButton btn_Buscar_1 = new JButton("ACTUALIZAR");
		btn_Buscar_1.setForeground(Color.WHITE);
		btn_Buscar_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btn_Buscar_1.setBackground(new Color(18, 35, 158));
		btn_Buscar_1.setBounds(653, 276, 132, 35);
		Pnl_01.add(btn_Buscar_1);
		
		JButton btn_Buscar_1_1 = new JButton("MODIFICAR");
		btn_Buscar_1_1.setForeground(Color.WHITE);
		btn_Buscar_1_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btn_Buscar_1_1.setBackground(new Color(18, 35, 158));
		btn_Buscar_1_1.setBounds(489, 276, 132, 35);
		Pnl_01.add(btn_Buscar_1_1);
		
		JButton btn_Buscar_1_2 = new JButton("ELIMINAR");
		btn_Buscar_1_2.setForeground(Color.WHITE);
		btn_Buscar_1_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btn_Buscar_1_2.setBackground(new Color(18, 35, 158));
		btn_Buscar_1_2.setBounds(812, 276, 132, 35);
		Pnl_01.add(btn_Buscar_1_2);
		
		JButton btn_Buscar = new JButton("BUSCAR");
		btn_Buscar.setBounds(185, 159, 116, 35);
		panel_1.add(btn_Buscar);
		btn_Buscar.setBackground(new Color(18,35,158));
		btn_Buscar.setForeground(Color.WHITE);
		btn_Buscar.setFont(new Font("Arial Black", Font.PLAIN, 13));
		
		//TABLA SCROLL
		JScrollPane ScrollPane = new JScrollPane();
		ScrollPane.setBounds(35, 343, 909, 187);
		Pnl_01.add(ScrollPane);

		table = new JTable();
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
		M_V_C.Blancos(txt_B_Nombre);
		M_V_C.Blancos(txtID_B_Grupo);
		
	}

	public void ShowMensaje(boolean B){
		M_V_C.Result(B);
		if(B)Blancos();
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
	
}