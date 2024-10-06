package votacao;

import usuarios.Candidato;
import usuarios.Eleitor;
import java.util.Scanner;

public class Confirmacao {
    
    public static void confirmarVoto(Scanner scan, Candidato candidato, Votar voto, Eleitor eleitor) {
        System.out.println("Votar em " + candidato.getNome() + " do " + candidato.getPartido() + "\n");
        System.out.println("[C] - Confirmar voto\n[R] - Corrigir");
        String escolha = scan.nextLine();

        if (escolha.equalsIgnoreCase("c")) {
            System.out.println("Voto confirmado!");
        }
        else if (escolha.equalsIgnoreCase("r")) {
        	
            voto.votar(scan, eleitor);
        }
        else {
            System.out.println("Escolha inválida!");
        }
    }
}
