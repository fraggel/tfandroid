package es.tfandroid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

import es.tfandroid.beans.Download;
import es.tfandroid.beans.Marca;
import es.tfandroid.beans.Modelo;
import es.tfandroid.beans.News;
import es.tfandroid.utils.Constantes;


public class adminDAO {
	
	public boolean crearNoticia(String titulo,String descripcion,String urlImagen,String idioma,boolean visible,boolean altaForo){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {

			if(altaForo){
				int topic_id=-1;
				int post_id=-1;
				InitialContext initialContext = new InitialContext();
				Context ctx=(Context)initialContext.lookup("java:comp/env");
				DataSource ds= (DataSource)(ctx.lookup(Constantes.jndiForo));
	            conn = ds.getConnection();
	            CallableStatement calstm=conn.prepareCall("select max(topic_id)+1 from phpbb_topics");
	            ResultSet set=calstm.executeQuery();
				while(set.next()){
					topic_id=set.getInt(1);
				}
				set.close();
				calstm.close();
	            initialContext = new InitialContext();
				ctx=(Context)initialContext.lookup("java:comp/env");
				ds= (DataSource)(ctx.lookup(Constantes.jndiForo));
	            conn = ds.getConnection();
	            calstm=conn.prepareCall("select max(post_id)+1 from phpbb_posts");
	            set=calstm.executeQuery();
				while(set.next()){
					post_id=set.getInt(1);
				}
				set.close();
				calstm.close();
	            
				initialContext = new InitialContext();
				ctx=(Context)initialContext.lookup("java:comp/env");
				ds= (DataSource)(ctx.lookup(Constantes.jndiForo));
	            conn = ds.getConnection();
	            calstm=conn.prepareCall("INSERT INTO phpbb_topics(topic_id, forum_id, icon_id, topic_attachment, topic_reported, "
	            		+ "topic_title, topic_poster, topic_time, topic_time_limit, topic_views, topic_status, topic_type, "
	            		+ "topic_first_post_id, topic_first_poster_name, topic_first_poster_colour, topic_last_post_id, "
	            		+ "topic_last_poster_id, topic_last_poster_name, topic_last_poster_colour, topic_last_post_subject, "
	            		+ "topic_last_post_time, topic_last_view_time, topic_moved_id, topic_bumped, topic_bumper, poll_title, "
	            		+ "poll_start, poll_length, poll_max_options, poll_last_vote, poll_vote_change, topic_visibility, topic_delete_time, "
	            		+ "topic_delete_reason, topic_delete_user, topic_posts_approved, topic_posts_unapproved, topic_posts_softdeleted, "
	            		+ "topic_solved) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            calstm.setInt(1, topic_id);
	            calstm.setInt(2, 14);
	            calstm.setInt(3, 0);
	            calstm.setInt(4, 0);
	            calstm.setInt(5, 0);
	            calstm.setString(6, titulo);
	            calstm.setInt(7, 60);
	            //TODO
	            calstm.setLong(8, 1441874752);
	            calstm.setInt(9, 0);
	            calstm.setInt(10, 1);
	            calstm.setInt(11, 0);
	            calstm.setInt(12, 0);
	            calstm.setInt(13, post_id);
	            calstm.setString(14, "TFAndroid");
	            calstm.setString(15, "00AA00");
	            calstm.setInt(16, post_id);
	            calstm.setInt(17, 60);
	            calstm.setString(18, "TFAndroid");
	            calstm.setString(19, "00AA00");
	            calstm.setString(20, titulo);
	            //TODO
	            calstm.setLong(21, 1441874752);
	            calstm.setLong(22, 1441874752);
	            calstm.setInt(23, 0);
	            calstm.setInt(24, 0);
	            calstm.setInt(25, 0);
	            calstm.setString(26,"");
	            calstm.setInt(27, 0);
	            calstm.setInt(28, 0);
	            calstm.setInt(29, 1);
	            calstm.setInt(30, 0);
	            calstm.setInt(31, 0);
	            calstm.setInt(32, 1);
	            calstm.setInt(33, 0);
	            calstm.setString(34,"");
	            calstm.setInt(35, 0);
	            calstm.setInt(36, 1);
	            calstm.setInt(37, 0);
	            calstm.setInt(38, 0);
	            calstm.setInt(39, 0);
	            calstm.executeUpdate();
	            set.close();
				calstm.close();
	            initialContext = new InitialContext();
				ctx=(Context)initialContext.lookup("java:comp/env");
				ds= (DataSource)(ctx.lookup(Constantes.jndiForo));
	            conn = ds.getConnection();
	            calstm=conn.prepareCall("INSERT INTO phpbb_posts (post_id, topic_id, forum_id, poster_id, icon_id, poster_ip, "
	            		+ "post_time, post_reported, enable_bbcode, enable_smilies, enable_magic_url, enable_sig, post_username, "
	            		+ "post_subject, post_text, post_checksum, post_attachment, bbcode_bitfield, bbcode_uid, post_postcount, "
	            		+ "post_edit_time, post_edit_reason, post_edit_user, post_edit_count, post_edit_locked, post_visibility, "
	            		+ "post_delete_time, post_delete_reason, post_delete_user) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            calstm.setInt(1, post_id);
	            calstm.setInt(2, topic_id);
	            calstm.setInt(3, 14);
	            calstm.setInt(4, 60);
	            calstm.setInt(5, 0);
	            calstm.setString(6, "37.12.182.177");
	            //TODO
	            calstm.setLong(7, 1441874752);
	            calstm.setInt(8, 0);
	            calstm.setInt(9, 1);
	            calstm.setInt(10, 1);
	            calstm.setInt(11, 1);
	            calstm.setInt(12, 1);
	            calstm.setString(13, "");
	            calstm.setString(14, titulo);
	            calstm.setString(15, descripcion);
	            calstm.setString(16, "");
	            calstm.setInt(17, 0);
	            calstm.setString(18, "");
	            calstm.setString(19, "3nola3vw");
	            calstm.setInt(20, 1);
	            calstm.setInt(21, 0);
	            calstm.setString(22, "");
	            calstm.setInt(23, 0);
	            calstm.setInt(24, 0);
	            calstm.setInt(25, 0);
	            calstm.setInt(26, 1);
	            calstm.setInt(27, 0);
	            calstm.setString(28, "");
	            calstm.setInt(29, 0);
	            calstm.executeUpdate();
	            set.close();
				calstm.close();
				
	            initialContext = new InitialContext();
				ctx=(Context)initialContext.lookup("java:comp/env");
				ds= (DataSource)(ctx.lookup(Constantes.jndi));
	            conn = ds.getConnection();
	            calstm=conn.prepareCall("insert into noticias(titulo,descripcion,urlimagen,idioma,visible,noticiaForo,urlForo) values(?,?,?,?,?,?,?)");
				calstm.setString(1, titulo);
				calstm.setString(2, descripcion);
				calstm.setString(3, urlImagen);
				calstm.setString(4, idioma);
				calstm.setBoolean(5, visible);
				calstm.setBoolean(6, altaForo);
				calstm.setString(7, "http://foro.tfandroid.es/viewtopic.php?f=14&t="+topic_id+"");
				calstm.executeUpdate();
				calstm.close();
				
			}else{
				Context initialContext = new InitialContext();
				Context ctx=(Context)initialContext.lookup("java:comp/env");
				DataSource ds= (DataSource)(ctx.lookup(Constantes.jndi));
	            conn = ds.getConnection();
	            CallableStatement calstm=conn.prepareCall("insert into noticias(titulo,descripcion,urlimagen,idioma,visible,noticiaForo,urlForo) values(?,?,?,?,?,?,?)");
				calstm.setString(1, titulo);
				calstm.setString(2, descripcion);
				calstm.setString(3, urlImagen);
				calstm.setString(4, idioma);
				calstm.setBoolean(5, visible);
				calstm.setBoolean(6, altaForo);
				calstm.setString(7, "");
				calstm.executeUpdate();
				calstm.close();
				
				//TODO
				//Refrescar el foro para que se vea
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
		return true;
	}
	public boolean modificarNoticia(int idnoticia,String titulo,String descripcion,String urlImagen,String idioma,boolean visible,boolean altaForo,String fecha){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup(Constantes.jndi));
            conn = ds.getConnection();
            CallableStatement calstm=conn.prepareCall("update noticias set titulo=?,descripcion=?,urlimagen=?,idioma=?,visible=?,fecha=?,noticiaForo=? where idnoticia=? and idioma=?");
			calstm.setString(1, titulo);
			calstm.setString(2, descripcion);
			calstm.setString(3, urlImagen);
			calstm.setString(4, idioma);
			calstm.setBoolean(5, visible);
			calstm.setTimestamp(6, Timestamp.valueOf(fecha));
			calstm.setBoolean(7, altaForo);
			calstm.setInt(8, idnoticia);
			calstm.setString(9, idioma);
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
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
	public boolean crearDescarga(int idmarca,int idmodelo,String titulo, String intro, String changelog, String faq, String install, String screenshots1, String screenshots2, String mega, String gdrive, String credits, String urlimagen, String urlimagenphone,String idioma, boolean visible,String info,String features,String marcaModelo){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			int topic_id=-1;
			int post_id=-1;
			int forum_id=-1;
			int iddownload=-1;
			InitialContext initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup(Constantes.jndiForo));
            conn = ds.getConnection();
            CallableStatement calstm=conn.prepareCall("select max(topic_id)+1 from phpbb_topics");
            ResultSet set=calstm.executeQuery();
			while(set.next()){
				topic_id=set.getInt(1);
			}
			set.close();
			calstm.close();
			
            initialContext = new InitialContext();
			ctx=(Context)initialContext.lookup("java:comp/env");
			ds= (DataSource)(ctx.lookup(Constantes.jndiForo));
            conn = ds.getConnection();
            calstm=conn.prepareCall("select max(post_id)+1 from phpbb_posts");
            set=calstm.executeQuery();
			while(set.next()){
				post_id=set.getInt(1);
			}
			set.close();
			calstm.close();
			initialContext = new InitialContext();
			ctx=(Context)initialContext.lookup("java:comp/env");
			ds= (DataSource)(ctx.lookup(Constantes.jndi));
            conn = ds.getConnection();
            calstm=conn.prepareCall("select forum_id from modelo where idmarca=? and idmodelo=?");
            calstm.setInt(1, idmarca);
            calstm.setInt(2, idmodelo);
            set=calstm.executeQuery();
			while(set.next()){
				forum_id=set.getInt(1);
			}
			set.close();
			calstm.close();
			
			initialContext = new InitialContext();
			ctx=(Context)initialContext.lookup("java:comp/env");
			ds= (DataSource)(ctx.lookup(Constantes.jndiForo));
            conn = ds.getConnection();
            calstm=conn.prepareCall("INSERT INTO phpbb_topics(topic_id, forum_id, icon_id, topic_attachment, topic_reported, "
            		+ "topic_title, topic_poster, topic_time, topic_time_limit, topic_views, topic_status, topic_type, "
            		+ "topic_first_post_id, topic_first_poster_name, topic_first_poster_colour, topic_last_post_id, "
            		+ "topic_last_poster_id, topic_last_poster_name, topic_last_poster_colour, topic_last_post_subject, "
            		+ "topic_last_post_time, topic_last_view_time, topic_moved_id, topic_bumped, topic_bumper, poll_title, "
            		+ "poll_start, poll_length, poll_max_options, poll_last_vote, poll_vote_change, topic_visibility, topic_delete_time, "
            		+ "topic_delete_reason, topic_delete_user, topic_posts_approved, topic_posts_unapproved, topic_posts_softdeleted, "
            		+ "topic_solved) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            calstm.setInt(1, topic_id);
            calstm.setInt(2, forum_id);
            calstm.setInt(3, 0);
            calstm.setInt(4, 0);
            calstm.setInt(5, 0);
            calstm.setString(6, titulo);
            calstm.setInt(7, 60);
            //TODO
            calstm.setLong(8, 1441874752);
            calstm.setInt(9, 0);
            calstm.setInt(10, 1);
            calstm.setInt(11, 0);
            calstm.setInt(12, 0);
            calstm.setInt(13, post_id);
            calstm.setString(14, "TFAndroid");
            calstm.setString(15, "00AA00");
            calstm.setInt(16, post_id);
            calstm.setInt(17, 60);
            calstm.setString(18, "TFAndroid");
            calstm.setString(19, "00AA00");
            calstm.setString(20, titulo);
            //TODO
            calstm.setLong(21, 1441874752);
            calstm.setLong(22, 1441874752);
            calstm.setInt(23, 0);
            calstm.setInt(24, 0);
            calstm.setInt(25, 0);
            calstm.setString(26,"");
            calstm.setInt(27, 0);
            calstm.setInt(28, 0);
            calstm.setInt(29, 1);
            calstm.setInt(30, 0);
            calstm.setInt(31, 0);
            calstm.setInt(32, 1);
            calstm.setInt(33, 0);
            calstm.setString(34,"");
            calstm.setInt(35, 0);
            calstm.setInt(36, 1);
            calstm.setInt(37, 0);
            calstm.setInt(38, 0);
            calstm.setInt(39, 0);
            calstm.executeUpdate();
            set.close();
			calstm.close();
			
			initialContext = new InitialContext();
			ctx=(Context)initialContext.lookup("java:comp/env");
			ds= (DataSource)(ctx.lookup(Constantes.jndi));
            conn = ds.getConnection();
            calstm=conn.prepareCall("insert into downloads(idmarca,idmodelo,titulo,intro,changelog,faq,install,screenshots1,screenshots2,mega,gdrive,credits,urlimagen,urlimagenphone,idioma,visible,info,features,marcaModelo,forum_id,topic_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			calstm.setInt(1, idmarca);
			calstm.setInt(2, idmodelo);
			calstm.setString(3, titulo);
			calstm.setString(4, intro);
			calstm.setString(5, changelog);
			calstm.setString(6, faq);
			calstm.setString(7, install);
			calstm.setString(8, screenshots1);
			calstm.setString(9, screenshots2);
			calstm.setString(10, mega);
			calstm.setString(11, gdrive);
			calstm.setString(12, credits);
			calstm.setString(13, urlimagen);
			calstm.setString(14, urlimagenphone);
			calstm.setString(15, idioma);
			calstm.setBoolean(16, visible);
			calstm.setString(17, info);
			calstm.setString(18, features);
			calstm.setString(19, marcaModelo);
			calstm.setInt(20, forum_id);
			calstm.setInt(21, topic_id);
			calstm.executeUpdate();
			calstm.close();
			
			initialContext = new InitialContext();
			ctx=(Context)initialContext.lookup("java:comp/env");
			ds= (DataSource)(ctx.lookup(Constantes.jndi));
            conn = ds.getConnection();
            calstm=conn.prepareCall("select iddownload from downloads where idmarca=? and idmodelo=? and titulo=? and intro=? and changelog=? and faq=? and install=? and screenshots1=? and screenshots2=? and mega=? and gdrive=? and credits=? and urlimagen=? and urlimagenphone=? and idioma=? and visible=? and info=? and features=? and marcaModelo=? and forum_id=? and topic_id=? ");
			calstm.setInt(1, idmarca);
			calstm.setInt(2, idmodelo);
			calstm.setString(3, titulo);
			calstm.setString(4, intro);
			calstm.setString(5, changelog);
			calstm.setString(6, faq);
			calstm.setString(7, install);
			calstm.setString(8, screenshots1);
			calstm.setString(9, screenshots2);
			calstm.setString(10, mega);
			calstm.setString(11, gdrive);
			calstm.setString(12, credits);
			calstm.setString(13, urlimagen);
			calstm.setString(14, urlimagenphone);
			calstm.setString(15, idioma);
			calstm.setBoolean(16, visible);
			calstm.setString(17, info);
			calstm.setString(18, features);
			calstm.setString(19, marcaModelo);
			calstm.setInt(20, forum_id);
			calstm.setInt(21, topic_id);
			set=calstm.executeQuery();
				while(set.next()){
					iddownload=set.getInt(1);
				}
				set.close();
				calstm.close();
			
            initialContext = new InitialContext();
			ctx=(Context)initialContext.lookup("java:comp/env");
			ds= (DataSource)(ctx.lookup(Constantes.jndiForo));
            conn = ds.getConnection();
            calstm=conn.prepareCall("INSERT INTO phpbb_posts (post_id, topic_id, forum_id, poster_id, icon_id, poster_ip, "
            		+ "post_time, post_reported, enable_bbcode, enable_smilies, enable_magic_url, enable_sig, post_username, "
            		+ "post_subject, post_text, post_checksum, post_attachment, bbcode_bitfield, bbcode_uid, post_postcount, "
            		+ "post_edit_time, post_edit_reason, post_edit_user, post_edit_count, post_edit_locked, post_visibility, "
            		+ "post_delete_time, post_delete_reason, post_delete_user) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            calstm.setInt(1, post_id);
            calstm.setInt(2, topic_id);
            calstm.setInt(3, forum_id);
            calstm.setInt(4, 60);
            calstm.setInt(5, 0);
            calstm.setString(6, "37.12.182.177");
            //TODO
            calstm.setLong(7, 1441874752);
            calstm.setInt(8, 0);
            calstm.setInt(9, 1);
            calstm.setInt(10, 1);
            calstm.setInt(11, 1);
            calstm.setInt(12, 1);
            calstm.setString(13, "");
            calstm.setString(14, titulo);
            ResourceBundle RB = ResourceBundle.getBundle("texts", new Locale("es"));
            ResourceBundle RB2 = ResourceBundle.getBundle("texts", new Locale("en"));
            String descripcion="";
            descripcion="[img:3nola3vw]"+((urlimagen.replaceAll("&", "&amp;")).replaceAll(".", "&#46;")).replaceAll(":", "&#58;")+"[/img:3nola3vw]\n[b:3nola3vw]ROM: [/b:3nola3vw] [url:3nola3vw]http&#58;//www&#46;tfandroid&#46;es/ControlServlet?action=4&amp;detalle="+idmarca+"&amp;subDetalle="+idmodelo+"&amp;downloadId="+iddownload+"[/url:3nola3vw]\n"
            		+ "[b:3nola3vw]SPFLASHTOOL TUTORIAL:[/b:3nola3vw] http&#58;//foro&#46;tfandroid&#46;es/viewtopic&#46;php?f=19&amp;t=4&p=16&amp;sid=91ea24f188bb255c6205610d8ce521fe#p16"
            		+ "\n"+RB.getString("forum.support")+"\n"+RB2.getString("forum.support");

            calstm.setString(15, descripcion);
            calstm.setString(16, "");
            calstm.setInt(17, 0);
            calstm.setString(18, "");
            calstm.setString(19, "3nola3vw");
            calstm.setInt(20, 1);
            calstm.setInt(21, 0);
            calstm.setString(22, "");
            calstm.setInt(23, 0);
            calstm.setInt(24, 0);
            calstm.setInt(25, 0);
            calstm.setInt(26, 1);
            calstm.setInt(27, 0);
            calstm.setString(28, "");
            calstm.setInt(29, 0);
            calstm.executeUpdate();
            set.close();
			calstm.close();
			
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
	public boolean modificarDescarga(int iddownload,int idmarca,int idmodelo,String titulo, String intro, String changelog, String faq, String install, String screenshots1, String screenshots2, String mega, String gdrive, String credits, String urlimagen, String urlimagenphone,String idioma, boolean visible,Timestamp fecha,String info,String features,String marcaModelo,String forum_id,String topic_id) {
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
            CallableStatement calstm=conn.prepareCall("update downloads set titulo= ?,intro=?,changelog=?,faq=?,install=?,screenshots1=?,screenshots2=?,mega=?,gdrive=?,credits=?,urlimagen=?,urlimagenphone=?,idioma=?,visible=?,fecha=?,info=?,features=?,marcaModelo=?,forum_id=?,topic_id=? where idmarca=? and idmodelo=? and idioma=? and iddownload=?");
			calstm.setString(1, titulo);
			calstm.setString(2, intro);
			calstm.setString(3, changelog);
			calstm.setString(4, faq);
			calstm.setString(5, install);
			calstm.setString(6, screenshots1);
			calstm.setString(7, screenshots2);
			calstm.setString(8, mega);
			calstm.setString(9, gdrive);
			calstm.setString(10, credits);
			calstm.setString(11, urlimagen);
			calstm.setString(12, urlimagenphone);
			calstm.setString(13, idioma);
			calstm.setBoolean(14, visible);
			calstm.setTimestamp(15, fecha);
			calstm.setString(16, info);
			calstm.setString(17, features);
			calstm.setString(18, marcaModelo);
			calstm.setString(19, forum_id);
			calstm.setString(20, topic_id);
			calstm.setInt(22, idmarca);
			calstm.setInt(23, idmodelo);
			calstm.setString(24, idioma);
			calstm.setInt(25, iddownload);
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
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
	public boolean crearModelo(int marca,String titulo, String urlimagen, String visible, String cpu,String ram,String display,String camara,String bateria,String forum_id){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
            CallableStatement calstm=conn.prepareCall("insert into modelo(idmarca,titulo,urlimagen,cpu,ram,display,camara,bateria,visible,forum_id) values(?,?,?,?,?,?,?,?,?,?)");
			calstm.setInt(1, marca);
			calstm.setString(2, titulo);
			calstm.setString(3,urlimagen);
			calstm.setString(4,cpu);
			calstm.setString(5,ram);
			calstm.setString(6,display);
			calstm.setString(7,camara);
			calstm.setString(8,bateria);
			calstm.setBoolean(9, Boolean.parseBoolean(visible));
			calstm.setString(10,forum_id);
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
            CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible,noticiaForo,urlForo from noticias where idioma= ? order by fecha desc ");
			calstm.setString(1, idioma);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			while(set.next()){
				News noticia=new News(set.getInt(1),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7),set.getBoolean(8),set.getString(9));
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,intro,changelog,faq,install,screenshots1,screenshots2,mega,gdrive,credits,urlimagen,urlimagenphone,idioma,visible,info,features,marcaModelo,forum_id,topic_id from downloads order by fecha desc ");
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			while(set.next()){
				Download descarga=new Download(set.getInt(1),
						set.getInt(2),
						set.getInt(3),
						set.getTimestamp(4),
						set.getString(5),
						set.getString(6),
						set.getString(7),
						set.getString(8),
						set.getString(9),
						set.getString(10),
						set.getString(11),
						set.getString(12),
						set.getString(13),
						set.getString(14),
						set.getString(15),
						set.getString(16),
						set.getString(17),
						set.getBoolean(18),
						set.getString(19),
						set.getString(20),
						set.getString(21),
						set.getString(22),
						set.getString(23));
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,intro,changelog,faq,install,screenshots1,screenshots2,mega,gdrive,credits,urlimagen,urlimagenphone,idioma,visible,info,features,marcaModelo,forum_id,topic_id from downloads where idioma= ? and idmarca = ? and idmodelo= ? order by fecha desc ");
			calstm.setString(1, idioma);
			calstm.setInt(2,marca);
			calstm.setInt(3,modelo);
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			while(set.next()){
				Download descarga=new Download(set.getInt(1),
												set.getInt(2),
												set.getInt(3),
												set.getTimestamp(4),
												set.getString(5),
												set.getString(6),
												set.getString(7),
												set.getString(8),
												set.getString(9),
												set.getString(10),
												set.getString(11),
												set.getString(12),
												set.getString(13),
												set.getString(14),
												set.getString(15),
												set.getString(16),
												set.getString(17),
												set.getBoolean(18),
												set.getString(19),
												set.getString(20),
												set.getString(21),
												set.getString(22),
												set.getString(23));
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
			DataSource ds= (DataSource)(ctx.lookup(Constantes.jndi));
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
			DataSource ds= (DataSource)(ctx.lookup(Constantes.jndi));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idmarca,idmodelo,titulo,urlimagen,cpu,ram,display,camara,bateria,visible,forum_id from modelo order by idmodelo asc ");
			ResultSet set=calstm.executeQuery();
			listaModelos=new ArrayList();
			while(set.next()){
				Modelo modelo=new Modelo(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getString(9),set.getBoolean(10),set.getString(11));
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
	public boolean modificarModelo(String idmarca,String idmodelo,String titulo,String urlimagen,String cpu,String ram,String display,String camara,String bateria,String visible,String forum_id){
		ArrayList listaNoticias=null;
		Connection conn =null;
		boolean ret=true;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
            CallableStatement calstm=conn.prepareCall("update modelo set titulo= ?,urlimagen=?,cpu=?,ram=?,display=?,camara=?,bateria=?,visible=?,forum_id=? where idmarca=? and idmodelo=?");
			calstm.setString(1, titulo);
			calstm.setString(2, urlimagen);
			calstm.setString(3, cpu);
			calstm.setString(4, ram);
			calstm.setString(5, display);
			calstm.setString(6,camara);
			calstm.setString(7,bateria);
			calstm.setBoolean(8, Boolean.parseBoolean(visible));
			calstm.setString(9,forum_id);	
			calstm.setInt(10, Integer.parseInt(idmarca));
			calstm.setInt(11, Integer.parseInt(idmodelo));
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
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
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
	public ArrayList consultaModelo(int idmarca,int idmodelo){
		ArrayList listaModelos=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup(Constantes.jndi));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idmodelo,idmarca,titulo,urlimagen,cpu,ram,display,camara,bateria,visible,forum_id from modelo where idmarca = ? and idmodelo=? order by idmodelo asc ");
			calstm.setInt(1, idmarca);
			calstm.setInt(2, idmodelo);
			ResultSet set=calstm.executeQuery();
			listaModelos=new ArrayList();
			while(set.next()){
				Modelo modelo=new Modelo(set.getInt(1),set.getInt(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(8),set.getString(9),set.getBoolean(10),set.getString(11));
				listaModelos.add(modelo);
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
	public ArrayList consultaMarca(int idmarca){
		ArrayList listaMarcas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
			DataSource ds= (DataSource)(ctx.lookup(Constantes.jndi));
            conn = ds.getConnection();
			CallableStatement calstm=conn.prepareCall("select idmarca,titulo,urlimagen,descripcion,visible from marca where idmarca=? order by idmarca asc ");
			calstm.setInt(1,idmarca);
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
	public ArrayList consultaDescarga(int marca,int modelo,int iddownload){
		ArrayList listaDescargas=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
            CallableStatement calstm=conn.prepareCall("select iddownload,idmarca,idmodelo,fecha,titulo,intro,changelog,faq,install,screenshots1,screenshots2,mega,gdrive,credits,urlimagen,urlimagenphone,idioma,visible,info,features,marcaModelo,forum_id,topic_id from downloads where idmarca = ? and idmodelo= ? and iddownload=? order by fecha desc ");
			calstm.setInt(1, marca);
			calstm.setInt(2,modelo);
			calstm.setInt(3,iddownload);
			ResultSet set=calstm.executeQuery();
			listaDescargas=new ArrayList();
			while(set.next()){
				Download descarga=new Download(set.getInt(1),
												set.getInt(2),
												set.getInt(3),
												set.getTimestamp(4),
												set.getString(5),
												set.getString(6),
												set.getString(7),
												set.getString(8),
												set.getString(9),
												set.getString(10),
												set.getString(11),
												set.getString(12),
												set.getString(13),
												set.getString(14),
												set.getString(15),
												set.getString(16),
												set.getString(17),
												set.getBoolean(18),
												set.getString(19),
												set.getString(20),
												set.getString(21),
												set.getString(22),
												set.getString(23));
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
	public ArrayList consultaNoticia(int idnoticia){
		ArrayList listaNoticias=null;
		Connection conn =null;
		try {
			Context initialContext = new InitialContext();
			Context ctx=(Context)initialContext.lookup("java:comp/env");
            conn = ((DataSource)(ctx.lookup(Constantes.jndi))).getConnection();
            CallableStatement calstm=conn.prepareCall("select idnoticia,titulo,fecha,descripcion,urlimagen,idioma,visible from noticias where idnoticia=? order by fecha desc ");
			calstm.setInt(1, idnoticia);
			ResultSet set=calstm.executeQuery();
			listaNoticias=new ArrayList();
			while(set.next()){
				News noticia=new News(set.getInt(1),set.getString(2),set.getTimestamp(3),set.getString(4),set.getString(5),set.getString(6),set.getBoolean(7),set.getBoolean(8),set.getString(9));
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
}
