package resultado;

public class ContagemVotos {
    private int votoBranco;
    private int votoNulo;
    private int votosValidos;
    private int votosTotais;
    private int limiteVotos;

    public ContagemVotos(int limiteVotos) {  
        this.votoBranco = 0;
        this.votoNulo = 0;
        this.votosValidos = 0;
        this.votosTotais = 0;
        this.limiteVotos = limiteVotos;
    }
    
    public void addBranco() {
        this.votoBranco++;
    }
    
    public int getBranco() {
        return votoBranco;
    }

    public void addNulo() {
        this.votoNulo++;
    }

    public int getNulo() {
        return votoNulo;
    }
    
    public void addVotoValido() {
        this.votosValidos++;
    }

    public int getVotosValidos() {
        return votosValidos;
    }

    public int getVotosTotais() {
        return votosTotais;
    }
    
    public boolean limiteVotosBatido() {
        return votosTotais >= limiteVotos;
    }
    
    public void contabilizarVoto() {
    	this.votosTotais++;
    }
}
