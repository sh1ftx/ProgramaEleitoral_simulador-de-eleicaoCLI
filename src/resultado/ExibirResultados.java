package resultado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import utilitarios.Lista;

public class ExibirResultados {

    public static void exibir(ContagemVotos votos, Lista listaCandidatos) {
        System.out.println("=========== RESULTADOS ===========\n");

        System.out.println("Total de votos válidos: " + votos.getVotosValidos());
        System.out.println("Total de votos nulos: " + votos.getNulo());
        System.out.println("Total de votos brancos: " + votos.getBranco());
        System.out.println("Total de eleitores votantes: " + votos.getVotosTotais());

        ResultadoMajoritario majoritario = new ResultadoMajoritario(listaCandidatos);
        majoritario.exibirVencedor("Presidente");

        ResultadoProporcional proporcional = new ResultadoProporcional(listaCandidatos);
        proporcional.exibirVencedores("Deputado", 1);
        proporcional.exibirVencedores("Vereador", 2); 

//======================= ACABOU A MASSA CINZENTA PRA AUTOMATIZAR ISSO
        
        System.out.println("\n=========== CANDIDATOS POR PARTIDO ===========");
        listaCandidatos.exibirCandidatosPorPartido("pzz");
        listaCandidatos.exibirCandidatosPorPartido("plua");
        listaCandidatos.exibirCandidatosPorPartido("pbb");
        System.out.println("\n================================\n");

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Relatório feito em: " + agora.format(formatter));

        System.out.println("\n================================");
    }
}
