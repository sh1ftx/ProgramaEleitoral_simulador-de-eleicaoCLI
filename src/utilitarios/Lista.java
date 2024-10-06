package utilitarios;


import java.util.HashMap;
import java.util.Map;
import usuarios.Candidato;
import usuarios.Eleitor;

public class Lista {

    private Map<Integer, Eleitor> listaEleitor = new HashMap<>();
    private Map<Integer, Candidato> listaCandidato = new HashMap<>();

    public void exibirCandidatosPorCargo(String cargo) {
        if (listaCandidato.isEmpty()) {
            System.out.println("Nenhum candidato cadastrado");
            return;
        }

        boolean candidatoEncontrado = false;

        for (Candidato candidato : listaCandidato.values()) {
            if (candidato.getCargo().equalsIgnoreCase(cargo)) {
                System.out.println("CANDIDATO: " + candidato.getNome() +  
                    " PARTIDO: " + candidato.getPartido() +  
                    " NUMERO: " + candidato.getNumero());
                candidatoEncontrado = true;
            }
        }

        if (!candidatoEncontrado) {
            System.out.println("Nenhum candidato encontrado para o cargo " + cargo);
        }
    }

    
    public void exibirCandidatosPorPartido(String partido) {
    	
    	System.out.println("\n============== " + partido.toUpperCase() + " ==============\n");
	
        for (Candidato candidato : listaCandidato.values()) {
            if (candidato.getPartido().equalsIgnoreCase(partido)) {
                System.out.println("CARGO: " + candidato.getCargo() +  
                    "  NOME: " + candidato.getNome() +  
                    "  NUMERO: " + candidato.getNumero() +
                    "  VOTOS RECEBIDOS: " + candidato.getVotos());
            }
        }
	
    }


    public void exibirListaEleitor() {
        if (listaEleitor.isEmpty()) {        	
            System.out.println("Nenhum eleitor cadastrado");
            return;
        }

        for (Eleitor eleitor : listaEleitor.values()) {        	
            System.out.println("NOME: " + eleitor.getNome() +
                    " IDADE: " + eleitor.getIdade() +
                    " JA VOTOU: " + (eleitor.getJaVotou() ? "Sim" : "Não"));
        }
    }

    public Map<Integer, Eleitor> getListaEleitor() {
        return listaEleitor;
    }
    
    public Map<Integer, Candidato> getListaCandidato() {
        return listaCandidato;
    }
    
    public Eleitor buscarEleitorPorCPF(int cpf) {
        return listaEleitor.get(cpf);
    }
    
    public Candidato buscarCandidatoPorNumero(int numero) {
        return listaCandidato.get(numero);
    }
}
