package interfaces;

import java.util.ArrayList;

import clases.Cursos;
import clases.DetCursos;

public interface InterfacesCursos {
	public int RegistrarCurso(Cursos p);
	public int RegistrarDetCurso(DetCursos p);
	public int buscarultcoCurso();
	public ArrayList<Cursos> listado();
	public ArrayList<DetCursos> listadocursodet(int idcur);
}
