package Biblioteca;

public class MusicaInternacional extends Musica {
    private String pais;
    private String idioma;

    public MusicaInternacional(String titulo, String estilo, int anoGravacao, String pais, String idioma, Interprete interprete) {
        super(titulo, estilo, anoGravacao, interprete);
        this.pais = pais;
        this.idioma = idioma;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}
