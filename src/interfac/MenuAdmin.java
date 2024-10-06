package interfac;

import java.util.InputMismatchException;
import java.util.Scanner;
import adminEleicoes.Eleicao;
import usuarios.Eleitor;
import utilitarios.Lista;
import votacao.InterfaceVotacao;
import features.Cadastro;
import resultado.ContagemVotos;  
import resultado.ExibirResultados;

public class MenuAdmin {
    private Lista lista;
    private Eleicao eleicao;

    public MenuAdmin(Lista lista, Eleicao eleicao) {
        this.lista = lista;
        this.eleicao = eleicao;
    }

    public void menuAdm(Scanner scan) {
        int opcao;

        do {
            System.out.println("\n======= MENU =======\n");
            System.out.println(
                "[1] - Cadastrar um candidato\n" +
                "[2] - Cadastrar um eleitor\n" +
                "[3] - Votar\n" +
                "[4] - Iniciar eleição\n" +
                "[5] - Configurações de finalização da eleição\n" +
                "[6] - Exibir resultados\n" +
                "[7] - Voltar ao login\n" +
                "[0] - Sair do programa\n"
            );

            try {
                opcao = scan.nextInt();
                scan.nextLine();

                switch (opcao) {
                
                    case 1:
                        System.out.println("===== CADASTRO CANDIDATO ======\n");
                        Cadastro.cadastrarCandidato(scan, lista);
                        break;
                        
                    case 2:
                        System.out.println("======= CADASTRO ELEITOR ======\n");
                        Cadastro.cadastrarEleitor(scan, lista);
                        break;
                        
                    case 3:                    	
                        System.out.println("=========== VOTAÇÃO ===========\n");                    	
                        System.out.println("Informe o CPF do eleitor:");
                        int cpfEleitor = scan.nextInt();
                        Eleitor eleitor = lista.buscarEleitorPorCPF(cpfEleitor);

                        if (eleitor != null) {                        	                           	
                            InterfaceVotacao.votacao(scan, lista, eleitor, eleicao); 
                        } else {                        	
                            System.out.println("Eleitor não encontrado!");
                        }
                        break;

                    case 4:
                        eleicao.iniciarEleicao();
                        break;

                    case 5:                    	
                        System.out.println("===== CONFIG DE TERMINO =====\n");                    	
                        System.out.println("[1] - Finalizar agora\n[2] - Definir horário de término\n");
                        int opcTermino = scan.nextInt();
                        scan.nextLine();

                        switch (opcTermino) {                        
                            case 1:
                                eleicao.finalizarEleicao();
                                break;
                            case 2:
                                System.out.println("Informe o horário de término (HH:mm): ");
                                String horario = scan.nextLine();
                                eleicao.definirHorarioTermino(horario);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        break;

                    case 6:
                        ContagemVotos contagemVotos = eleicao.getResultado();
                        ExibirResultados.exibir(contagemVotos, lista); 
                        break;
                        
                    case 7:
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
