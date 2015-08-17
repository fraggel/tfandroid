package es.tfandroid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import es.tfandroid.beans.Download;
import es.tfandroid.beans.Inicio;
import es.tfandroid.beans.Marca;
import es.tfandroid.beans.Modelo;
import es.tfandroid.beans.News;


public class tfandroidDAO {
	
	public ArrayList consultaNoticiasCortas(String idioma){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			int cont=0;
			while(set.next()){
				News noticia=new News(set.getInt(1),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7));
				listaNoticias.add(noticia);
				cont++;
				if(cont==5){
					break;
				}
			}
			conn.close();
		} catch (Exception e) {
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
	public ArrayList consultaNoticias(String idioma){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			while(set.next()){
				News noticia=new News(set.getInt(1),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7));
				listaNoticias.add(noticia);
			}
			conn.close();
		} catch (Exception e) {
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

	public ArrayList consultaDescargas(String idioma,int marca,int modelo){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,descripcion,urlimagen,idioma,visible,info,features,marcaModelo from downloads where idioma= ? and idmodelo= ? and idmarca = ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			calstm.setInt(2,modelo);
			calstm.setInt(3,marca);
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			while(set.next()){
				Download descarga=new Download(set.getInt(1),set.getInt(2),set.getInt(3),set.getTimestamp(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getBoolean(9),set.getString(10),set.getString(11),set.getString(12));
				listaDescargas.add(descarga);
			}
			conn.close();
		} catch (Exception e) {
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
			CallableStatement calstm=conn.prepareCall("select idmarca,titulo,urlimagen,descripcion,visible from marca where visible=1 order by idmarca asc ");
			ResultSet set=calstm.executeQuery();
			listaMarcas=new ArrayList();
			while(set.next()){
				Marca marca=new Marca(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getBoolean(5));
				listaMarcas.add(marca);
			}
			conn.close();
		} catch (Exception e) {
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
			CallableStatement calstm=conn.prepareCall("select idmodelo,idmarca,titulo,urlimagen,descripcion,visible from modelo where visible=1 order by idmodelo asc ");
			ResultSet set=calstm.executeQuery();
			listaModelos=new ArrayList();
			int cont=0;
			while(set.next()){
				Modelo modelo=new Modelo(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),set.getBoolean(6));
				listaModelos.add(modelo);
				cont++;
			}
			conn.close();
		} catch (Exception e) {
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
	public ArrayList consultaModelosMarca(int idmarca){
		ArrayList listaModelos=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idmodelo,idmarca,titulo,urlimagen,descripcion,visible from modelo where idmarca = ? and visible=1 order by idmodelo asc ");
			calstm.setInt(1, idmarca);
			ResultSet set=calstm.executeQuery();
			listaModelos=new ArrayList();
			int cont=0;
			while(set.next()){
				Modelo modelo=new Modelo(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),set.getBoolean(6));
				listaModelos.add(modelo);
				cont++;
			}
			conn.close();
		} catch (Exception e) {
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
	public ArrayList buscarEnWebDescargas(String texto,String idioma){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,descripcion,urlimagen,idioma,visible,info,features,marcaModelo from downloads where idioma= ? and visible=1 and (titulo like ? or descripcion like ?) order by fecha desc ");
			calstm.setString(1, idioma);
			calstm.setString(2,texto);
			calstm.setString(3,texto);
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			while(set.next()){
				Download descarga=new Download(set.getInt(1),set.getInt(2),set.getInt(3),set.getTimestamp(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getBoolean(9),set.getString(10),set.getString(11),set.getString(12));
				listaDescargas.add(descarga);
			}
			conn.close();
		} catch (Exception e) {
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
	public ArrayList buscarEnWebNoticias(String texto,String idioma){
		ArrayList listaNews=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
            conn = ((DataSource)(ctx.lookup("jdbc/tfandroid"))).getConnection();
            CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? and visible=1 and (titulo like ? or descripcion like ?) order by fecha desc ");
			calstm.setString(1, idioma);
			calstm.setString(2,texto);
			calstm.setString(3,texto);
			ResultSet set=calstm.executeQuery();
			listaNews=new ArrayList();
			while(set.next()){
				News noticia=new News(set.getInt(1),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7));
				listaNews.add(noticia);
			}
			conn.close();
		} catch (Exception e) {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return listaNews;
	}
	public ArrayList consultarInicio(String idioma){
		ArrayList listaConjunta=new ArrayList();
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idioma= ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			
			int cont=0;
			while(set.next()){
				Inicio noticia=new Inicio(set.getInt(1),-1,-1,set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7),"");
				listaConjunta.add(noticia);
				cont++;
				if(cont==10){
					break;
				}
			}
			conn.close();
		} catch (Exception e) {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup("jdbc/tfandroid"));
            conn = ds.getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,titulo,fecha,descripcion,urlimagen,idioma,visible,marcaModelo from downloads where idioma= ? and visible=1 order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			int cont=0;
			while(set.next()){
				
				Inicio descarga=new Inicio(set.getInt(1),set.getInt(3),set.getInt(3),set.getString(4),set.getTimestamp(5),set.getString(6),set.getString(7),set.getString(8),set.getBoolean(9),set.getString(10));
				listaConjunta.add(descarga);
				cont++;
				if(cont==10){
					break;
				}
			}
			conn.close();
		} catch (Exception e) {
			if(conn!=null){
				try {
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		Collections.sort(listaConjunta,new Comparator<Inicio>(){
			public int compare(Inicio i1,Inicio i2){
				return (i2.getFecha().compareTo(i1.getFecha()));
				
			}
		});
		
		return listaConjunta;
	}
}
