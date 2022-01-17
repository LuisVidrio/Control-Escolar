package Interfaz;

import java.awt.*;
import javax.swing.*;
import Modelo_Controlador.Controlador;

public class Vista extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//INSTANCIAS DE JPANELS /.-VISTAS
	private Registrar_Alumno 	R_Alumno  = new Registrar_Alumno();
	private Registrar_Maestro	R_Maestro = new Registrar_Maestro();
	private Registrar_Grupo		R_Grupo	  = new Registrar_Grupo();
	private Registrar_Materia	R_Materia = new Registrar_Materia();
	
	//COMPONENTES DE LA VENTANA PRINCIPALs
	private JPanel 		Pnl_Principal, Pnl_Contenedor;	
	private JMenuBar 	Bar_Principal;
	private JMenu 		M_Inicio, M_Alumnos, M_Maestros, M_Materias, M_Horarios, M_Calif, M_Grupos;
	
	private JMenuItem 	Item_Al_Registrar, Item_Al_Buscar;
	private JMenuItem 	Item_Ma_Registrar, Item_Ma_Buscar;
	private JMenuItem 	Item_Mt_Registrar, Item_Mt_Consultar;
	private JMenuItem 	Item_H_Registrar , Item_H_Consultar;	
	private JMenuItem 	Item_Ca_Consultar;
	private JMenuItem 	Item_G_Registrar , Item_G_Buscar;
	
	private JButton 	btnSalir;
	private JPanel 		Pnl_Inicio;
	
	public Vista()
	{
		//PARAMETROS DE LA VENTANA
		super("Control Escolar");
		setSize(969,600);
	    setLocationRelativeTo(null);	
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setUndecorated(true);
	
	    //COMPONENTES
	    //PANELS
	    Pnl_Principal = new JPanel();
	    getContentPane().add(Pnl_Principal, BorderLayout.CENTER);
	    Pnl_Principal.setLayout(null);

	    Pnl_Contenedor = new JPanel();
	    Pnl_Contenedor.setBackground(Color.WHITE);
	    Pnl_Contenedor.setBounds(0, 42, 970, 562);
        Pnl_Principal.add(Pnl_Contenedor);
        Pnl_Contenedor.setLayout(new CardLayout(0, 0));
	        
	    Pnl_Inicio = new JPanel();
	    Pnl_Contenedor.add(Pnl_Inicio);
   
	    //Menu Bar's
	    Bar_Principal = new JMenuBar();
	    Bar_Principal.setBounds(0, 0, 877, 43);
	    Pnl_Principal.add(Bar_Principal);
	        
	    M_Inicio = new JMenu("I N I C I O");
	    M_Inicio.setForeground(Color.DARK_GRAY);
	    M_Inicio.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Inicio);
	        
	    M_Alumnos = new JMenu("ALUMNOS");
	    M_Alumnos.setForeground(Color.DARK_GRAY);
	    M_Alumnos.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Alumnos);        
	    Item_Al_Registrar = new JMenuItem("Registrar");
	    Item_Al_Registrar.setBackground(Color.WHITE);
	    Item_Al_Registrar.setForeground(Color.GRAY);
	    Item_Al_Registrar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    M_Alumnos.add(Item_Al_Registrar);	        
	        
	    Item_Al_Buscar = new JMenuItem("Buscar");
	    Item_Al_Buscar.setBackground(Color.WHITE);
	    Item_Al_Buscar.setForeground(Color.GRAY);
	    Item_Al_Buscar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    M_Alumnos.add(Item_Al_Buscar);
	        
	    M_Maestros = new JMenu("MAESTROS");
	    M_Maestros.setForeground(Color.DARK_GRAY);
	    M_Maestros.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    Bar_Principal.add(M_Maestros);	        
	    Item_Ma_Registrar = new JMenuItem("Registrar");
	    Item_Ma_Registrar.setBackground(Color.WHITE);
	    M_Maestros.add(Item_Ma_Registrar);	        
	    Item_Ma_Buscar = new JMenuItem("Buscar");
	    Item_Ma_Buscar.setBackground(Color.WHITE);
	    M_Maestros.add(Item_Ma_Buscar);
	        
	    M_Materias = new JMenu("MATERIAS");
	    M_Materias.setForeground(Color.DARK_GRAY);
	    M_Materias.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Materias);        
	    Item_Mt_Registrar = new JMenuItem("Registrar");
	    M_Materias.add(Item_Mt_Registrar);       
	    Item_Mt_Consultar = new JMenuItem("Consultar");
	    M_Materias.add(Item_Mt_Consultar);
	        	        
	    M_Horarios = new JMenu("HORARIOS");
	    M_Horarios.setForeground(Color.DARK_GRAY);
	    M_Horarios.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Horarios);
	    Item_H_Registrar = new JMenuItem("Registrar");
	    M_Horarios.add(Item_H_Registrar);	        
	    Item_H_Consultar = new JMenuItem("Consultar");
	    M_Horarios.add(Item_H_Consultar);
	        
	    M_Calif = new JMenu("CALIFICACIONES");
	    M_Calif.setForeground(Color.DARK_GRAY);
	    M_Calif.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Calif);	        	    
	    Item_Ca_Consultar = new JMenuItem("Consultar");
	    M_Calif.add(Item_Ca_Consultar);
	        
	    M_Grupos = new JMenu("GRUPOS");
	    M_Grupos.setForeground(Color.DARK_GRAY);
	    M_Grupos.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Grupos);	        
	    Item_G_Registrar = new JMenuItem("Registrar");
	    M_Grupos.add(Item_G_Registrar);	        
	    Item_G_Buscar = new JMenuItem("Buscar");
	    M_Grupos.add(Item_G_Buscar);
	        
	    //BS
	    btnSalir = new JButton("SALIR");
	    btnSalir.setBackground(new Color(250, 128, 114));
	    btnSalir.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    btnSalir.setBounds(871, 0, 99, 43);
	    Pnl_Principal.add(btnSalir);   
	    
	}
	
	//OYENTES
	public void setControlador(Controlador c)
	{
		Item_Al_Registrar.addActionListener(c);	
 		Item_Ma_Registrar.addActionListener(c);
 		Item_Mt_Registrar.addActionListener(c);
 		Item_G_Registrar.addActionListener(c);
 				
 		R_Alumno.getBtn_Guardar().addActionListener(c);
 		R_Maestro.getBtn_Guardar().addActionListener(c);
 		R_Grupo.getBtn_Guardar().addActionListener(c);
 		R_Materia.getBtn_Guardar().addActionListener(c);
 		R_Grupo.getBtn_Cargar().addActionListener(c);
 		
		btnSalir.addActionListener(c);
	}

	//CAMBIA PANEL AL ELEGIR UNA OPCION DEL MENU
	public void nuevoPanel(JPanel PanelActual) 
	{
		Pnl_Contenedor.removeAll();
		Pnl_Contenedor.add(PanelActual);
		Pnl_Contenedor.repaint();
		Pnl_Contenedor.revalidate();
	}
	
	//Getters & Setters
	//INTERFACES
	public Registrar_Alumno getR_Alumno() {
		return R_Alumno;
	}

	public Registrar_Maestro getR_Maestro() {
		return R_Maestro;
	}

	public Registrar_Grupo getR_Grupo() {
		return R_Grupo;
	}
	
	public Registrar_Materia getR_Materia() {
		return R_Materia;
	}
	
	//COMPONENTES
	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	public JPanel getPnl_Contenedor() {
		return Pnl_Contenedor;
	}

	public JMenuItem getItem_Al_Registrar() {
		return Item_Al_Registrar;
	}

	public JMenuItem getItem_Ma_Registrar() {
		return Item_Ma_Registrar;
	}
	
	public JMenuItem getItem_G_Registrar() {
		return Item_G_Registrar;
	}
	
	public JMenuItem getItem_Mt_Registrar() {
		return Item_Mt_Registrar;
	}

	public JMenuItem getItem_H_Registrar() {
		return Item_H_Registrar;
	}

}