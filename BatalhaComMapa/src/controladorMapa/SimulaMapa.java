package controladorMapa;

import java.util.Random;

import controladorBatalha.Batalha;
import controladorBatalha.SetDeEventos;
import controladorBatalha.Treinador;

public class SimulaMapa extends ControladorMapa{
	Treinador player;
	Treinador rival;
	Mapa mapa;
	
	public SimulaMapa(Treinador player, Treinador rival){
		this.player = player;
		this.rival = rival;
		inserirEvento(Sep, new Reiniciar(Sep));
		inserirEvento(Ser, new Reiniciar(Ser));
		this.mapa = new Mapa();
	}
	
	public void simular(){
		while (player.podeBatalhar() && rival.podeBatalhar()){
			run(player, rival);
			if (player.pegaPosicao() == rival.pegaPosicao() && !(mapa.eGrama(player.pegaPosicao()))){
				Batalha b = new Batalha(player, rival);
				b.batalha();
			}
		}
	}
	
	private class Direita extends EventosMapa{

		public void acao(Treinador player) {
			mapa.avancarPosicao(player);;
			if (mapa.eGrama(player.pegaPosicao())){
				Random random = new Random();
				int chancebat = random.nextInt(100);
				if (chancebat < 20){    //entrou na batalha
					int poke = random.nextInt(12);
					Treinador wild = new Treinador(null, new int[] {poke});
					Batalha b = new Batalha(player, wild);
					b.batalha();
				}
				
			}
			
		}

		public String descricao(Treinador player) {
			return player.pegaNome() + " avancou.";
		}
		
	}
	
	private class Reiniciar extends EventosMapa{
		private SetDeEventos Se;
		public Reiniciar(SetDeEventos Se){
			this.Se = Se;
		}
			

		public void acao(Treinador player) {
			inserirEvento(Se, new Direita());
			inserirEvento(Se, new Reiniciar(Se));
			
		}

		public String descricao(Treinador player) {
			if(mapa.eGrama(player.pegaPosicao())){
				System.out.println("O treinador " + player.pegaNome() + " esta andando na grama. " +
						   "Pode haver pokemons selvagens.");
			} else {
				System.out.println("O treinador " + player.pegaNome() + " esta andando no chão.");
			}
			return "";
		}
		
	}
	
	public static void main(String[] args) {
		Treinador Theo = new Treinador("Theo", new int[]{0,1,2,3});
		Treinador John = new Treinador("John", new int[]{6,7,8,9});
		SimulaMapa a = new SimulaMapa(Theo, John);
		a.simular();
	}
}
