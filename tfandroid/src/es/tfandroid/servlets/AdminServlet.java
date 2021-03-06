package es.tfandroid.servlets;

import java.io.IOException;
import java.sql.Timestamp;
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
			if("admin".equals(request.getParameter("user")) && "caligula.2015".equals(request.getParameter("pass"))){				
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

							if(request.getParameter("crear")!=null){
								aDao.crearMarca(request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("descripcion"),request.getParameter("visible"));
								reqHelper.setJsp("admin/adminMarcas.jsp");
								reqHelper.setListaMarcas(aDao.consultaMarcas());
							}else if(request.getParameter("modificar")!=null){
								aDao.modificarMarca(request.getParameter("idmarca"),request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("descripcion"),request.getParameter("visible"));
								reqHelper.setListaMarcas(aDao.consultaMarca(Integer.parseInt(request.getParameter("idmarca"))));
								reqHelper.setJsp("admin/adminMarcasDetalle.jsp");
								reqHelper.setListaMarcas(aDao.consultaMarcas());
							}else if(request.getParameter("borrar")!=null){
								aDao.borrarMarca(request.getParameter("idmarca"));
								reqHelper.setJsp("admin/adminMarcas.jsp");
								reqHelper.setListaMarcas(aDao.consultaMarcas());
							}else if(request.getParameter("modificarMain")!=null){
								reqHelper.setListaMarcas(aDao.consultaMarca(Integer.parseInt(request.getParameter("idmarca"))));
								reqHelper.setJsp("admin/adminMarcasDetalle.jsp");
							}else{
								reqHelper.setJsp("admin/adminMarcas.jsp");
		                        reqHelper.setListaMarcas(aDao.consultaMarcas());
							}
						
						break;
					case 1:
						reqHelper.setListaMarcas(aDao.consultaMarcas());
						reqHelper.setListaModelos(aDao.consultaModelos());
						if(request.getParameter("crear")!=null){
							aDao.crearModelo(Integer.parseInt(request.getParameter("marca")),request.getParameter("nombre"),request.getParameter("urlimagen"),request.getParameter("visible"),request.getParameter("tfcpu"), request.getParameter("tfram"), request.getParameter("tflcd"), request.getParameter("tfcam"), request.getParameter("tfbat"), request.getParameter("forum_id"));
							reqHelper.setJsp("admin/adminModelos.jsp");
							reqHelper.setListaMarcas(aDao.consultaMarcas());
	                        reqHelper.setListaModelos(aDao.consultaModelos());
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarModelo(request.getParameter("idmarca"),request.getParameter("idmodelo"),request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("tfcpu"), request.getParameter("tfram"), request.getParameter("tflcd"), request.getParameter("tfcam"), request.getParameter("tfbat"),request.getParameter("visible"), request.getParameter("forum_id"));
							reqHelper.setListaModelos(aDao.consultaModelo(Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo"))));
							reqHelper.setJsp("admin/adminModelosDetalle.jsp");
						}else if(request.getParameter("borrar")!=null){
							aDao.borrarModelo(request.getParameter("idmarca"),request.getParameter("idmodelo"));
							reqHelper.setJsp("admin/adminModelos.jsp");
							reqHelper.setListaMarcas(aDao.consultaMarcas());
	                        reqHelper.setListaModelos(aDao.consultaModelos());
						}else if(request.getParameter("modificarMain")!=null){
							reqHelper.setListaModelos(aDao.consultaModelo(Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo"))));
							reqHelper.setJsp("admin/adminModelosDetalle.jsp");
							reqHelper.setListaMarcas(aDao.consultaMarcas());
	                        reqHelper.setListaModelos(aDao.consultaModelos());
						}else{
							reqHelper.setJsp("admin/adminModelos.jsp");
							reqHelper.setListaMarcas(aDao.consultaMarcas());
	                        reqHelper.setListaModelos(aDao.consultaModelos());
						}
						break;
					case 2:
						reqHelper.setListaNews(aDao.consultaNoticias(reqHelper.getLang()));
						if(request.getParameter("crear")!=null){
							aDao.crearNoticia(request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")),Boolean.parseBoolean(request.getParameter("altaForo")));
							reqHelper.setJsp("admin/adminNoticias.jsp");
							reqHelper.setListaNews(aDao.consultaNoticias(reqHelper.getLang()));
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarNoticia(Integer.parseInt(request.getParameter("idnoticia")),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")),Boolean.parseBoolean(request.getParameter("altaForo")),request.getParameter("fecha"));
							reqHelper.setListaNews(aDao.consultaNoticia(Integer.parseInt(request.getParameter("idnoticia"))));
							reqHelper.setJsp("admin/adminNoticiasDetalle.jsp");
						}else if(request.getParameter("borrar")!=null){
							aDao.borrarNoticia(request.getParameter("idnoticia"),request.getParameter("idioma"));
							reqHelper.setJsp("admin/adminNoticias.jsp");
							reqHelper.setListaNews(aDao.consultaNoticias(reqHelper.getLang()));
						}else if(request.getParameter("modificarMain")!=null){
							reqHelper.setListaNews(aDao.consultaNoticia(Integer.parseInt(request.getParameter("idnoticia"))));
							reqHelper.setJsp("admin/adminNoticiasDetalle.jsp");
							reqHelper.setListaNews(aDao.consultaNoticias(reqHelper.getLang()));
						}else if(request.getParameter("cambiaIdioma")!=null){
							reqHelper.setJsp("admin/adminNoticias.jsp");
							reqHelper.setListaNews(aDao.consultaNoticias(reqHelper.getLang()));
						}else{
							reqHelper.setJsp("admin/adminNoticias.jsp");
							reqHelper.setListaNews(aDao.consultaNoticias(reqHelper.getLang()));
						}
						
						
						break;
					case 3:
						if(request.getParameter("crear")!=null){
							//aDao.crearBanner(request.getParameter("idbanner"),request.getParameter("urlimagen"),request.getParameter("urldestino"));
						}else if(request.getParameter("modificar")!=null){
							//aDao.modificarBanner(Integer.parseInt(request.getParameter("idbanner")),request.getParameter("urlimagen"),request.getParameter("urldestino"));
						}else if(request.getParameter("borrar")!=null){
							//aDao.borrarBanner(Integer.parseInt(request.getParameter("idbanner")));
						}
						reqHelper.setListaBanners(aDao.consultaBanners());
						reqHelper.setJsp("admin/adminBanners.jsp");
						break;
					case 4:
						reqHelper.setListaMarcas(aDao.consultaMarcas());
						reqHelper.setListaModelos(aDao.consultaModelos());
						if(request.getParameter("crear")!=null){
							aDao.crearDescarga(Integer.parseInt(request.getParameter("idmarca")),
									Integer.parseInt(request.getParameter("idmodelo")),
									request.getParameter("titulo"),
									request.getParameter("intro"),
									request.getParameter("changelog"),
									request.getParameter("faq"),
									request.getParameter("install"),
									request.getParameter("screenshots1"),
									request.getParameter("screenshots2"),
									request.getParameter("mega"),
									request.getParameter("gdrive"),
									request.getParameter("credits"),
									request.getParameter("urlimagen"),
									request.getParameter("urlimagenphone"),
									request.getParameter("idioma"),
									Boolean.parseBoolean(request.getParameter("visible")),
									request.getParameter("info"),
									request.getParameter("features"),
									request.getParameter("marcaModelo"));
							reqHelper.setJsp("admin/adminDownloads.jsp");
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarDescarga(Integer.parseInt(request.getParameter("iddownload")),
									Integer.parseInt(request.getParameter("idmarca")),
									Integer.parseInt(request.getParameter("idmodelo")),
									request.getParameter("titulo"),
									request.getParameter("intro"),
									request.getParameter("changelog"),
									request.getParameter("faq"),
									request.getParameter("install"),
									request.getParameter("screenshots1"),
									request.getParameter("screenshots2"),
									request.getParameter("mega"),
									request.getParameter("gdrive"),
									request.getParameter("credits"),
									request.getParameter("urlimagen"),
									request.getParameter("urlimagenphone"),
									request.getParameter("idioma"),
									Boolean.parseBoolean(request.getParameter("visible")),
									Timestamp.valueOf(request.getParameter("fecha")),
									request.getParameter("info"),
									request.getParameter("features"),
									request.getParameter("marcaModelo"),
									request.getParameter("forum_id"),
									request.getParameter("topic_id"));
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

				}catch(Exception e){
					reqHelper.setJsp("error.jsp");
					reqHelper.setE(e);
				}finally{
				    request.setAttribute("requestHelper",reqHelper);
                    RequestDispatcher rqDis=request.getRequestDispatcher(reqHelper.getJsp());
                    rqDis.forward(request, response);
				}
						
			}
}
