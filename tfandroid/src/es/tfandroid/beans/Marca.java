package es.tfandroid.beans;

public class Marca {
int idmarca;
String titulo;
String urlImagen;
String descripcion;
boolean visible;

public Marca(int idmarca, String titulo,String urlImagen,String descripcion,boolean visible) {
	super();
	this.idmarca = idmarca;
	this.titulo = titulo;
	this.urlImagen=urlImagen;
	this.descripcion=descripcion;
	this.visible=visible;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public String getUrlImagen() {
	return urlImagen;
}

public void setUrlImagen(String urlImagen) {
	this.urlImagen = urlImagen;
}

public boolean isVisible() {
	return visible;
}

public void setVisible(boolean visible) {
	this.visible = visible;
}

public int getIdmarca() {
	return idmarca;
}
public void setIdmarca(int idmarca) {
	this.idmarca = idmarca;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}

}
