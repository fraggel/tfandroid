package es.tfandroid.beans;

public class Modelo {
	int idmarca;
	int idmodelo;
	String titulo;
	String urlImagen;
	String cpu;
	String ram;
	String display;
	String camara;
	String bateria;
	boolean visible;
	public Modelo(int idmarca, int idmodelo, String titulo, String urlImagen, String cpu, String ram, String display,
			String camara, String bateria, boolean visible) {
		super();
		this.idmarca = idmarca;
		this.idmodelo = idmodelo;
		this.titulo = titulo;
		this.urlImagen = urlImagen;
		this.cpu = cpu;
		this.ram = ram;
		this.display = display;
		this.camara = camara;
		this.bateria = bateria;
		this.visible = visible;
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getCamara() {
		return camara;
	}
	public void setCamara(String camara) {
		this.camara = camara;
	}
	public String getBateria() {
		return bateria;
	}
	public void setBateria(String bateria) {
		this.bateria = bateria;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	

	}
