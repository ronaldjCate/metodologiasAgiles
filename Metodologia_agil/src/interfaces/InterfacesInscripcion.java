package interfaces;

import java.util.ArrayList;

import clases.CursoRecomendado;
import clases.Cursos;
import clases.Inscripcion;
import clases.Persona;
import clases.ProgramacionHorario;
import clases.ProgramacionHorarioDet;
import clases.Seccion;
import clases.Notas;
import clases.Oferta;
import clases.OfertaCurso;




public interface InterfacesInscripcion {
	
	
	public ArrayList<ProgramacionHorarioDet> listadogeneralInscripcionCursos();
	public ArrayList<ProgramacionHorarioDet> buscarhorariomatricula(int codigo);
	public ArrayList<Inscripcion> listadoPagoInscripcion(String codigo);	
	public int RegistrarPagoInscripcion(Inscripcion s);
	public ArrayList<Notas> listadoCursoMatriculado(String usu);
	public ArrayList<Notas> listadoDetalleCursoMatriculado(String cur, String sec, String per, String usu);
	public ArrayList<OfertaCurso> listadooferta(double nota, String cur);
}
