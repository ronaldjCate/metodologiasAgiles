package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import clases.Persona;
import interfaces.InterfacesPersona;
import util.MySQLConexion;

public class GestionPersona implements InterfacesPersona {
	
	@Override
	public ArrayList<Persona> listadopersona() {
		// TODO Auto-generated method stub
		ArrayList<Persona>lista = new ArrayList<>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = MySQLConexion.getConexion();
			String sql ="{call usp_listaPersona()}";
			pst = con.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Persona p = new Persona();
				
				p.setNombre(rs.getString(1));
				p.setApellido(rs.getString(2));;
				p.setSexo(rs.getString(3));
				p.setDniPersona(rs.getString(4));
				p.setTb_tipo_descripcion(rs.getString(5));																	
				lista.add(p);
			}
		}catch(Exception e){
			System.out.println("Error en la sentencia" + e.getMessage());
		}finally{
			try{
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}catch(Exception e){
				System.out.println("Error al cerrar");
			}
		}
		return lista;
	}

	@Override
	public int RegistrarPersona(Persona p) {
		// TODO Auto-generated method stub
		int rs=0;
		Connection con=null;
		PreparedStatement pst = null;
		
		try {
			con =MySQLConexion.getConexion();
			String sql ="call usp_insert_persona(?,?,?,?,?,?,?,?);";
			pst =con.prepareCall(sql);									
						
			pst.setString(1, p.getNombre());
			pst.setString(2, p.getApellido());
			pst.setString(3, p.getSexo());
			pst.setString(4, p.getFechaNacimiento());
			pst.setString(5, p.getCorreo());
			pst.setString(6, p.getNumeroTelefono());			
			pst.setString(7, p.getDniPersona());
			pst.setString(8, p.getTb_tipo_descripcion());						
			
			
			
			rs=pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la sentencia "+e.getMessage());
		}finally{
			try {
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar");
			}
		}
		
		return rs;
	}

}
