import java.util.Scanner;
import utilitarios.Lista;
import interfac.Login;
import features.Cadastro;
import adminEleicoes.Eleicao;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lista lista = new Lista();

//================================= TESTES =================================
        
        Cadastro.adicionarEleitorPraTeste(lista);
        Cadastro.adicionarCandidatosPraTeste(lista);
        
//========================= APAGAR DA CLASE CADASTRO ========================        
 
        Eleicao eleicao = new Eleicao(10); 
        
        
        System.out.println("Para motivos de teste existe um eleitor de cpf 000\n"
        		+ "para utilizar o menu de adm utilize o cpf 12345, no qual pode votar por qualquer cpf cadastrado para agilizar testes\n"
        		+ "existem eleicoes para PRESIDENTE,VEREADOR E DEPUTADO\n"
        		+ "Por motivos de poluicao de tela, veja a lista de candidatos por meio da classe cadastro\n\n");
 
        Login login = new Login(lista, eleicao);
        login.login(scan);
        
        scan.close(); 
    }
}
