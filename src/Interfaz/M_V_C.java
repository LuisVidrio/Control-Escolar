package Interfaz;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class M_V_C {
//METODOS DE VALIDACION EN CAMPOS ++ OTROS METODOS 
	
	//SON OYENTES!! #TRATARLOS DESPUES
	
	//SOLO DATOS NUMERICOS
	public static void Obligar_Numeros(KeyEvent e, String S){                                    
	    int key = e.getKeyChar();
	    boolean numeros = key >= 48 && key <= 57;
		        
	    if (!numeros)
	    	e.consume();

		if (S.trim().length() == 10) 
		    e.consume();	    
	}     
		
	//SOLO DATOS ALFABETICOS
	public static void Obligar_Alfabeto(KeyEvent e, String S) {                                    	    
		int key = e.getKeyChar();

		boolean mayusculas = key >= 65 && key <= 90;
		boolean minusculas = key >= 97 && key <= 122;
		boolean espacio = key == 32;
		            
		if (S.trim().length() == 50)
			e.consume();
		
		if (!(minusculas || mayusculas || espacio))
			e.consume();	 
	}
	
	
	//SOLO VERIFICACION SIN EVENTOS - SOLO VISTA
	
	
	//VALIDAR DIMENSIONES MINIMAS Y MAXIMAS	
	public static boolean Validar_Campos(JTextField Txt) {
		
		if(Txt.getText().length() < 1 || Txt.getText().length() > 50){ 		
			Txt.setBorder(new LineBorder(Color.RED));
			return false;
		}			
			return true;	
	}
	
	//TELEFONO
	public static boolean Validar_CamposTel(JTextField Txt){
		if(Txt.getText().length() != 10){ 		
			Txt.setBorder(new LineBorder(Color.RED));
			return false;
		}			
		return true;
	}
	
	
	
	//############################ HASTA AQUI YA SON METODOS DE LLENADO Y LIMPIADO ++ MENSAJEDIALOG(NO VALIDACIONES)
	
	//METODO PARA LLENAR CAMPOS DE COMBOBOX DESDE LA BD
	public static void llenar_Combo(ArrayList<String> lista, JComboBox<String> JCb){	
		JCb.removeAllItems();
		for(int i=0;i<lista.size();i++) 
			JCb.addItem(lista.get(i));
	}
	
	
	//PARA LLENAR UN TEXTFIELD DESDE LA BD "+1 PARA ID NO ES GENERAL AUN"
	public static void llenar_Texto(ArrayList<String> lista, JTextField M){
		if(lista.size() == 0){
			M.setText("1");
		}else{
			int	I = Integer.parseInt(lista.get(lista.size()-1)) + 1;
			M.setText(String.valueOf(I));	
		}
	}
	
	//METODO PARA LLENAR TABLA JTABLE CON DATOS DE LA BD
	public static void llenarTabla(DefaultTableModel T,JTable JT){
		JT.setModel(T);
	}
	
	//LIMPIA CAJAS DE TEXTO Y MSJ DE ''ERROR''
	public static void Blancos(JTextField T){		
		T.setText("");
		T.setBorder(null);
	}
		
	//MENSAJE DIALOG
	public static void Result(boolean B, JPanel P){
		if (B) JOptionPane.showMessageDialog(P, "~SE REGISTRO CON EXITO~");
		else JOptionPane.showMessageDialog(P, "ERROR\n~VERIFICAR LOS CAMPOS~");
	}

	
}

