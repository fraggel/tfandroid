package es.tfandroid.beans;

import java.sql.Timestamp;

public class Download {
int iddescarga;
int idmarca;
int idmodelo;
Timestamp fecha;
String titulo;
String intro;
String changelog;
String faq;
String install;
String screenshots1;
String screenshots2;
String mega;
String gdrive;
String credits;
String urlimagen;
String urlimagenPhone;
String idioma;
String info;
String features;
String marcaModelo;
boolean visible;
public Download(int iddescarga, int idmarca, int idmodelo, Timestamp fecha, String titulo, String intro,
		String changelog, String faq, String install, String screenshots1, String screenshots2, String mega,
		String gdrive, String credits, String urlimagen, String urlimagenPhone, String idioma, boolean visible, String info, String features,
		String marcaModelo) {
	super();
	this.iddescarga = iddescarga;
	this.idmarca = idmarca;
	this.idmodelo = idmodelo;
	this.fecha = fecha;
	this.titulo = titulo;
	this.intro = intro;
	this.changelog = changelog;
	this.faq = faq;
	this.install = install;
	this.screenshots1 = screenshots1;
	this.screenshots2 = screenshots2;
	this.mega = mega;
	this.gdrive = gdrive;
	this.credits = credits;
	this.urlimagen = urlimagen;
	this.urlimagenPhone=urlimagenPhone;
	this.idioma = idioma;
	this.info = info;
	this.features = features;
	this.marcaModelo = marcaModelo;
	this.visible = visible;
}
public String getUrlimagenPhone() {
	return urlimagenPhone;
}
public void setUrlimagenPhone(String urlimagenPhone) {
	this.urlimagenPhone = urlimagenPhone;
}
public int getIddescarga() {
	return iddescarga;
}
public void setIddescarga(int iddescarga) {
	this.iddescarga = iddescarga;
}
public int getIdmarca() {
	return idmarca;
}
public void setIdmarca(int idmarca) {
	this.idmarca = idmarca;
}
public int getIdmodelo() {
	return idmodelo;
}
public void setIdmodelo(int idmodelo) {
	this.idmodelo = idmodelo;
}
public Timestamp getFecha() {
	return fecha;
}
public void setFecha(Timestamp fecha) {
	this.fecha = fecha;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getIntro() {
	return intro;
}
public void setIntro(String intro) {
	this.intro = intro;
}
public String getChangelog() {
	return changelog;
}
public void setChangelog(String changelog) {
	this.changelog = changelog;
}
public String getFaq() {
	return faq;
}
public void setFaq(String faq) {
	this.faq = faq;
}
public String getInstall() {
	return install;
}
public void setInstall(String install) {
	this.install = install;
}
public String getScreenshots1() {
	return screenshots1;
}
public void setScreenshots1(String screenshots1) {
	this.screenshots1 = screenshots1;
}
public String getScreenshots2() {
	return screenshots2;
}
public void setScreenshots2(String screenshots2) {
	this.screenshots2 = screenshots2;
}
public String getMega() {
	return mega;
}
public void setMega(String mega) {
	this.mega = mega;
}
public String getGdrive() {
	return gdrive;
}
public void setGdrive(String gdrive) {
	this.gdrive = gdrive;
}
public String getCredits() {
	return credits;
}
public void setCredits(String credits) {
	this.credits = credits;
}
public String getUrlimagen() {
	return urlimagen;
}
public void setUrlimagen(String urlimagen) {
	this.urlimagen = urlimagen;
}
public String getIdioma() {
	return idioma;
}
public void setIdioma(String idioma) {
	this.idioma = idioma;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
public String getFeatures() {
	return features;
}
public void setFeatures(String features) {
	this.features = features;
}
public String getMarcaModelo() {
	return marcaModelo;
}
public void setMarcaModelo(String marcaModelo) {
	this.marcaModelo = marcaModelo;
}
public boolean isVisible() {
	return visible;
}
public void setVisible(boolean visible) {
	this.visible = visible;
}
public String parseCampo(String campo){
	String campoAux="<ul><li><a>";
	campoAux=campoAux+campo.replaceAll("\n", "</a></li><li><a>");
	campoAux= campoAux+"</a></li></ul>";
	campoAux=campoAux.replaceAll("<li><a></ul>", "</ul>");
	return campoAux;
}
public String parseCampoFeatures(String campo){
	String campoAux2="";
	if(campo.length()>100){
		campoAux2=campo.substring(0,100);
	}
	String campoAux="<ul><li><a>";
	campoAux=campoAux+campoAux2.replaceAll("\n", "</a></li><li><a>");
	if(campo.length()>100){
		campoAux=campoAux+"...";
	}
	campoAux= campoAux+"</a></li></ul>";
	campoAux=campoAux.replaceAll("<li><a></ul>", "</ul>");
	return campoAux;
}
public String parseCampoBR(String campo){
	String campoAux="<ul><li><a>";
	campoAux=campoAux+campo.replaceAll("#", "<br/>");
	campoAux=campoAux.replaceAll("\n", "</a></li><li><a>");
	campoAux= campoAux+"</a></li></ul>";
	campoAux=campoAux.replaceAll("<li><a></ul>", "</ul>");
	return campoAux;
}
public String parseCampoMega(String campo){
	String campoAux="";
	String campoSplit[]=campo.split("\n");
	if(campoSplit.length>1){
		for (int i = 0; i < campoSplit.length; i++) {
			String string = campoSplit[i];
			if(i%2==0){
				campoAux=campoAux+string+"<br/>";
			}else{
				campoAux=campoAux+"<a href=\""+string+"\"><img id=\"imgDescargas\" src=\"http://www.tfandroid.es/images/downloads/mega.png\" /></a><br/>";
			}
		}
	}else{
		campoAux=campoAux+"<a href=\""+campoSplit[0]+"\"><img id=\"imgDescargas\" src=\"http://www.tfandroid.es/images/downloads/mega.png\" /></a><br/>";
		
	}
	return campoAux;
}
public String parseCampoGdrive(String campo){
	String campoAux="";
	String campoSplit[]=campo.split("\n");
	if(campoSplit.length>1){
		for (int i = 0; i < campoSplit.length; i++) {
			String string = campoSplit[i];
			if(i%2==0){
				campoAux=campoAux+string+"<br/>";
			}else{
				campoAux=campoAux+"<a href=\""+string+"\"><img id=\"imgDescargas\" src=\"http://www.tfandroid.es/images/downloads/gdrive.png\" /></a><br/>";
			}
		}
	}else{
		campoAux=campoAux+"<a href=\""+campoSplit[0]+"\"><img id=\"imgDescargas\" src=\"http://www.tfandroid.es/images/downloads/gdrive.png\" /></a><br/>";
	}
	return campoAux;
}
}
