package controlador;

public class Ataque {
	private int prioridade;
	private String nome;
	private int poder;
	private String tipo; 
	
	public Ataque(int prioridade, String nome, int poder, String tipo){
		this.prioridade = prioridade;
		this.nome = nome;
		this.poder = poder;
		this.tipo = tipo;
	}
	
	public int pegaPoder(){
		return this.poder;
	}
	
	public String pegaNome(){
		return this.nome;
	}
	
	public String pegaTipo(){
		return this.tipo;
	}
	
	public boolean temPrioridade(Ataque a){
		if (this.prioridade >= a.prioridade){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void imprimirInfo(){
		System.out.println("O ataque " + this.nome + " de tipo " + this.tipo + " tem " + this.poder + " de poder.");
	}
	
}
