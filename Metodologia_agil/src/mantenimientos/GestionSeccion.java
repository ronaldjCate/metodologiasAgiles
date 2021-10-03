package mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Seccion;
import interfaces.InterfacesSeccion;
import util.MySQLConexion;

public class GestionSeccion implements InterfacesSeccion{
	
	@Override
	public int registrar(Seccion s){
		int rs=0;
		Connection con=null;		
		CallableStatement cstm=null;
		
		try {
			con =MySQLConexion.getConexion();
			String sql ="{call usp_registrar_seccion(?,?,?,?,?)}";
			cstm =con.prepareCall(sql);	
			
			cstm.setString(1, s.getCodigoSeccion());
			cstm.setString(2, s.getNom_seccion());
			cstm.setString(3, s.getTipo());						
			cstm.setInt(4, s.getCant_min_pers());
			cstm.setInt(5, s.getCant_max_pers());
			
			rs=cstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia "+e.getMessage());
		}finally{
			try {
				if(cstm!=null) cstm.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar");
			}
		}
		
		return rs;
	}
	
	
	@Override
	public ArrayList<Seccion> listado(){
		ArrayList<Seccion>lista = new ArrayList<>();
		
		ResultSet rs = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cstm=null;
		try{
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("{call usp_listaseccion()}");
			rs=cstm.executeQuery();			

			while(rs.next()){
				Seccion p = new Seccion();
				p.setCodigoSeccion(rs.getString(1));
				p.setNom_seccion(rs.getString(2));
				p.setTipo(rs.getString(3));
				p.setCant_max_pers(rs.getInt(4));
				p.setCant_min_pers(rs.getInt(5));
				
				lista.add(p);
			}
						
		}catch(Exception e){
			System.out.println("Error en la sentencia " +e.getMessage());
		}finally{
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar");
			}
		}
		
		return lista;
	}

	
}
