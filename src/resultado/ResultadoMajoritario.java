package resultado;

import java.util.Map;
import usuarios.Candidato;
import utilitarios.Lista;

public class ResultadoMajoritario {
    private Lista listaCandidatos; 

    public ResultadoMajoritario(Lista listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    public Candidato calcularVencedorMajoritario(String tipoCargo) {
        Map<Integer, Candidato> listaCandidato = listaCandidatos.getListaCandidato();
        Candidato vencedor = null;
        int maxVotos = 0;

        for (Candidato candidato : listaCandidato.values()) {
            if (candidato.getCargo().equals(tipoCargo)) { 
                if (candidato.getVotos() > maxVotos) {
                    maxVotos = candidato.getVotos();
                    vencedor = candidato;
                }
            }
        }
        return vencedor;
    }

    public void exibirVencedor(String cargo) {
        Candidato vencedor = calcularVencedorMajoritario(cargo);
        if (vencedor != null && vencedor.getVotos() > 0) {
            System.out.println("\nO vencedor do cargo de " + cargo + " é: " + vencedor.getNome() + " com " + vencedor.getVotos() + " votos.\n");
        }
    }
}
