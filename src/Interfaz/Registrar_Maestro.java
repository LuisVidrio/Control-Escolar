package Interfaz;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import Entidades.Maestro;

public class Registrar_Maestro extends javax.swing.JPanel 
{
	
	private static final long serialVersionUID = 1L;
	
	private Maestro Maestro = new Maestro();
	
	private JTextField txt_IDMaestro;
	private JTextField txt_Nombre;
	private JTextField txt_Paterno;
	private JTextField txt_Materno;
	private JTextField txt_Tel;
	private JTextField txt_Email;
	private JTextField txt_Email2;
	private JButton	   btn_Guardar;
	private JPanel Pnl_01;
	
	
	public Registrar_Maestro() 
	{		
		setLayout(new BorderLayout(0, 0));
		
		//Panel
		Pnl_01 = new JPanel();
		Pnl_01.setBorder(null);
		Pnl_01.setBackground(Color.WHITE);
		add(Pnl_01, BorderLayout.CENTER);
		Pnl_01.setLayout(null);
		
		//TITULO
		JLabel R_Maestro = new JLabel("REGISTRAR MAESTRO");
		R_Maestro.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		R_Maestro.setBounds(21, 34, 309, 20);
		Pnl_01.add(R_Maestro);	
		
		//FORMULARIO:COMPONENTES CON DATOS DE MAESTRO
		JLabel lbl_IDMaestro = new JLabel("MATRICULA:");
		lbl_IDMaestro.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_IDMaestro.setBounds(21, 85, 82, 16);
		Pnl_01.add(lbl_IDMaestro);
		txt_IDMaestro = new JTextField();
		txt_IDMaestro.setEditable(false);
		txt_IDMaestro.setForeground(Color.GRAY);
		txt_IDMaestro.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_IDMaestro.setBounds(104, 83, 110, 22);
		Pnl_01.add(txt_IDMaestro);
		txt_IDMaestro.setColumns(10);
		txt_IDMaestro.setBorder(null);
		
		//NOMBRE
		JLabel lbl_Nombre = new JLabel("NOMBRE:");
		lbl_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_Nombre.setBounds(21, 140, 82, 16);
		Pnl_01.add(lbl_Nombre);
		txt_Nombre = new JTextField();
		txt_Nombre.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Nombre.setForeground(Color.LIGHT_GRAY);
		txt_Nombre.setBackground(Color.WHITE);
		txt_Nombre.setBounds(88, 137, 176, 22);
		Pnl_01.add(txt_Nombre);
		txt_Nombre.setColumns(10);
		txt_Nombre.setBorder(null);
		
		//PATERNO
		JLabel lbl_Paterno = new JLabel("APELLIDO PATERNO:");
		lbl_Paterno.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_Paterno.setBounds(271, 140, 139, 16);
		Pnl_01.add(lbl_Paterno);
		txt_Paterno = new JTextField();
		txt_Paterno.setForeground(Color.LIGHT_GRAY);
		txt_Paterno.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Paterno.setBounds(411, 137, 176, 22);
		Pnl_01.add(txt_Paterno);
		txt_Paterno.setColumns(10);
		txt_Paterno.setBorder(null);
		
		//MATERNO
		JLabel lbl_Materno = new JLabel("APELLIDO MATERNO:");
		lbl_Materno.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_Materno.setBounds(597, 140, 139, 16);
		Pnl_01.add(lbl_Materno);
		txt_Materno = new JTextField();
		txt_Materno.setForeground(Color.LIGHT_GRAY);
		txt_Materno.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Materno.setBounds(737, 137, 176, 22);
		Pnl_01.add(txt_Materno);
		txt_Materno.setColumns(10);
		txt_Materno.setBorder(null);
		
		//TELEFONO
		JLabel lbl_Tel = new JLabel("TELEFONO:");
		lbl_Tel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_Tel.setBounds(22, 206, 76, 16);
		Pnl_01.add(lbl_Tel);		
		txt_Tel = new JTextField();	
		txt_Tel.setForeground(Color.LIGHT_GRAY);
		txt_Tel.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Tel.setBounds(99, 203, 110, 22);
		Pnl_01.add(txt_Tel);
		txt_Tel.setColumns(10);
		txt_Tel.setBorder(null);
		
		//EMAIL
		JLabel lbl_Email = new JLabel("EMAIL:");
		lbl_Email.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lbl_Email.setBounds(214, 206, 49, 16);
		Pnl_01.add(lbl_Email);		
		txt_Email = new JTextField();
		txt_Email.setForeground(Color.LIGHT_GRAY);
		txt_Email.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Email.setBounds(265, 203, 146, 22);
		Pnl_01.add(txt_Email);
		txt_Email.setColumns(10); 		
		JLabel lblAltgr = new JLabel(" @");
		lblAltgr.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblAltgr.setBounds(413, 206, 18, 16);
		Pnl_01.add(lblAltgr);		
		txt_Email2 = new JTextField();
		txt_Email2.setForeground(Color.LIGHT_GRAY);
		txt_Email2.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		txt_Email2.setBounds(431, 203, 117, 22);
		Pnl_01.add(txt_Email2);
		txt_Email2.setColumns(10);
		txt_Email.setBorder(null);
		txt_Email2.setBorder(null);
				
		//GUARDAR
		btn_Guardar = new JButton("Guardar");
		btn_Guardar.setBounds(411, 441, 155, 47);
		btn_Guardar.setForeground(Color.WHITE);
		btn_Guardar.setBackground(new Color(18,35,158));
		btn_Guardar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		Pnl_01.add(btn_Guardar);
		
		//SEPARADORES
		JSeparator SP_01 = new JSeparator();
		SP_01.setForeground(Color.BLACK);
		SP_01.setBackground(Color.BLACK);
		SP_01.setBounds(88, 159, 176, 2);
		Pnl_01.add(SP_01);	
		JSeparator SP_02 = new JSeparator();
		SP_02.setForeground(Color.BLACK);
		SP_02.setBackground(Color.BLACK);
		SP_02.setBounds(411, 159, 176, 2);
		Pnl_01.add(SP_02);
		JSeparator SP_03 = new JSeparator();
		SP_03.setForeground(Color.BLACK);
		SP_03.setBackground(Color.BLACK);
		SP_03.setBounds(737, 159, 176, 2);
		Pnl_01.add(SP_03);
		JSeparator SP_04 = new JSeparator();
		SP_04.setForeground(Color.BLACK);
		SP_04.setBackground(Color.BLACK);
		SP_04.setBounds(99, 225, 110, 2);
		Pnl_01.add(SP_04);
		JSeparator SP_05 = new JSeparator();
		SP_05.setForeground(Color.BLACK);
		SP_05.setBackground(Color.BLACK);
		SP_05.setBounds(265, 225, 145, 2);
		Pnl_01.add(SP_05);
		JSeparator SP_06 = new JSeparator();
		SP_06.setForeground(Color.BLACK);
		SP_06.setBackground(Color.BLACK);
		SP_06.setBounds(431, 225, 117, 2);
		Pnl_01.add(SP_06);
		JSeparator SP_07 = new JSeparator();
		SP_07.setForeground(Color.BLACK);
		SP_07.setBackground(Color.BLACK);
		SP_07.setBounds(104, 105, 110, 2);
		Pnl_01.add(SP_07);
		
		
		//Oyentes //Provisionales
		txt_Nombre.addKeyListener(new KeyAdapter(){public void keyTyped(KeyEvent e) {M_V_C.Obligar_Alfabeto(e,txt_Nombre.getText());}});
		txt_Paterno.addKeyListener(new KeyAdapter(){public void keyTyped(KeyEvent e) {M_V_C.Obligar_Alfabeto(e,txt_Paterno.getText());}});
		txt_Materno.addKeyListener(new KeyAdapter(){public void keyTyped(KeyEvent e) {M_V_C.Obligar_Alfabeto(e,txt_Materno.getText());}});
		txt_Tel.addKeyListener(new KeyAdapter(){public void keyTyped(KeyEvent e) {M_V_C.Obligar_Numeros(e,txt_Tel.getText());}});	
	
		M_V_C.DeshabilitarCopyPaste(txt_Nombre);
		M_V_C.DeshabilitarCopyPaste(txt_Paterno);
		M_V_C.DeshabilitarCopyPaste(txt_Materno);
		M_V_C.DeshabilitarCopyPaste(txt_Tel);
}
	
