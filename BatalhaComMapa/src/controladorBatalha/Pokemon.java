package controladorBatalha;

public class Pokemon {
	private String nome;
	private Ataque golpes[]; 
	private int maxHP;
	private int atualHP;
	private int ataque;
	private int defesa;
	private int golpeusado = 0;
	private String tipo1;
	private String tipo2;
	
	private Pokemon(String nome, int maxHP, int atk, int def, String tipo1, String tipo2){
		this.nome = nome;
		this.maxHP = maxHP;
		this.atualHP = maxHP;
		this.ataque = atk;
		this.defesa = def;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
	}
	
	public Pokemon(String nome, int golpes[], int maxHP, int atk, int def, String tipo1, String tipo2){
		this(nome, maxHP, atk, def, tipo1, tipo2);
		ListaDeMovimentos lm = new ListaDeMovimentos();
		this.golpes = new Ataque[golpes.length];
		for (int i = 0; i < golpes.length; i++){
			this.golpes[i] = lm.pegarMov(golpes[i]);
		}
	}
	
	private Pokemon(String nome, Ataque golpes[], int maxHP, int atk, int def, String tipo1, String tipo2){
		this(nome, maxHP, atk, def, tipo1, tipo2);
		this.golpes = golpes;
	}
	
	public String pegaNome(){
		return this.nome;
	}
	
	public int pegaHPAtual(){
		return this.atualHP;
	}
	
	public int pegaHPMax(){
		return this.maxHP;
	}
	
	public int pegaAtaque(){
		return this.ataque;
	}
	
	public int pegaDefesa(){
		return this.defesa;
	}
	
	public String pegaTipo1(){
		return this.tipo1;
	}
	
	public String pegaTipo2(){
		return this.tipo2;
	}
	
	public Pokemon criarCopia(){
		return new Pokemon(this.nome, this.golpes, this.maxHP, this.ataque, this.defesa, this.tipo1, this.tipo2);
	}
	
	public void imprimirInfo(){
		System.out.println("O pokemon " + this.nome + " tem " + this.atualHP + " de um total de " + this.maxHP + " de HP.");
	}
	
	public void imprimirInfoCompleta(){
		this.imprimirInfo();
		if (this.tipo1 == this.tipo2)
			System.out.println("Tipo: " + this.tipo1);
		else
			System.out.println("Tipo: " + this.tipo1 + " / " + this.tipo2);
		System.out.println("Seus ataques sao:");
		for (int i = 0; i < this.golpes.length; i++){
			this.golpes[i].imprimirInfo();
		}
		System.out.println("");
	}
	
	public Ataque escolheGolpe(){
		this.golpeusado++;
		if(this.golpeusado == this.golpes.length-1)
			this.golpeusado = 0;
		return this.golpes[this.golpeusado];
	}
	
	public Ataque golpeAtual(){
		return this.golpes[this.golpeusado];
	}
	
	public void receberDano(int dano){
		this.atualHP -= dano;
		if (this.atualHP < 0){
			this.atualHP = 0;
		}
	}
	
	public void receberCura(Item pocao){
		if (this.atualHP > 0)
			this.atualHP += pocao.pegaCura();
		if (this.atualHP > this.maxHP){
			this.atualHP = this.maxHP;
		}
	}
	
	public boolean podeBatalhar(){
		return this.atualHP > 0;
	}
}