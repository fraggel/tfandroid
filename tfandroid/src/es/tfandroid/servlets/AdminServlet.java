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
	    if(session.getAttribute("requestHelper")!=null){
	    	reqHelper=(RequestHelper)session.getAttribute("requestHelper");
    		if(reqHelper==null){
    			reqHelper=new RequestHelper();
    		}

		}else{
			reqHelper=new RequestHelper();
			session=request.getSession(true);
		}
	    reqHelper.tratarRequest(request);
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
						
						if(reqHelper.getSubaction()!=-1 && reqHelper.getSubaction()==1){
							if(request.getParameter("crear")!=null){
								aDao.crearMarca(request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("descripcion"),request.getParameter("visible"));
							}else if(request.getParameter("modificar")!=null){
								aDao.modificarMarca(request.getParameter("idmarca"),request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("descripcion"),request.getParameter("visible"));
							}else if(request.getParameter("borrar")!=null){
								aDao.borrarMarca(request.getParameter("idmarca"));
							}
							
						}
						reqHelper.setListaMarcas(aDao.consultaMarcas());
						reqHelper.setJsp("admin/adminMarcas.jsp");
						break;
					case 1:
						
						if(request.getParameter("crear")!=null){
							aDao.crearModelo(Integer.parseInt(request.getParameter("marca")),request.getParameter("nombre"),request.getParameter("urlimagen"),request.getParameter("visible"),request.getParameter("descripcion"));
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarModelo(request.getParameter("idmarca"),request.getParameter("idmodelo"),request.getParameter("titulo"),request.getParameter("urlimagen"),request.getParameter("descripcion"),request.getParameter("visible"));
						}else if(request.getParameter("borrar")!=null){
							aDao.borrarModelo(request.getParameter("idmarca"),request.getParameter("idmodelo"));
						}
						reqHelper.setListaMarcas(aDao.consultaMarcas());
						reqHelper.setListaModelos(aDao.consultaModelos());
						reqHelper.setJsp("admin/adminModelos.jsp");
						break;
					case 2:
						if(request.getParameter("crear")!=null){
							aDao.crearNoticia(request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")));
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarNoticia(Integer.parseInt(request.getParameter("idnoticia")),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")));
						}else if(request.getParameter("borrar")!=null){
							aDao.borrarNoticia(request.getParameter("idnoticia"),request.getParameter("idioma"));
						}
						
						reqHelper.setListaNews(aDao.consultaNoticias(reqHelper.getLang()));
						reqHelper.setJsp("admin/adminNoticias.jsp");
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
						if(request.getParameter("crear")!=null){
							aDao.crearDescarga(Integer.parseInt(request.getParameter("idmarca")),Integer.parseInt(request.getParameter("idmodelo")),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),Boolean.parseBoolean(request.getParameter("visible")));
						}else if(request.getParameter("modificar")!=null){
							aDao.modificarDescarga(request.getParameter("idmarca"),request.getParameter("idmodelo"),request.getParameter("titulo"),request.getParameter("descripcion"),request.getParameter("urlimagen"),request.getParameter("idioma"),request.getParameter("visible"),request.getParameter("iddownload"));
						}else if(request.getParameter("borrar")!=null){
							aDao.borrarDescarga(request.getParameter("idmarca"),request.getParameter("idmodelo"),request.getParameter("iddownload"),request.getParameter("idioma"));
						}
						reqHelper.setListaMarcas(aDao.consultaMarcas());
						reqHelper.setListaModelos(aDao.consultaModelos());
						reqHelper.setListaDescargas(aDao.consultaDescargas());
						reqHelper.setJsp("admin/adminDownloads.jsp");
						break;
					default:
						break;
					}
					
			    	}
			    	
					session.setAttribute("requestHelper",reqHelper);
					RequestDispatcher rqDis=request.getRequestDispatcher(reqHelper.getJsp());
					rqDis.forward(request, response);
				}catch(Exception e){
				}
						
			}
}