	//LLENA TEXTO DE MATRICULA
	public void llenarID(ArrayList<String> lista){
		M_V_C.llenar_Texto(lista,txt_IDMaestro);
	}

	//LIMPIA LAS CAJAS 
	public void Blancos() 
	{		
		M_V_C.Blancos(txt_IDMaestro);
		M_V_C.Blancos(txt_Nombre);
		M_V_C.Blancos(txt_Paterno);
		M_V_C.Blancos(txt_Materno);
		M_V_C.Blancos(txt_Tel);
		M_V_C.Blancos(txt_Email);
		M_V_C.Blancos(txt_Email2);
	}

	//SHOW MESSAGE
	public void ShowMensaje(boolean B){
		M_V_C.Result(B);
		if(B)Blancos();
	}		
	
	//REGRESA UN OBJETO DE TIPO MAESTRO CON LOS DATOS INGRESADOS EN LOS CAMPOS
	public Maestro Recupera_Datos()
	{		
		boolean A,B,C,D,F,G;
		A = M_V_C.Validar_Campos(txt_Nombre);
		B = M_V_C.Validar_Campos(txt_Paterno);
		C = M_V_C.Validar_Campos(txt_Materno);
		D = M_V_C.Validar_CamposTel(txt_Tel);
		F = M_V_C.Validar_Campos(txt_Email);
		G = M_V_C.Validar_Campos(txt_Email2);
		
		if(A && B && C && D && F && G){
			Maestro.setNombre(txt_Nombre.getText());
			Maestro.setPaterno(txt_Paterno.getText());
			Maestro.setMaterno(txt_Materno.getText());			
			Maestro.setTel(txt_Tel.getText());
			Maestro.setEmail(txt_Email.getText()+"@"+txt_Email2.getText());						
			return Maestro;
		}
		return null;
	}

	//Getters & Setters
	public JButton getBtn_Guardar() {
		return btn_Guardar;
	}

	
}