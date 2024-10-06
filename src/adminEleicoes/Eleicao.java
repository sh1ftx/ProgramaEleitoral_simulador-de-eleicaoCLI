package adminEleicoes;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import resultado.ContagemVotos;

public class Eleicao {
    private boolean ativa;
    private String cargoAtual;
    private LocalTime horarioTermino;
    private ContagemVotos resultado;
    
    public Eleicao(int limiteVotos) {
        this.ativa = false;
        this.resultado = new ContagemVotos(limiteVotos);
    }

    public void iniciarEleicao() {    	
        this.ativa = true;        
        System.out.println("Eleição ativada!");
    }

    public void finalizarEleicao() {    	
        this.ativa = false;
        System.out.println("Eleição finalizada!");
    }

    public void definirHorarioTermino(String horario) {     	
    	try {    	
        this.horarioTermino = LocalTime.parse(horario, DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println("Horário de término definido para " + horario );
        
    	} catch (DateTimeParseException e) {
            System.out.println("horário inválido!! Insira um horário no formato HH:mm.");
        }
    }
    
    public boolean todosVotaram() {
    	if (resultado.limiteVotosBatido()) {
    		this.ativa = false;
    		return true;
    	}return false;
    }

    public boolean isAtiva() {
        return ativa && (horarioTermino == null || LocalTime.now().isBefore(horarioTermino));
    }


    public String getCargoAtual() {
        return cargoAtual;
    }
    
    public void  setCargoAtual(String cargo) {
    	this.cargoAtual = cargo;
    }
    
    public ContagemVotos getResultado() {
        return resultado;
    }

}
