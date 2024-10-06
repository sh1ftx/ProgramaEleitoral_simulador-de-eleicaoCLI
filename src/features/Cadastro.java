package features;

import java.util.Scanner;
import usuarios.Candidato;
import usuarios.Eleitor;
import utilitarios.Lista;

public class Cadastro {
    
    public static Eleitor cadastrarEleitor(Scanner scan, Lista lista) {
    	
        System.out.println("Informe seu nome: ");
        String nome = scan.nextLine();

        System.out.println("Informe sua idade: ");
        int idade = scan.nextInt();
        scan.nextLine();

        if (idade < 16) {
        	
            System.out.println("Você ainda não tem idade suficiente!");
            return null;
        }

        System.out.println("Informe seu CPF: ");
        int cpf = scan.nextInt();

        if (lista.getListaEleitor().containsKey(cpf)) {
        	
            System.out.println("CPF ja cadastrado!");
            return null;
        }

        Eleitor eleitor = new Eleitor(nome, idade, cpf);
        lista.getListaEleitor().put(cpf, eleitor);
       
        System.out.println("Cadastro efetuado com sucesso!");
        return eleitor;
    }

    
    public static Candidato cadastrarCandidato(Scanner scan, Lista lista) {
    	
        System.out.println("Informe o cargo desejado: ");
        String cargo = scan.nextLine();

        System.out.println("Informe seu nome: ");
        String nome = scan.nextLine();

        System.out.println("Informe seu partido: ");
        String partido = scan.nextLine();

        System.out.println("Informe seu número de candidatura: ");
        int numero = scan.nextInt();
        scan.nextLine();

        if (lista.getListaCandidato().containsKey(numero)) {
        	
            System.out.println("Numero ja cadastrado!");
            return null;
        }

        Candidato candidato = new Candidato(cargo, nome, partido, numero);
        
        lista.getListaCandidato().put(numero, candidato);
        
        System.out.println("Cadastro efetuado com sucesso!");
        return candidato;
    }
    
//========== MÉTODOS APENAS PARA TESTE =================
    
    public static void adicionarCandidatosPraTeste(Lista lista) {
        
//====================================== PARTIDO PZZ
    	Candidato candidato1 = new Candidato("Presidente", "Juninho Portugal", "PZZ", 11);
    	lista.getListaCandidato().put(11, candidato1);

    	Candidato candidato4 = new Candidato("Deputado", "Reginaldo Rossi", "PZZ", 1122);
    	lista.getListaCandidato().put(1122, candidato4);

    	Candidato candidato5 = new Candidato("Deputado", "Thais Carla", "PZZ", 1133);
    	lista.getListaCandidato().put(1133, candidato5);

    	Candidato candidato9 = new Candidato("Vereador", "Ivanildo Lagatixa", "PZZ", 11222);
    	lista.getListaCandidato().put(11222, candidato9);

    	Candidato candidato12 = new Candidato("Vereador", "Jorge QuebraMola", "PZZ", 11333);
    	lista.getListaCandidato().put(11333, candidato12);

    	Candidato candidato13 = new Candidato("Vereador", "Leoncio Corolla", "PZZ", 11444);
    	lista.getListaCandidato().put(11444, candidato13);


//================================= PARTIDO PBB
    	Candidato candidato2 = new Candidato("Presidente", "Tiririca", "PBB", 22);
    	lista.getListaCandidato().put(22, candidato2);

    	Candidato candidato7 = new Candidato("Deputado", "Patati", "PBB", 2233);
    	lista.getListaCandidato().put(2233, candidato7);

    	Candidato candidato14 = new Candidato("Deputado", "Pedro Informaticas", "PBB", 2244);
    	lista.getListaCandidato().put(2244, candidato14);

    	Candidato candidato10 = new Candidato("Vereador", "Antedeguemon", "PBB", 22333);
    	lista.getListaCandidato().put(22333, candidato10);

    	Candidato candidato11 = new Candidato("Vereador", "Georgi Clunei", "PBB", 22444);
    	lista.getListaCandidato().put(22444, candidato11);

    	Candidato candidato15 = new Candidato("Vereador", "Santana", "PBB", 22555);
    	lista.getListaCandidato().put(22555, candidato15);


//================================ PARTIDO PLUA
    	Candidato candidato3 = new Candidato("Presidente", "Sebastiao Buchudo", "PLUA", 33);
    	lista.getListaCandidato().put(33, candidato3);

    	Candidato candidato6 = new Candidato("Deputado", "Fredisson", "PLUA", 3344);
    	lista.getListaCandidato().put(3344, candidato6);

    	Candidato candidato16 = new Candidato("Deputado", "Luiza Pitanga", "PLUA", 3355);
    	lista.getListaCandidato().put(3355, candidato16);

    	Candidato candidato8 = new Candidato("Vereador", "Cleo Piriz", "PLUA", 33444);
    	lista.getListaCandidato().put(33444, candidato8);

    	Candidato candidato17 = new Candidato("Vereador", "Manezinho da Ilha", "PLUA", 33555);
    	lista.getListaCandidato().put(33555, candidato17);

    	Candidato candidato18 = new Candidato("Vereador", "Grundielson", "PLUA", 33666);
    	lista.getListaCandidato().put(33666, candidato18);



    }


    public static void adicionarEleitorPraTeste(Lista lista) {
        Eleitor eleitor = new Eleitor("Teste", 20, 000);
        lista.getListaEleitor().put(000, eleitor);
        
//================== LOGIN DE ADM PROVISORIO ===================
        
        Eleitor adm = new Eleitor("Administrador", 20, 12345);
        lista.getListaEleitor().put(12345, adm);
    }
    
//===============================================================
    
}
