package interfac;

import java.util.Scanner;

import adminEleicoes.Eleicao;
import usuarios.Eleitor;
import utilitarios.Lista;

public class Login {
    private Lista lista;  
    private Eleicao eleicao; 

    public Login(Lista lista, Eleicao eleicao) {
        this.lista = lista;
        this.eleicao = eleicao; 
    }
    
    public void login(Scanner scan) {
        System.out.println("=======LOGIN=======");
        
        Eleitor eleitor = null; 
        
        do {
            System.out.println("\nInforme seu CPF: ");
            int usuario = scan.nextInt();
            scan.nextLine();
            
            eleitor = lista.buscarEleitorPorCPF(usuario);
            
            if (eleitor != null) {
                if (eleitor.getCpf().equals(12345)) {
                    MenuAdmin menu = new MenuAdmin(lista, eleicao); 
                    menu.menuAdm(scan); 
                } else {
                    System.out.println("Bem vindo " + eleitor.getNome());
                    MenuEleitor menu = new MenuEleitor(lista, eleicao, eleitor);
                    menu.menuEleitor(scan);
                }
            } else {
                System.out.println("CPF não encontrado, Tente novamente!");
            }
        } while (eleitor == null);
    }
}
