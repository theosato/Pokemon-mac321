package controladorMapa;

import controladorBatalha.SetDeEventos;
import controladorBatalha.Treinador;

public class ControladorMapa {
	protected SetDeEventos Sep = new SetDeEventos();
	protected SetDeEventos Ser = new SetDeEventos();
	
	public void inserirEvento(SetDeEventos Se, EventosMapa e){
		Se.inserir(e);
	}
	
	public void run(Treinador player, Treinador rival){
		EventosMapa e;
		if ((e = (EventosMapa) Sep.pegarProx()) != null){
			e.acao(player);
			System.out.println(e.descricao(player));
			Sep.removerAtual();
		}
		if ((e = (EventosMapa) Ser.pegarProx()) != null){
			e.acao(rival);
			System.out.println(e.descricao(rival));
			Ser.removerAtual();
		}
		
	}
}
