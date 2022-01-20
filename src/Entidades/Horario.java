package Entidades;

public class Horario {

	private int ID_Horario;
	private int ID_Materia;
	private int ID_Maestro;
	private String Hora_Ini;
	private String Hora_Fin;
	private int ID_Grupo;
	
	//Getters & Setters
	public int getID_Horario() {
		return ID_Horario;
	}
	public void setID_Horario(int iD_Horario) {
		ID_Horario = iD_Horario;
	}
	public int getID_Materia() {
		return ID_Materia;
	}
	public void setID_Materia(int iD_Materia) {
		ID_Materia = iD_Materia;
	}
	public int getID_Maestro() {
		return ID_Maestro;
	}
	public void setID_Maestro(int iD_Maestro) {
		ID_Maestro = iD_Maestro;
	}
	public String getHora_Ini() {
		return Hora_Ini;
	}
	public void setHora_Ini(String hora_Ini) {
		Hora_Ini = hora_Ini;
	}
	public String getHora_Fin() {
		return Hora_Fin;
	}
	public void setHora_Fin(String hora_Fin) {
		Hora_Fin = hora_Fin;
	}
	public int getID_Grupo() {
		return ID_Grupo;
	}
	public void setID_Grupo(int iD_Grupo) {
		ID_Grupo = iD_Grupo;
	}
	
}
