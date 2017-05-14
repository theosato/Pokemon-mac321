package controlador;

public abstract class Eventos {
	private int prioridade; // maior a prioridade, acontece primerio
	
	public Eventos(int prioridade){
		this.prioridade = prioridade;
	}
	
	public boolean temPrioridade(Eventos a){
		return this.prioridade >= a.prioridade;
	}
	
	abstract public void acao(Treinador player, Treinador sofreu);
	
	abstract public String descricao(Treinador player);
}