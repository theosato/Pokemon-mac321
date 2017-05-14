package controladorMapa;

import controladorBatalha.Eventos;
import controladorBatalha.Treinador;

public abstract class EventosMapa extends Eventos{
	abstract public void acao(Treinador player);
	abstract public String descricao(Treinador player);
}
