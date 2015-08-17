package es.tfandroid.beans;

import java.sql.Timestamp;

public class News {
int idnoticia;
String titulo;
String descripcion;
Timestamp fecha;
String url;
String idioma;
boolean visible;

public News(int idnoticia, String titulo, Timestamp fecha,String descripcion,
		String url,String idioma,boolean visible) {
	super();
	this.idnoticia = idnoticia;
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.fecha = fecha;
	this.url = url;
	this.idioma=idioma;
	this.visible=visible;
}

public boolean isVisible() {
	return visible;
}

public void setVisible(boolean visible) {
	this.visible = visible;
}

public String getIdioma() {
	return idioma;
}

public void setIdioma(String idioma) {
	this.idioma = idioma;
}

public int getIdnoticia() {
	return idnoticia;
}
public void setIdnoticia(int idnoticia) {
	this.idnoticia = idnoticia;
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
public Timestamp getFecha() {
	return fecha;
}
public void setFecha(Timestamp fecha) {
	this.fecha = fecha;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

}
