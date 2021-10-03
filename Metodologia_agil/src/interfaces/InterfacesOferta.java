package interfaces;

import java.util.ArrayList;

import clases.Oferta;
import clases.OfertaCurso;

public interface InterfacesOferta {
	
	public ArrayList<Oferta> listadoOferta();
	public int RegistrarOferta(Oferta p);
	
	public ArrayList<OfertaCurso> listadoOfertaCurso(int codigo);
	public int RegistrarOfertaCurso(OfertaCurso p);
	

}
