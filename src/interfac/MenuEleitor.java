package interfac;

import java.util.InputMismatchException;
import java.util.Scanner;

import adminEleicoes.Eleicao;
import usuarios.Eleitor;
import utilitarios.Lista;
import votacao.InterfaceVotacao;

public class MenuEleitor {
    private Lista lista;
    private Eleicao eleicao; 
    private Eleitor eleitor; 

    public MenuEleitor(Lista lista, Eleicao eleicao, Eleitor eleitor) { 
        this.lista = lista;
        this.eleicao = eleicao;
        this.eleitor = eleitor;
    }

    public void menuEleitor(Scanner scan) {
        int opcao;

        do {
            System.out.println("\n======= MENU =======\n");
            System.out.println(
                "[1] - Votar\n" +
                "[2] - Voltar ao login\n" +
                "[0] - Sair do programa\n"
            );

            try {
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("=========== VOTAÇÃO ===========\n");
                       
                        if (eleicao != null && eleicao.isAtiva()) {
                            InterfaceVotacao.votacao(scan, lista, eleitor, eleicao); 
                        } else {
                            System.out.println("A eleição não está ativa!");
                        }
                        break;

                    case 2:
                        Login login = new Login(lista, eleicao); 
                        login.login(scan);
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Informe apenas números!");
                scan.nextLine(); 
                opcao = -1; 
            }

        } while (opcao != 0);
    }
}
