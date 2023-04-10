package Biblioteca;

public class MusicaNacional extends Musica {
    private String estado;
    private String regional;

    public MusicaNacional(String titulo, String estilo, int anoGravacao, String estado, String regional, Interprete interprete) {
    	super(titulo, estilo, anoGravacao, interprete);
        this.estado = estado;
        this.setRegional(regional);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        if (regional.equalsIgnoreCase("N") || regional.equalsIgnoreCase("S")) {
            this.regional = regional;
        } else {
            throw new IllegalArgumentException("O valor do atributo regional deve ser 'N' ou 'S'");
        }
    }
}
