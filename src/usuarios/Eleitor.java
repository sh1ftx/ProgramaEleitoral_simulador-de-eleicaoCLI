package usuarios;

public class Eleitor {
    private String nome;
    private int idade;
    private Integer cpf; 
    private boolean jaVotou = false;

    public Eleitor(String nome, int idade, Integer cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf; 
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public Integer getCpf() {
        return this.cpf;
    }

    public boolean getJaVotou() {
        return this.jaVotou;
    }

    public void setJaVotou() {
        this.jaVotou = true;
    }
}
