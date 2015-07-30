package es.tfandroid.beans;

import java.sql.Timestamp;

public class Download {
int iddescarga;
int idmarca;
int idmodelo;
Timestamp fecha;
String titulo;
String descripcion;
String urlimagen;
String idioma;
boolean visible;



public Download(int iddescarga, int idmarca, int idmodelo, Timestamp fecha,
		String titulo, String descripcion, String urlimagen, String idioma,
		boolean visible) {
	super();
	this.iddescarga = iddescarga;
	this.idmarca = idmarca;
	this.idmodelo = idmodelo;
	this.fecha = fecha;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.urlimagen = urlimagen;
	this.idioma = idioma;
	this.visible = visible;
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
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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
public boolean isVisible() {
	return visible;
}
public void setVisible(boolean visible) {
	this.visible = visible;
}



}
