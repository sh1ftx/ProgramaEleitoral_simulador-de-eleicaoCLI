package votacao;

import java.util.Scanner;

import adminEleicoes.Eleicao;
import usuarios.Candidato;
import usuarios.Eleitor;
import utilitarios.Lista;



public class Votar {
    private Lista lista;
    private Eleicao eleicao;

    public Votar(Lista lista, Eleicao eleicao) { 
        this.lista = lista;
        this.eleicao = eleicao; 
    }

    public void votar(Scanner scan, Eleitor eleitor) {

        System.out.println("\n[-1] - Votar Nulo\n[-2] - Votar Branco\n");
        System.out.println("Informe o número do seu candidato: \n");

        if (scan.hasNextInt()) {        	
            int numero = scan.nextInt();
            scan.nextLine();

            if (numero == -1) {            	
                eleicao.getResultado().addNulo(); 
                System.out.println("Você votou nulo\n");
                
            } else if (numero == -2) {             	
                eleicao.getResultado().addBranco();
                System.out.println("Você votou em branco\n");
                
            } else {            	
                Candidato candidato = lista.buscarCandidatoPorNumero(numero);
                
                if (candidato != null && candidato.getCargo().equalsIgnoreCase(eleicao.getCargoAtual())) {                	
                    Confirmacao.confirmarVoto(scan, candidato, this, eleitor);
                    candidato.addVoto();
                    eleicao.getResultado().addVotoValido();
                } else {                	
                    System.out.println("Candidato não encontrado para o cargo de " + eleicao.getCargoAtual() + "!");
                }
            }
        } else {         	
            System.out.println("Informe apenas números!");
            scan.nextLine();    
        }
    }
}

