package Biblioteca;
public class Musica {
    
    private String titulo;
    private String estilo;
    private int anoGravacao;
    private Interprete interprete;
    
    public Musica(String titulo, String estilo, int anoGravacao, Interprete interprete) {
        this.titulo = titulo;
        this.estilo = estilo;
        this.anoGravacao = anoGravacao;
        this.interprete = interprete;
    }

    public Interprete getInterprete() {
		return interprete;
	}

	public void setInterprete(Interprete interprete) {
		this.interprete = interprete;
	}

	public int getAnoGravacao() {
        return anoGravacao;
    }

    public void setAnoGravacao(int anoGravacao) {
        this.anoGravacao = anoGravacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }


}

