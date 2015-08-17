package es.tfandroid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import es.tfandroid.beans.Download;
import es.tfandroid.beans.Marca;
import es.tfandroid.beans.Modelo;
import es.tfandroid.beans.News;


public class adminDAO {
	
	public boolean crearNoticia(String titulo,String descripcion,String urlImagen,String idioma,boolean visible){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
            CallableStatement calstm=conn.prepareCall("insert into noticias(titulo,descripcion,urlimagen,idioma,visible) values(?,?,?,?,?)");
			calstm.setString(1, titulo);
			calstm.setString(2, descripcion);
			calstm.setString(3, urlImagen);
			calstm.setString(4, idioma);
			calstm.setBoolean(5, visible);
			calstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return true;
	}
	public boolean modificarNoticia(int idnoticia,String titulo,String descripcion,String urlImagen,String idioma,boolean visible,String fecha){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
            CallableStatement calstm=conn.prepareCall("update noticias set titulo=?,descripcion=?,urlimagen=?,idioma=?,visible=?,fecha=? where idnoticia=? and idioma=?");
			calstm.setString(1, titulo);
			calstm.setString(2, descripcion);
			calstm.setString(3, urlImagen);
			calstm.setString(4, idioma);
			calstm.setBoolean(5, visible);
			calstm.setTimestamp(6, Timestamp.valueOf(fecha));
			calstm.setInt(7, idnoticia);
			calstm.setString(8, idioma);
			calstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return true;
	}
	public boolean borrarNoticia(String idnoticia,String idioma){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("delete from noticias where idnoticia=? and idioma=?");
			calstm.setInt(1,Integer.parseInt(idnoticia));
			calstm.setString(2,idioma);
			calstm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return ret;
	}
	public boolean crearDescarga(int idmarca,int idmodelo,String titulo, String descripcion, String urlimagen,String idioma, boolean visible,String info,String features){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
            CallableStatement calstm=conn.prepareCall("insert into downloads(idmarca,idmodelo,titulo,descripcion,urlimagen,idioma,visible,info,features) values(?,?,?,?,?,?,?,?,?)");
			calstm.setInt(1, idmarca);
			calstm.setInt(2, idmodelo);
			calstm.setString(3, titulo);
			calstm.setString(4, descripcion);
			calstm.setString(5, urlimagen);
			calstm.setString(6, idioma);
			calstm.setBoolean(7, visible);
			calstm.setString(8, info);
			calstm.setString(9, features);
			calstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return true;
	}
	public boolean modificarDescarga(String idmarca,String idmodelo,String titulo, String descripcion, String urlimagen,String idioma, String visible,String iddownload,String fecha,String info,String features) {
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("update downloads set titulo= ?,urlimagen=?,descripcion=?,idioma=?,visible=?,fecha=?,info=?,features? where idmarca=? and idmodelo=? and idioma=? and iddownload=?");
			calstm.setString(1, titulo);
			calstm.setString(2, urlimagen);
			calstm.setString(3, descripcion);
			calstm.setString(4, idioma);
			calstm.setBoolean(5, Boolean.parseBoolean(visible));
			calstm.setTimestamp(6, Timestamp.valueOf(fecha));
			calstm.setString(7, info);
			calstm.setString(8, features);
			calstm.setInt(9, Integer.parseInt(idmarca));
			calstm.setInt(10, Integer.parseInt(idmodelo));
			calstm.setString(11, idioma);
			calstm.setInt(12, Integer.parseInt(iddownload));
			calstm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return ret;
		
	}
	public boolean borrarDescarga(String idmarca,String idmodelo,String iddownload,String idioma){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("delete from downloads where idmarca=? and idmodelo=? and iddownload=? and idioma=?");
			calstm.setInt(1,Integer.parseInt(idmarca));
			calstm.setInt(2,Integer.parseInt(idmodelo));
			calstm.setInt(3,Integer.parseInt(iddownload));
			calstm.setString(4,idioma);
			calstm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return ret;
	}
	public boolean crearMarca(String titulo,String urlimagen,String descripcion,String visible){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("insert into marca(titulo,urlimagen,descripcion,visible) values(?,?,?,?)");
			calstm.setString(1, titulo);
			calstm.setString(2, urlimagen);
			calstm.setString(3, descripcion);
			calstm.setBoolean(4, Boolean.parseBoolean(visible));
			calstm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return ret;
	}
	public boolean modificarMarca(String idmarca,String titulo,String urlimagen,String descripcion,String visible){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("update marca set titulo= ?,urlimagen=?,descripcion=?,visible=? where idmarca=?");
			calstm.setString(1, titulo);
			calstm.setString(2, urlimagen);
			calstm.setString(3, descripcion);
			calstm.setBoolean(4, Boolean.parseBoolean(visible));
			calstm.setInt(5, Integer.parseInt(idmarca));
			calstm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return ret;
	}
	public boolean borrarMarca(String idmarca){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("delete from marca where idmarca=?");
			calstm.setInt(1,Integer.parseInt(idmarca));
			calstm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return ret;
	}
	public boolean crearModelo(int marca,String titulo, String urlimagen, String visible, String descripcion){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("insert into modelo(idmarca,titulo,urlimagen,descripcion,visible) values(?,?,?,?,?)");
			calstm.setInt(1, marca);
			calstm.setString(2, titulo);
			calstm.setString(3,urlimagen);
			calstm.setString(4,descripcion);
			calstm.setBoolean(5, Boolean.parseBoolean(visible));
			calstm.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return true;
	}
	public ArrayList consultaNoticias(String idioma){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			while(set.next()){
				News noticia=new News(set.getInt(1),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7));
				listaNoticias.add(noticia);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaNoticias;
	}
	public ArrayList consultaDescargas(){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,descripcion,urlimagen,idioma,visible from downloads order by fecha desc ");
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			while(set.next()){
				Download descarga=new Download(set.getInt(1),set.getInt(2),set.getInt(3),set.getTimestamp(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getBoolean(9),set.getString(10),set.getString(11));
				listaDescargas.add(descarga);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaDescargas;
	}
	public ArrayList consultaDescargas(String idioma,int marca,int modelo){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,descripcion,urlimagen,idioma,visible,info,features from downloads where idioma= ? and idmodelo= ? and idmarca = ? order by fecha desc ");
			calstm.setString(1, idioma);
			calstm.setInt(2,modelo);
			calstm.setInt(3,marca);
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			while(set.next()){
				Download descarga=new Download(set.getInt(1),set.getInt(2),set.getInt(3),set.getTimestamp(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getBoolean(9),set.getString(10),set.getString(11));
				listaDescargas.add(descarga);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaDescargas;
	}
	public ArrayList consultaMarcas(){
		ArrayList listaMarcas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idmarca,titulo,urlimagen,descripcion,visible from marca order by idmarca asc ");
			ResultSet set=calstm.executeQuery();
			listaMarcas=new ArrayList();
			while(set.next()){
				Marca marca=new Marca(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getBoolean(5));
				listaMarcas.add(marca);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaMarcas;
	}
	public ArrayList consultaModelos(){
		ArrayList listaModelos=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idmodelo,idmarca,titulo,urlimagen,descripcion,visible from modelo order by idmodelo asc ");
			ResultSet set=calstm.executeQuery();
			listaModelos=new ArrayList();
			while(set.next()){
				Modelo modelo=new Modelo(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),set.getBoolean(6));
				listaModelos.add(modelo);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaModelos;
	}
	public boolean modificarModelo(String idmarca,String idmodelo,String titulo,String urlimagen,String descripcion,String visible){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("update modelo set titulo= ?,urlimagen=?,descripcion=?,visible=? where idmarca=? and idmodelo=?");
			calstm.setString(1, titulo);
			calstm.setString(2, urlimagen);
			calstm.setString(3, descripcion);
			calstm.setBoolean(4, Boolean.parseBoolean(visible));
			calstm.setInt(5, Integer.parseInt(idmarca));
			calstm.setInt(6, Integer.parseInt(idmodelo));
			calstm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return ret;
	}
	public boolean borrarModelo(String idmarca,String idmodelo){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("delete from modelo where idmarca=? and idmodelo=?");
			calstm.setInt(1,Integer.parseInt(idmarca));
			calstm.setInt(2,Integer.parseInt(idmodelo));
			calstm.executeUpdate();
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return ret;
	}
	
}
