package usuarios;

public class Candidato {

    private String cargo;
    private String nome;
    private String partido;
    private int numero;
    private int votos;

    public Candidato(String cargo, String nome, String partido, int numero) {
    	this.cargo = cargo;
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
        this.votos = 0;
    }

    public String getCargo() {
        return cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getPartido() {
        return partido;
    }

    public int getNumero() {
        return numero;
    }

    public int getVotos() {
        return votos;
    }

    public void addVoto() {
        this.votos++;
    }
}