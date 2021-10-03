import static org.junit.Assert.*;

import org.junit.Test;

import clases.Cursos;

public class CursoPrecios {

	@Test
	public void PrecioCursomayorcero() {
		Cursos curso = new Cursos();
		double costo = 4.0;

		boolean resultado = curso.validarCosto(costo);
		
		System.out.println("Resultado: "+resultado+" "+costo);
	}

}
