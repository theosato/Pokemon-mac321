package controladorMapa;

import controladorBatalha.Treinador;

public class Mapa {
	private char[] caminho = new char[10];
	
	public Mapa(){
		for (int i = 0; i < caminho.length-1; i++){
			if(i != caminho.length-2)
				caminho[i] = 'G';
			else
				caminho[i] = 'C';
		}
	}
	
	public char pegaEstado(int posicao){
		return this.caminho[posicao];
	}
	
	public boolean eGrama(int posicao){
		if (pegaEstado(posicao) == 'G')
			return true;
		return false;
	}
	
	public void avancarPosicao(Treinador player){
		if(player.pegaPosicao() < caminho.length-1)
			player.avancaPosicao();
	}
	
	/*public void AvancaPosicao(){
		if(posicaomapa < caminho.length-1)
			this.posicaomapa++;
	}*/
}
