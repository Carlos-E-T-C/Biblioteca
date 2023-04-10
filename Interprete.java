package Biblioteca;
public class Interprete {
    private String nome;
    
    public Interprete(String nome) {
        this.nome = nome;
    }
    
    public Interprete() {
	}

	public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}
