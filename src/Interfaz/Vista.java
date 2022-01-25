package Interfaz;

import java.awt.*;
import javax.swing.*;
import Modelo_Controlador.Controlador;
import javax.swing.border.LineBorder;

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
	private JMenu 		M_Alumnos, M_Maestros, M_Materias, M_Horarios, M_Calif, M_Grupos;
	
	private JMenuItem 	Item_Al_Registrar, Item_Al_Buscar;
	private JMenuItem 	Item_Ma_Registrar, Item_Ma_Buscar;
	private JMenuItem 	Item_Mt_Registrar;
	private JMenuItem 	Item_H_Registrar;	
	private JMenuItem 	Item_Ca_Consultar;
	private JMenuItem 	Item_G_Registrar;
	
	private JButton 	btnSalir;
	private JPanel 		Pnl_Inicio;
	private JButton     M_INICIO;
	private JLabel 		lbl_Imagen;
	
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
	    Pnl_Contenedor.setBounds(0, 42, 970, 568);
        Pnl_Principal.add(Pnl_Contenedor);
	    Pnl_Contenedor.setLayout(new CardLayout(0, 0));
	        
	    Pnl_Inicio = new JPanel();
	    Pnl_Inicio.setBorder(null);
	    Pnl_Inicio.setBackground(SystemColor.text);
	    Pnl_Contenedor.add(Pnl_Inicio, "name_963113578423700");
	    Pnl_Inicio.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(254,223,54));
	    panel.setBounds(0, 0, 286, 557);
	    Pnl_Inicio.add(panel);
	    panel.setLayout(null);
	    
	    lbl_Imagen = new JLabel("");
	    lbl_Imagen.setBounds(-63, 56, 416, 416);
	    panel.add(lbl_Imagen);
	    lbl_Imagen.setIcon(new ImageIcon(Vista.class.getResource("/Imagenes/istockphoto-1280604312-170667a.jpg")));
	    
	    Label lbl_Bienvenida = new Label("BIENVENIDO ADMIN");
	    lbl_Bienvenida.setForeground(Color.BLACK);
	    lbl_Bienvenida.setAlignment(Label.CENTER);
	    lbl_Bienvenida.setFont(new Font("Bahnschrift", Font.BOLD | Font.ITALIC, 40));
	    lbl_Bienvenida.setBounds(441, 113, 452, 162);
	    Pnl_Inicio.add(lbl_Bienvenida);
   
	    //Menu Bar's
	    Bar_Principal = new JMenuBar();
	    Bar_Principal.setBackground(new Color(254,223,54));
	    Bar_Principal.setBounds(0, 0, 916, 43);
	    Pnl_Principal.add(Bar_Principal);
	    
	
	    M_INICIO = new JButton("   I N I C I O  ");
	    M_INICIO.setHorizontalAlignment(SwingConstants.TRAILING);
	    M_INICIO.setForeground(Color.BLACK);
	    M_INICIO.setBackground(new Color(254,223,54));
	    M_INICIO.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    Bar_Principal.add(M_INICIO);
	    M_INICIO.setBorder(null);
	    
	    M_Alumnos = new JMenu("ALUMNOS");
	    M_Alumnos.setBackground(Color.WHITE);
	    M_Alumnos.setForeground(Color.BLACK);
	    M_Alumnos.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Alumnos);        
	    Item_Al_Registrar = new JMenuItem("Registrar");
	    Item_Al_Registrar.setBackground(new Color(255, 255, 153));
	    Item_Al_Registrar.setForeground(Color.DARK_GRAY);
	    Item_Al_Registrar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    M_Alumnos.add(Item_Al_Registrar);	        
	        
	    Item_Al_Buscar = new JMenuItem("Buscar");
	    Item_Al_Buscar.setBackground(new Color(255, 255, 153));
	    Item_Al_Buscar.setForeground(Color.DARK_GRAY);
	    Item_Al_Buscar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    M_Alumnos.add(Item_Al_Buscar);
	        
	    M_Maestros = new JMenu("MAESTROS");
	    M_Maestros.setForeground(Color.BLACK);
	    M_Maestros.setFont(new Font("Bahnschrift", Font.BOLD, 15));
	    Bar_Principal.add(M_Maestros);	        
	    Item_Ma_Registrar = new JMenuItem("Registrar");
	    Item_Ma_Registrar.setForeground(Color.DARK_GRAY);
	    Item_Ma_Registrar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    Item_Ma_Registrar.setBackground(new Color(255, 255, 153));
	    M_Maestros.add(Item_Ma_Registrar);	        
	    Item_Ma_Buscar = new JMenuItem("Buscar");
	    Item_Ma_Buscar.setForeground(Color.DARK_GRAY);
	    Item_Ma_Buscar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    Item_Ma_Buscar.setBackground(new Color(255, 255, 153));
	    M_Maestros.add(Item_Ma_Buscar);
	        
	    M_Materias = new JMenu("MATERIAS");
	    M_Materias.setForeground(Color.BLACK);
	    M_Materias.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Materias);        
	    Item_Mt_Registrar = new JMenuItem("Registrar");
	    Item_Mt_Registrar.setBackground(new Color(255, 255, 153));
	    Item_Mt_Registrar.setForeground(Color.DARK_GRAY);
	    Item_Mt_Registrar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    M_Materias.add(Item_Mt_Registrar); 
	        	        
	    M_Horarios = new JMenu("HORARIOS");
	    M_Horarios.setForeground(Color.BLACK);
	    M_Horarios.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Horarios);
	    Item_H_Registrar = new JMenuItem("Registrar");
	    Item_H_Registrar.setForeground(Color.DARK_GRAY);
	    Item_H_Registrar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    Item_H_Registrar.setBackground(new Color(255, 255, 153));
	    M_Horarios.add(Item_H_Registrar);	
	        
	    M_Calif = new JMenu("CALIFICACIONES");
	    M_Calif.setForeground(Color.BLACK);
	    M_Calif.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Calif);	        	    
	    Item_Ca_Consultar = new JMenuItem("Consultar");
	    Item_Ca_Consultar.setBackground(new Color(255, 255, 153));
	    Item_Ca_Consultar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    Item_Ca_Consultar.setForeground(Color.DARK_GRAY);
	    M_Calif.add(Item_Ca_Consultar);
	        
	    M_Grupos = new JMenu("GRUPOS");
	    M_Grupos.setForeground(Color.BLACK);
	    M_Grupos.setFont(new Font("Bahnschrift", Font.BOLD, 14));
	    Bar_Principal.add(M_Grupos);	        
	    Item_G_Registrar = new JMenuItem("Registrar");
	    Item_G_Registrar.setForeground(Color.DARK_GRAY);
	    Item_G_Registrar.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
	    Item_G_Registrar.setBackground(new Color(255, 255, 153));
	    M_Grupos.add(Item_G_Registrar);	        
	        
	    //BS
	    btnSalir = new JButton("X");
	    btnSalir.setFocusPainted(false);
	    btnSalir.setForeground(Color.WHITE);
	    btnSalir.setBackground(new Color(250, 128, 114));
	    btnSalir.setFont(new Font("Arial Black", Font.PLAIN, 13));
	    btnSalir.setBounds(915, 0, 55, 42);
	    Pnl_Principal.add(btnSalir);   
	    btnSalir.setBorder(null);
	    
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
 		R_Grupo.getBtn_Cargar().addActionListener(c);
 		R_Grupo.getBtn_Buscar().addActionListener(c);
 		R_Grupo.getBtn_Modificar().addActionListener(c);
 		R_Grupo.getBtn_Eliminar().addActionListener(c);
 		R_Grupo.getBtn_Actualizar().addActionListener(c);
 		
 		R_Materia.getBtn_Guardar().addActionListener(c);
 		R_Materia.getBtn_Cargar().addActionListener(c);
 		R_Materia.getBtn_Buscar().addActionListener(c);
 		R_Materia.getBtn_Modificar().addActionListener(c);
 		R_Materia.getBtn_Eliminar().addActionListener(c);
 		R_Materia.getBtn_Actualizar().addActionListener(c);
 		
		btnSalir.addActionListener(c);
		
		M_INICIO.addActionListener(c);
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
	
	public JPanel getPnl_Inicio() {
		return Pnl_Inicio;
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
	

	public JButton getM_INICIO() {
		return M_INICIO;
	}
}