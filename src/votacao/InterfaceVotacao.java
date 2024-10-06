package votacao;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import adminEleicoes.Eleicao;
import usuarios.Candidato;
import usuarios.Eleitor;
import utilitarios.Lista;
import verificacoes.Verificador;

public class InterfaceVotacao {

    public static void votacao(Scanner scan, Lista listaCandidato, Eleitor eleitor, Eleicao eleicao) {
        Set<String> cargosVotados = new HashSet<>();

        if (!Verificador.eleicaoAtiva(eleicao)) {
            System.out.println("A eleição não está ativa!");
            return; 
        }

        if (!Verificador.podeVotar(eleitor)) {
            System.out.println("Você já votou!");
            return; 
        }

        for (Candidato candidato : listaCandidato.getListaCandidato().values()) {
            String cargoAtual = candidato.getCargo();

            if (!cargosVotados.contains(cargoAtual)) {
                cargosVotados.add(cargoAtual);
                eleicao.setCargoAtual(cargoAtual);

                System.out.println("\n== VOTAÇÃO PARA " + (cargoAtual.toUpperCase()) + "\n");

                Votar votar = new Votar(listaCandidato, eleicao);
                votar.votar(scan, eleitor);
            }
        }

        eleicao.getResultado().contabilizarVoto();
        eleitor.setJaVotou();

        if (!eleicao.todosVotaram()) {
            return;
        }
    }
}
