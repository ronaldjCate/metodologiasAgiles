package calculos;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Notas;
import mantenimientos.GestionNotas;

public class AcademiaBiblica {

	//PopupRegistroNotas prn=new PopupRegistroNotas();
	GestionNotas grn = new GestionNotas();
	
	public double calcularpromedio(Notas rn){
		double promedio = (rn.getNt1()+rn.getNt2()+rn.getNt3()+rn.getNt4())/4;
		return promedio;
	}
	
	
	
	public void actualizarnota(Notas registroNotas){
		
		registroNotas.getUsuAlumno();
		registroNotas.getCurso();
		registroNotas.getSeccion();
		registroNotas.getPeriodo();
		registroNotas.getNt1();
		registroNotas.getNt2();
		registroNotas.getNt3();
		registroNotas.getNt4();
		registroNotas.getPromedio();
		registroNotas.getEstado();
		
		GestionNotas grn = new GestionNotas();
		grn.actualizar(registroNotas);
		
		int ok=grn.actualizar(registroNotas);
		if(ok==0){
			JOptionPane.showMessageDialog(null, "No se actualizó las notas");
		}else{
			JOptionPane.showMessageDialog(null, "Notas Actualizado Correctamente");
		}
		
		
	}

}
