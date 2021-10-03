package mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import clases.Acceso;
import clases.Perfil;
import interfaces.InterfacesAdministrador;
import util.MySQLConexion;

public class GestionAdministrador implements InterfacesAdministrador{

	@Override
	public ArrayList<Perfil> listadoPerfil() {
		// TODO Auto-generated method stub
		ArrayList<Perfil>lista=new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion.getConexion(); 
		   String sql = "{call usp_listadoPerfil()}";	
		   pst = con.prepareStatement(sql);
		   
		   rs=pst.executeQuery();   
		   while (rs.next()){
			   Perfil t = new Perfil();
			   t.setDescripcion(rs.getString(1));
			   lista.add(t);
		   }
		} catch (Exception e) {
		   System.out.println("Error en la sentencia " + e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
	return lista;
	}
	
	public Acceso iniciarsesion(String perfil, String usuario, String clave){
		Acceso x = null;
		Connection cn = null;
		CallableStatement cstm=null;
		ResultSet rs= null;
		try{			
			cn = MySQLConexion.getConexion();
			cstm =cn.prepareCall("{call usp_login(?,?,?)}");			
			cstm.setString(1, perfil);
			cstm.setString(2, usuario);
			cstm.setString(3, clave);			
			rs=cstm.executeQuery();
			System.out.println(cstm);			
			if(rs.next()){
				x=new Acceso();
				x.setPerfil(rs.getString(1));
				x.setUsuario(rs.getString(2));
				x.setContrasenna(rs.getString(3));					
				
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)rs.close();
				if(cstm!=null)rs.close();
				if(cn!=null)rs.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return x;		
	}

}
