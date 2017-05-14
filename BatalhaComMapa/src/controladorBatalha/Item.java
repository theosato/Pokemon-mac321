package controladorBatalha;

public class Item {
	//private int id;
	private String nome;
	//private int quantidade;
	private int cura;
	
	public Item(String nome, int cura){
		//this.id = id;
		this.nome = nome;
		//this.quantidade = quantidade;
		this.cura = cura;
	}
	
	public void imprimeInfo(){
		System.out.println("O item " + this.nome + " cura " + this.cura + " de HP.");
	}
	
	public int pegaCura(){
		return this.cura;
	}
	
	public String pegaNome(){
		return this.nome;
	}
}

