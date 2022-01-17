package Entidades;

public class Maestro {

	private int 	ID;
	private String 	Nombre;
	private String 	Paterno;
	private String 	Materno;
	private String 	Tel;
	private String 	Email;

	//Getters & Setters
	public String getMaterno() {
		return Materno;
	}

	public void setMaterno(String apellidoMat) {
		Materno = apellidoMat;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public String getPaterno() {
		return Paterno;
	}

	public void setPaterno(String apellidoPat) {
		Paterno = apellidoPat;
	}

	public String getTel() {
		return Tel;
	}
	
	public void setTel(String tel) {
		Tel = tel;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}
	
}
