package resultado;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import usuarios.Candidato;
import utilitarios.Lista;

public class ResultadoProporcional {
    private Lista listaCandidatos;

// ============================== CALCULA AS VAGAS QUE O PARTIDO TEM DIREITO ==============================================
    
    public ResultadoProporcional(Lista listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    public Map<String, Integer> calcularVagasProporcionais(String cargo, int totalVagas) {
        Map<Integer, Candidato> listaCandidato = listaCandidatos.getListaCandidato();
        Map<String, Integer> votosPartido = new HashMap<>();
        int totalVotos = 0;

        for (Candidato candidato : listaCandidato.values()) {
            if (candidato.getCargo().equals(cargo)) {
                votosPartido.put(candidato.getPartido(), votosPartido.getOrDefault(candidato.getPartido(), 0) + candidato.getVotos());
                totalVotos += candidato.getVotos();
            }
        }

        Map<String, Integer> vagasPartido = new HashMap<>();
        for (Map.Entry<String, Integer> entry : votosPartido.entrySet()) {
            String partido = entry.getKey();
            int votos = entry.getValue();
            int vagas = (int) Math.round(((double) votos / totalVotos) * totalVagas);
            vagasPartido.put(partido, vagas);
        }

        return vagasPartido;
    }

//=============================== ELEGE OS CANDIDATOS COM MAIS VOTOS =================    
    
    public Map<String, List<Candidato>> candidatosEleitos(Map<String, Integer> vagasPartido) {
        Map<Integer, Candidato> listaCandidato = listaCandidatos.getListaCandidato();
        Map<String, List<Candidato>> eleitosPorPartido = new HashMap<>();

        for (Map.Entry<String, Integer> entry : vagasPartido.entrySet()) {
            String partido = entry.getKey();
            int vagas = entry.getValue();

            List<Candidato> candidatosDoPartido = new ArrayList<>();
            for (Candidato candidato : listaCandidato.values()) {
                if (candidato.getPartido().equals(partido)) {
                    candidatosDoPartido.add(candidato);
                }
            }

            candidatosDoPartido.sort(Comparator.comparingInt(Candidato::getVotos).reversed());

            List<Candidato> eleitos = new ArrayList<>();
            for (int i = 0; i < vagas && i < candidatosDoPartido.size(); i++) {
                eleitos.add(candidatosDoPartido.get(i));
            }

            if (!eleitos.isEmpty()) {
                eleitosPorPartido.put(partido, eleitos);
            }
        }

        return eleitosPorPartido;
    }
    
//=================================== EXIBE OS ELEITOS ===================================

    public void exibirVencedores(String cargo, int totalVagas) {
        Map<String, Integer> vagasPorPartido = calcularVagasProporcionais(cargo, totalVagas);
        Map<String, List<Candidato>> eleitos = candidatosEleitos(vagasPorPartido);

        boolean candidatosEncontrados = false;

        for (Map.Entry<String, List<Candidato>> entry : eleitos.entrySet()) {
            String partido = entry.getKey();
            List<Candidato> candidatosEleitos = entry.getValue();

            if (!candidatosEleitos.isEmpty()) { 
                if (!candidatosEncontrados) { 
                    System.out.println("\nCandidatos eleitos para o cargo de " + cargo + "\n");
                    candidatosEncontrados = true;
                }
                System.out.println("Partido: " + partido);
                for (Candidato eleito : candidatosEleitos) {
                    System.out.println(" - " + eleito.getNome() + " (" + eleito.getVotos() + " votos)");
                }
            }
        }
    }

}
