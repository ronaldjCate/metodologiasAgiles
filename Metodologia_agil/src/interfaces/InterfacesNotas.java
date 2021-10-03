package interfaces;

import java.util.ArrayList;

import clases.Notas;




public interface InterfacesNotas {
	public ArrayList<Notas> listadocursoInscritos(String usuario);
	public ArrayList<Notas> listadocombo();
	public ArrayList<Notas> listadocursoNota(String usuario, String periodo);
	public ArrayList<Notas> listadoalumnos(String curso,String periodo,String seccion);
	public int RegistrarNota(Notas s);
	public int actualizar(Notas c);
	public ArrayList<Notas> buscardetallecurso(String usu,String curso, String sec, String periodo); 
}
