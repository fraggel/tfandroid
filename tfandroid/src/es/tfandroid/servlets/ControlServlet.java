package es.tfandroid.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.tfandroid.beans.Download;
import es.tfandroid.beans.Marca;
import es.tfandroid.beans.News;
import es.tfandroid.dao.tfandroidDAO;
import es.tfandroid.utils.RequestHelper;

/**
 * Servlet implementation class ControlServlet
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProcessRequest(request,response);
	}
	
	protected void ProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    RequestHelper reqHelper=null;
	    HttpSession session=null;
	    try {
	    	session=request.getSession(true);
	    	if(session.getAttribute("requestHelper")!=null){
	    		reqHelper=(RequestHelper)session.getAttribute("requestHelper");
	    		if(reqHelper==null){
	    			reqHelper=new RequestHelper();
	    		}

			}else{
				reqHelper=new RequestHelper();
			}
			reqHelper.tratarRequest(request);
			tfandroidDAO tDao=new tfandroidDAO();
			switch(reqHelper.getAction()){
			case 0:

				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				reqHelper.setJsp("promotions.jsp");
				break;
			case 1:

				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				reqHelper.setJsp("about.jsp");
				break;
			case 2:

				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				for(int x =0;x<reqHelper.getListaMarcas().size();x++){
					Marca n=(Marca)reqHelper.getListaMarcas().get(x);
					if(reqHelper.getSubaction() == n.getIdmarca()){
						reqHelper.setCompanyActual(n);
						break;
					}
				}
				
				reqHelper.setJsp("company.jsp");
				break;
			case 3:
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				if(reqHelper.getDetalle()!=-1){
					reqHelper.setListaNews(tDao.consultaNoticias(reqHelper.getLang()));
					for(int x =0;x<reqHelper.getListaNews().size();x++){
						News n=(News)reqHelper.getListaNews().get(x);
						if(reqHelper.getDetalle() == n.getIdnoticia() && reqHelper.getLang().equals(n.getIdioma())){
							reqHelper.setNoticiaActual(n);
							break;
						}
					}
					reqHelper.setJsp("newsDetails.jsp");
				}else{
					reqHelper.setListaNewsCortas(tDao.consultaNoticias(reqHelper.getLang()));
					reqHelper.setJsp("news.jsp");
				}
				break;
			case 4:
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				if(reqHelper.getDetalle()==-1 && reqHelper.getSubDetalle()==-1 && reqHelper.getDownloadId()==-1){
				reqHelper.setJsp("downloadsMarcas.jsp");
				}else if(reqHelper.getDetalle()!=-1 && reqHelper.getSubDetalle()==-1 && reqHelper.getDownloadId()==-1){
					reqHelper.setListaModelos(tDao.consultaModelosMarca(reqHelper.getDetalle()));
					reqHelper.setJsp("downloadsModelos.jsp");
				}else if(reqHelper.getDetalle()!=-1 && reqHelper.getSubDetalle()!=-1 && reqHelper.getDownloadId()==-1){
					reqHelper.setListaNewsCortas(tDao.consultaNoticias(reqHelper.getLang()));
					reqHelper.setListaDescargas(tDao.consultaDescargas(reqHelper.getLang(),reqHelper.getDetalle(),reqHelper.getSubDetalle()));
					reqHelper.setJsp("downloads.jsp");
				}else if(reqHelper.getDetalle()!=-1 && reqHelper.getSubDetalle()!=-1 && reqHelper.getDownloadId()!=-1){
					reqHelper.setListaDescargas(tDao.consultaDescargas(reqHelper.getLang(),reqHelper.getDetalle(),reqHelper.getSubDetalle()));
					for(int x =0;x<reqHelper.getListaDescargas().size();x++){
						Download n=(Download)reqHelper.getListaDescargas().get(x);
						if(reqHelper.getDownloadId()==n.getIddescarga() && reqHelper.getLang().equals(n.getIdioma())){
							reqHelper.setDescargaActual(n);
							break;
						}
					}
					reqHelper.setJsp("downloadsDetails.jsp");
				}
				break;
			case 5:
				reqHelper.setJsp("forum.jsp");
				break;
			case 6:
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setJsp("staff.jsp");
				break;
			case 7:
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setJsp("contact.jsp");
				break;
			case 8:
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				reqHelper.setJsp("reviews.jsp");
				break;
			case 20:
				reqHelper.setListaMarcas(tDao.consultaMarcas());
				reqHelper.setListaModelos(tDao.consultaModelos());
				reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
				if(reqHelper.getTxtSearch()!=null && !reqHelper.getTxtSearch().replaceAll("%", "").equals("")){
					reqHelper.setListaDescargas(tDao.buscarEnWebDescargas(reqHelper.getTxtSearch(),reqHelper.getLang()));
					reqHelper.setListaNews(tDao.buscarEnWebNoticias(reqHelper.getTxtSearch(),reqHelper.getLang()));
					reqHelper.setJsp("search.jsp");
				}
				break;
			default:
				break;
			}
			session.setAttribute("requestHelper",reqHelper);
			RequestDispatcher rqDis=request.getRequestDispatcher(reqHelper.getJsp());
			rqDis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
			reqHelper.setJsp("error.jsp");
			response.sendRedirect(reqHelper.getJsp());
		}      
	}

}
