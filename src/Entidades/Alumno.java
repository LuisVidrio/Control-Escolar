package Entidades;

public class Alumno {

	private int 	Matricula;
	private String 	Nombre;
	private String 	Paterno;
	private String 	Materno;
	private String 	Tel;
	private String 	Email;
	private String  Grupo;
	
	//Getters & Setters
	public int getMatricula() {
		return Matricula;
	}
	
	public void setMatricula(int matricula) {
		Matricula = matricula;
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

	public void setPaterno(String paterno) {
		Paterno = paterno;
	}

	public String getMaterno() {
		return Materno;
	}

	public void setMaterno(String materno) {
		Materno = materno;
	}

	public String getGrupo() {
		return Grupo;
	}

	public void setGrupo(String grupo) {
		Grupo = grupo;
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
