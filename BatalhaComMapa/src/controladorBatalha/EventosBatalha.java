package controladorBatalha;

public abstract class EventosBatalha extends Eventos{
	private int prioridade; // maior a prioridade, acontece primerio
	
	public EventosBatalha(int prioridade){
		this.prioridade = prioridade;
	}
	
	public boolean temPrioridade(EventosBatalha a){
		return this.prioridade >= a.prioridade;
	}
	
	abstract public void acao(Treinador player, Treinador sofreu);
	
	abstract public String descricao(Treinador player);
}
