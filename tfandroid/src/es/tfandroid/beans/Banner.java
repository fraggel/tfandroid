package es.tfandroid.beans;

public class Banner {
int idBanner=-1;
String urlImagen;
String urlDestino;

public Banner(int idBanner, String urlImagen, String urlDestino) {
    super();
    this.idBanner = idBanner;
    this.urlImagen = urlImagen;
    this.urlDestino = urlDestino;
}
public int getIdBanner() {
    return idBanner;
}
public void setIdBanner(int idBanner) {
    this.idBanner = idBanner;
}
public String getUrlImagen() {
    return urlImagen;
}
public void setUrlImagen(String urlImagen) {
    this.urlImagen = urlImagen;
}
public String getUrlDestino() {
    return urlDestino;
}
public void setUrlDestino(String urlDestino) {
    this.urlDestino = urlDestino;
}


}
