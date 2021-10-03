package interfaces;

import java.util.ArrayList;

import clases.CursoRecomendado;
import clases.Cursos;
import clases.Persona;
import clases.ProgramacionHorario;
import clases.ProgramacionHorarioDet;
import clases.Seccion;




public interface InterfacesPrograHorarios {
	
	public int registrar(ProgramacionHorario t);
	public int buscarultcodhorario();
	public ArrayList<Persona> listadoDocenteCombo();
	public ArrayList<Seccion> listadoSeccionCombo();
	public ArrayList<Cursos> listadoCursoCombo();
	public ArrayList<ProgramacionHorario> listadogeneralannioescolar(String tipo);
	public int registrardetalle(ProgramacionHorarioDet t);
	public ArrayList<ProgramacionHorarioDet> listadogeneralannioescolardetalle(int idasoci);
	public ArrayList<CursoRecomendado> listadoCursoRecomendado();
	

}
