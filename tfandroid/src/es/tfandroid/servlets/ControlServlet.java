package es.tfandroid.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
	    	/*if(session.getAttribute("requestHelper")!=null){
	    		reqHelper=(RequestHelper)session.getAttribute("requestHelper");
	    		if(reqHelper==null){
	    			reqHelper=new RequestHelper();
	    		}

			}else{
				reqHelper=new RequestHelper();
			}*/
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
			tfandroidDAO tDao=new tfandroidDAO();
			reqHelper.setListaNewsCortas(tDao.consultaNoticiasCortas(reqHelper.getLang()));
			reqHelper.setListaMarcas(tDao.consultaMarcas());
			switch(reqHelper.getAction()){
			case 0:
				reqHelper.setListaInicio(tDao.consultarInicio(reqHelper.getLang()));
				reqHelper.setJsp("/index.jsp");
				break;
			case 1:

				reqHelper.setJsp("/about.jsp");
				break;
			case 2:

				for(int x =0;x<reqHelper.getListaMarcas().size();x++){
					Marca n=(Marca)reqHelper.getListaMarcas().get(x);
					if(reqHelper.getDetalle() == n.getIdmarca()){
						reqHelper.setCompanyActual(n);
						reqHelper.setJsp("company.jsp");
						break;
					}else{
						reqHelper.setJsp("companyLista.jsp");
					}
				}
				
				
				break;
			case 3:
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
					reqHelper.setJsp("news.jsp");
				}
				break;
			case 4:
				if(reqHelper.getDetalle()==-1 && reqHelper.getSubDetalle()==-1 && reqHelper.getDownloadId()==-1){
				reqHelper.setJsp("downloadsMarcas.jsp");
				}else if(reqHelper.getDetalle()!=-1 && reqHelper.getSubDetalle()==-1 && reqHelper.getDownloadId()==-1){
					reqHelper.setListaModelos(tDao.consultaModelosMarca(reqHelper.getDetalle()));
					reqHelper.setJsp("downloadsModelos.jsp");
				}else if(reqHelper.getDetalle()!=-1 && reqHelper.getSubDetalle()!=-1 && reqHelper.getDownloadId()==-1){
					reqHelper.setModeloActual(tDao.consultaModelo(reqHelper.getDetalle(),reqHelper.getSubDetalle()));
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
				reqHelper.setJsp("staff.jsp");
				break;
			case 7:
				reqHelper.setJsp("contact.jsp");
				break;
			case 8:
				
				reqHelper.setJsp("reviews.jsp");
				break;
			case 20:
				reqHelper.setListaModelos(tDao.consultaModelos());
				if(reqHelper.getTxtSearch()!=null && !reqHelper.getTxtSearch().replaceAll("%", "").equals("")){
					reqHelper.setListaDescargas(tDao.buscarEnWebDescargas(reqHelper.getTxtSearch(),reqHelper.getLang()));
					reqHelper.setListaNews(tDao.buscarEnWebNoticias(reqHelper.getTxtSearch(),reqHelper.getLang()));
					
				}
				reqHelper.setJsp("search.jsp");
				break;
			case 21:
				int error=0;
				if(request.getParameter("enviar")!=null){
					if((request.getParameter("emailTo")!=null) && (request.getParameter("email")!=null) && (request.getParameter("name")!=null) && (request.getParameter("message")!=null)){
						if((!"".equals(request.getParameter("emailTo").trim())) && (!"".equals(request.getParameter("email").trim())) && (!"".equals(request.getParameter("name").trim())) && (!"".equals(request.getParameter("message").trim()))){
						ResourceBundle RB = ResourceBundle.getBundle("texts", new Locale(reqHelper.getLang()));
						// Recipient's email ID needs to be mentioned.
						int mailTo=Integer.parseInt(request.getParameter("emailTo"));
						 String to = "";
						 String subject="";
						switch(mailTo){
							case 0:
								to="tfandroid@tfandroid.es";
								subject="Asesoramiento a Compañías";
								break;
							case 1:
								to="contacto@tfandroid.es";
								subject="Ser miembro de Betatestrs";
								break;
							case 2:
								to="web@tfandroid.es";
								subject="Errores en Web o Foro";
								break;
							default:
								break;
						}
					     
					      // Sender's email ID needs to be mentioned
					      String from = request.getParameter("email");
					      // Assuming you are sending email from localhost
					      String host = "mail.tfandroid.es";
					      // Get system properties
					      Properties properties = System.getProperties();
					      // Setup mail server
					      properties.setProperty("mail.smtp.host", host);
					      properties.setProperty("mail.user", "web@tfandroid.es");
					      properties.setProperty("mail.password", "web1234");
					      // Get the default Session object.
					      Session ses = Session.getDefaultInstance(properties);
					      try{
					         // Create a default MimeMessage object.
					         MimeMessage message = new MimeMessage(ses);
					         // Set From: header field of the header.
					         message.setFrom(new InternetAddress(from));
					         // Set To: header field of the header.
					         message.addRecipient(Message.RecipientType.TO,
					                                  new InternetAddress(to));
					         // Set Subject: header field
					         message.setSubject(subject);
					         // Now set the actual message
					         String texto="Mensaje recibido de "+request.getParameter("name")+" desde la web\n";
					         texto=texto+request.getParameter("message");
					         message.setText(texto);
					         // Send message
					         Transport.send(message);
					         error=0;
					      }catch (MessagingException mex) {
					         mex.printStackTrace();
					         error=2;
					      }
						}else{
							error=1;
						}
					}else{
						error=1;
					}
				}else{
					error=-1;
				}
				reqHelper.setJsp("contact.jsp?error="+error);
			default:
				break;
			}
			
			request.setAttribute("requestHelper",reqHelper);
			RequestDispatcher rqDis=request.getRequestDispatcher(reqHelper.getJsp());
			rqDis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			reqHelper.setJsp("error.jsp");
			response.sendRedirect(reqHelper.getJsp());
		}      
	}

}
