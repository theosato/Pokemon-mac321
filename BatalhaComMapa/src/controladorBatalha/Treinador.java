package controladorBatalha;

public class Treinador{
	private String nome;
	private Pokemon[] party; 
	private int pokemonAtual;
	private int posicao;
	private boolean fugiu;	
	private Item item = new Item("Pocao", 10); 
	
	public Treinador(String nome, int party[]){
		ListaDePokemons lp = new ListaDePokemons();
		this.nome = nome;
		this.posicao = 0;
		//this.item[0] = item[0];
		this.party = new Pokemon[party.length];
		for (int i = 0; i<party.length; i++){
			this.party[i] = lp.pegarPokemon(party[i]);
		}	
		this.pokemonAtual = 0;
		this.fugiu = false;
	}
	
	public void iniciaPosicao(int p){
		this.posicao = p;
	}
	
	public void avancaPosicao(){
		this.posicao++;
	}
	
	public String pegaNome(){
		return nome; 
	}
	
	public Item pegaItem(){
		return this.item;
	}
	
	public int pegaPosicao(){
		return this.posicao;
	}
	
	public void escolheFugir(){
		this.fugiu = true;
	}
	
	public Ataque escolheGolpe(){
		return this.party[this.pokemonAtual].escolheGolpe();
	}
	
	public Ataque golpeAtual(){
		return this.party[this.pokemonAtual].golpeAtual();
	}
	
	public boolean podeBatalhar(){
		boolean res = false;
		for (int i = 0; i < this.party.length; i++){
			res = res || this.party[i].podeBatalhar();
		}
		return res && !this.fugiu;
	}
	
	public Pokemon pokemonAtual(){
		return this.party[this.pokemonAtual];
	}
	
	public void trocarPokemonAtual(){
		if (!podeBatalhar()){
			return;
		}
		this.pokemonAtual++;
		if (this.pokemonAtual >= this.party.length){
			this.pokemonAtual = 0;
		}
		if (!this.party[this.pokemonAtual].podeBatalhar()){
			trocarPokemonAtual();
		}
	}
	
	public int partyRestante(){
		int i, partyresta = 0;
		for(i = 0; i < this.party.length; i++)
			if (this.party[i].podeBatalhar()){
				partyresta++;
			}
		return partyresta;
	}
	
	public void imprimirInfo(){
		if(this.pegaNome() != null){	
			System.out.println("O treinador " + this.nome + " tem os seguintes pokemons:");
			System.out.println("");
			for (int i = 0; i < this.party.length; i++)
				this.party[i].imprimirInfoCompleta();
		}
			System.out.println("======================================");
	}

}
