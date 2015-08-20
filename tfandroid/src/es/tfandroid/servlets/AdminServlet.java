package es.tfandroid.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import es.tfandroid.dao.adminDAO;
import es.tfandroid.dao.tfandroidDAO;
import es.tfandroid.utils.Constantes;
import es.tfandroid.utils.RequestHelper;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request, response);
	}
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestHelper reqHelper=null;
	    HttpSession session=null;
	    session=request.getSession(true);
	    reqHelper=new RequestHelper();
    	
		reqHelper.tratarRequest(request);
		if(session.getAttribute("language")!=null){
			if(reqHelper.getLang()==null){
				reqHelper.setLang((String)session.getAttribute("language"));
			}
    	}else{
    		reqHelper.setLang("es");
    	}
    	session.setAttribute("language", reqHelper.getLang());
		if(request.getParameter("user")!=null && request.getParameter("pass")!=null){
			if("admin".equals(request.getParameter("user")) && "tfandroid".equals(request.getParameter("pass"))){				
				session.setAttribute("admin", "1");
				reqHelper.setJsp("admin/adminMarcas.jsp");
			}else{
				reqHelper.setJsp("admin/login.jsp");
			}
		}else{
			reqHelper.setJsp("admin/login.jsp");
		}
			    try {
			    	if(session.getAttribute("admin")!=null){					
					
					adminDAO aDao=new adminDAO();
					
					switch(reqHelper.getAction()){
					case 0:
						reqHelper.setListaMarcas(aDao.consultaMarcas());
							if(request.getParameter("crear")!=null){
								aDao.crearMarca(request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("descripcion"),request.getParameter("visible"));
								reqHelper.setJsp("admin/adminMarcas.jsp");
							}else if(request.getParameter("modificar")!=null){
								aDao.modificarMarca(request.getParameter("idmarca"),request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("descripcion"),request.getParameter("visible"));
								reqHelper.setListaMarcas(aDao.consultaMarca(Integer.parseInt(request.getParameter("idmarca"))));
								reqHelper.setJsp("admin/adminMarcasDetalle.jsp");
							}else if(request.getParameter("borrar")!=null){
								aDao.borrarMarca(request.getParameter("idmarca"));
								reqHelper.setJsp("admin/adminMarcas.jsp");
							}else if(request.getParameter("modificarMain")!=null){
								reqHelper.setListaMarcas(aDao.consultaMarca(Integer.parseInt(request.getParameter("idmarca"))));
								reqHelper.setJsp("admin/adminMarcasDetalle.jsp");
							}else{
								reqHelper.setJsp("admin/adminMarcas.jsp");
							}
						
						break;
					case 1:
						reqHelper.setListaMarcas(aDao.consultaMarcas());
						reqHelper.setListaModelos(aDao.consultaModelos());
						if(request.getParameter("crear")!=null){
							String descripcion=Constantes.plantillaModelo;
							descripcion=descripcion.replace("TFCPU", request.getParameter("tfcpu"));
							descripcion=descripcion.replace("TFRAM", request.getParameter("tfram"));
							descripcion=descripcion.replace("TFLCD", request.getParameter("tflcd"));
							descripcion=descripcion.replace("TFCAM", request.getParameter("tfcam"));
							descripcion=descripcion.replace("TFBAT", request.getParameter("tfbat"));
							aDao.crearModelo(Integer.parseInt(request.getParameter("marca")),request.getParameter("nombre"),request.getParameter("urlimagen"),request.getParameter("visible"),descripcion);
							reqHelper.setJsp("admin/adminModelos.jsp");
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarModelo(request.getParameter("idmarca"),request.getParameter("idmodelo"),request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("descripcion"),request.getParameter("visible"));
							reqHelper.setListaModelos(aDao.consultaModelo(Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo"))));
							reqHelper.setJsp("admin/adminModelosDetalle.jsp");
						}else if(request.getParameter("borrar")!=null){
							aDao.borrarModelo(request.getParameter("idmarca"),request.getParameter("idmodelo"));
							reqHelper.setJsp("admin/adminModelos.jsp");
						}else if(request.getParameter("modificarMain")!=null){
							reqHelper.setListaModelos(aDao.consultaModelo(Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo"))));
							reqHelper.setJsp("admin/adminModelosDetalle.jsp");
						}else{
							reqHelper.setJsp("admin/adminModelos.jsp");
						}
						break;
					case 2:
						reqHelper.setListaNews(aDao.consultaNoticias(reqHelper.getLang()));
						if(request.getParameter("crear")!=null){
							aDao.crearNoticia(request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")));
							reqHelper.setJsp("admin/adminNoticias.jsp");
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarNoticia(Integer.parseInt(request.getParameter("idnoticia")),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")),request.getParameter("fecha"));
							reqHelper.setListaNews(aDao.consultaNoticia(Integer.parseInt(request.getParameter("idnoticia"))));
							reqHelper.setJsp("admin/adminNoticiasDetalle.jsp");
						}else if(request.getParameter("borrar")!=null){
							aDao.borrarNoticia(request.getParameter("idnoticia"),request.getParameter("idioma"));
							reqHelper.setJsp("admin/adminNoticias.jsp");
						}else if(request.getParameter("modificarMain")!=null){
							reqHelper.setListaNews(aDao.consultaNoticia(Integer.parseInt(request.getParameter("idnoticia"))));
							reqHelper.setJsp("admin/adminNoticiasDetalle.jsp");
						}else if(request.getParameter("cambiaIdioma")!=null){
							reqHelper.setJsp("admin/adminNoticias.jsp");
						}else{
							reqHelper.setJsp("admin/adminNoticias.jsp");
						}
						
						
						break;
					case 3:
						if(request.getParameter("crear")!=null){
							//aDao.crearBanner(request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")));
						}else if(request.getParameter("modificar")!=null){
							//aDao.modificarBanner(Integer.parseInt(request.getParameter("idnoticia")),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")));
						}else if(request.getParameter("borrar")!=null){
							//aDao.borrarModelo(request.getParameter("idmarca"),request.getParameter("idmodelo"));
						}
						
						reqHelper.setJsp("admin/adminBanners.jsp");
						break;
					case 4:
						reqHelper.setListaMarcas(aDao.consultaMarcas());
						reqHelper.setListaModelos(aDao.consultaModelos());
						if(request.getParameter("crear")!=null){
							aDao.crearDescarga(Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo")),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")),request.getParameter("info"),request.getParameter("features"),request.getParameter("marcaModelo"));
							reqHelper.setJsp("admin/adminDownloads.jsp");
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarDescarga(request.getParameter("idmarca"),request.getParameter("idmodelo"),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),request.getParameter("visible"),request.getParameter("iddownload"),request.getParameter("fecha"),request.getParameter("info"),request.getParameter("features"),request.getParameter("marcaModelo"));
							reqHelper.setListaDescargas(aDao.consultaDescarga(Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo")),Integer.parseInt(request.getParameter("iddownload"))));
							reqHelper.setJsp("admin/adminDownloadsDetalle.jsp");
						}else if(request.getParameter("borrar")!=null){
							aDao.borrarDescarga(request.getParameter("idmarca"),request.getParameter("idmodelo"),request.getParameter("iddownload"),request.getParameter("idioma"));
							reqHelper.setJsp("admin/adminDownloads.jsp");
						}else if(request.getParameter("modificarMain")!=null){
							reqHelper.setListaDescargas(aDao.consultaDescarga(Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo")),Integer.parseInt(request.getParameter("iddownload"))));
							reqHelper.setJsp("admin/adminDownloadsDetalle.jsp");
						}else if(request.getParameter("CambiaIdioma")!=null){
							reqHelper.setListaDescargas(aDao.consultaDescargas(reqHelper.getLang(),Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo"))));
							reqHelper.setJsp("admin/adminDownloads.jsp");
						}else{
							reqHelper.setJsp("admin/adminDownloads.jsp");
						}
						break;
					default:
						break;
					}
					
			    	}
			    	
			    	request.setAttribute("requestHelper",reqHelper);
					RequestDispatcher rqDis=request.getRequestDispatcher(reqHelper.getJsp());
					rqDis.forward(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
						
			}
}
