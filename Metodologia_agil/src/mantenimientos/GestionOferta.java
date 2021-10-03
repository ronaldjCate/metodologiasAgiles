package mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import clases.Cursos;
import clases.Oferta;
import clases.OfertaCurso;
import interfaces.InterfacesOferta;
import util.MySQLConexion;

public class GestionOferta implements InterfacesOferta{

	@Override
	public ArrayList<Oferta> listadoOferta() {
		// TODO Auto-generated method stub
		ArrayList<Oferta>lista = new ArrayList<>();
		
		ResultSet rs = null;		
		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cstm=null;
		try{
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("select idtb_oferta,descripcion,empresa,sueldo,moneda from tb_oferta;");
			rs=cstm.executeQuery();			

			while(rs.next()){
				Oferta p = new Oferta();
				p.setCodigo(rs.getInt(1));				
				p.setDescripcion(rs.getString(2));
				p.setEmpresa(rs.getString(3));
				p.setSueldo(rs.getDouble(4));
				p.setMoneda(rs.getString(5));
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

	@Override
	public int RegistrarOferta(Oferta s) {
		// TODO Auto-generated method stub
		int rs=0;
		Connection con=null;		
		CallableStatement cstm=null;
		
		try {
			con =MySQLConexion.getConexion();
			String sql ="{call usp_insertar_oferta(?,?,?,?)};";
			cstm =con.prepareCall(sql);
			
			cstm.setString(1, s.getDescripcion());				
			cstm.setString(2, s.getEmpresa());
			cstm.setDouble(3, s.getSueldo());
			cstm.setString(4, s.getMoneda());
			
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
	public ArrayList<OfertaCurso> listadoOfertaCurso(int codigo) {
		// TODO Auto-generated method stub
		ArrayList<OfertaCurso>lista = new ArrayList<>();
		
		ResultSet rs = null;		
		Connection con = null;
		PreparedStatement pst = null;
		CallableStatement cstm=null;
		try{
			con = MySQLConexion.getConexion();			
			cstm =con.prepareCall("select curso,oferta,notaAplica from tb_ofertaCurso where tb_oferta_idtb_oferta=?;");
			cstm.setInt(1,codigo);
			rs=cstm.executeQuery();			

			while(rs.next()){
				OfertaCurso p = new OfertaCurso();
				
				p.setOferta(rs.getString(1));
				p.setCurso(rs.getString(2));
				p.setNota(rs.getDouble(3));
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

	@Override
	public int RegistrarOfertaCurso(OfertaCurso s) {
		// TODO Auto-generated method stub
		int rs=0;
		Connection con=null;		
		CallableStatement cstm=null;
		
		try {
			con =MySQLConexion.getConexion();
			String sql ="insert into tb_ofertaCurso values (null,?,?,?,?);";
			cstm =con.prepareCall(sql);
									
			cstm.setString(1, s.getCurso());
			cstm.setString(2, s.getOferta());
			cstm.setInt(3, s.getCodigoOferta());
			cstm.setDouble(4, s.getNota());
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

}

