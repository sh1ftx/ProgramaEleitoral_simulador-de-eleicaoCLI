package verificacoes;

import adminEleicoes.Eleicao;
import usuarios.Eleitor;

public class Verificador {
	
	
	public static boolean podeVotar(Eleitor eleitor) {
	    if (eleitor.getJaVotou()) {
	        return false;
	    }	
	    return true;
	}

	public static boolean eleicaoAtiva(Eleicao eleicao) {
		 if (!eleicao.isAtiva()) {
	            return false;
	        }
		 return true;
	}
	
}
