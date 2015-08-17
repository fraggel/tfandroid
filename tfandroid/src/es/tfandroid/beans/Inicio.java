package es.tfandroid.beans;

import java.sql.Timestamp;

public class Inicio {
	int idprincipal;
	int idsecundario;
	int idterciario;
	Timestamp fecha;
	String titulo;
	String urlimagen;
	String descripcion;
	String idioma;
	String marcaModelo;
	boolean visible;
	
	
	public Inicio(int idprincipal, int idsecundario, int idterciario, String titulo,Timestamp fecha,String descripcion,  String urlimagen,
			String idioma, boolean visible,String marcaModelo) {
		super();
		this.idprincipal = idprincipal;
		this.idsecundario = idsecundario;
		this.idterciario = idterciario;
		this.fecha = fecha;
		this.titulo = titulo;
		this.urlimagen = urlimagen;
		this.idioma = idioma;
		this.visible = visible;
		this.descripcion=descripcion;
		this.marcaModelo=marcaModelo;
	}
	
	public String getMarcaModelo() {
		return marcaModelo;
	}

	public void setMarcaModelo(String marcaModelo) {
		this.marcaModelo = marcaModelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdprincipal() {
		return idprincipal;
	}
	public void setIdprincipal(int idprincipal) {
		this.idprincipal = idprincipal;
	}
	public int getIdsecundario() {
		return idsecundario;
	}
	public void setIdsecundario(int idsecundario) {
		this.idsecundario = idsecundario;
	}
	public int getIdterciario() {
		return idterciario;
	}
	public void setIdterciario(int idterciario) {
		this.idterciario = idterciario;
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
