package controlador;

//import java.util.Random;

public class Batalha extends Controlador{
	
	Treinador a;
	Treinador b;
	
	public Batalha (Treinador a, Treinador b){
		this.a = a;
		this.b = b;
		inserirEvento(Sa, new Reiniciar1());
		inserirEvento(Sb, new Reiniciar2());
		
	}
	
	public void batalha(){
		Eventos Ea;
		Eventos Eb;
		System.out.println(a.pegaNome() + " e " + b.pegaNome() + " vao se enfrentar!");
		System.out.println("");
		a.imprimirInfo();
		b.imprimirInfo();
		System.out.println("");
		System.out.println("Inicio da batalha!");
		System.out.println("");
		System.out.println(a.pegaNome() + ": " + a.pokemonAtual().pegaNome() + " eu escolho voce!");
		System.out.println("*" + a.pokemonAtual().pegaNome() + " entra no campo de batalha*");
		System.out.println("");
		System.out.println(b.pegaNome() + ": eu escolho voce, " + b.pokemonAtual().pegaNome() + "!");
		System.out.println("*" + b.pokemonAtual().pegaNome() + " entra no campo de batalha*");
		System.out.println("");
		while (a.podeBatalhar() && b.podeBatalhar()){
		    if ((Ea = Sa.pegarProx()) != null && (Eb = Sb.pegarProx()) != null) {
		    	if (Ea.equals(retornaOrdem(Ea, Eb))){
		    		run(a,Ea,b,Eb);
		    	}
		    	else {
		    		run(b,Eb,a,Ea);
		    	}
		    }
		}
		if (a.podeBatalhar()){
			System.out.println("O treinador " + a.pegaNome() + " ganhou!!!");
		}
		else if (b.podeBatalhar()){
			System.out.println("O treinador " + b.pegaNome() + " ganhou!!!");
		}
		else {
			System.out.println("Empate");
		}
	}
	
	public Eventos retornaOrdem (Eventos Ea, Eventos Eb){
		if (Ea.getClass().equals(Atacar.class)){//CASO SEJA ATAQUE, ELE Ã ESCOLHIDO AQUI
			a.escolheGolpe();					//USAR GOLPE ATUAL NO RESTO DO CODIGO
		}
		if (Eb.getClass().equals(Atacar.class)){
			b.escolheGolpe();
		}
		if (!(Ea.getClass().equals(Eb.getClass()))){  //classes diferentes
			if (Ea.temPrioridade(Eb)){
				return Ea;
			}
			else{
				return Eb;
			}
		}
		else if (Ea.getClass().equals(Atacar.class)){ //classes iguais e igual a atacar
			if (a.golpeAtual().temPrioridade(b.golpeAtual())){
				return Ea;
			}
			else {
				return Eb;
			}
		}
		else{										  //classes iguais e diferentes de atacar
			return Ea;
		}
	}
	
	private class Atacar extends Eventos{

		public Atacar() {
			super(1);
		}

		public String descricao(Treinador player) {
			return player.pegaNome() + ": " + player.pokemonAtual().pegaNome() + ", use " 
					+ player.pokemonAtual().golpeAtual().pegaNome() + "!";
		}

		public void acao(Treinador player, Treinador sofreu) {
			int dano = calcularDano(player, sofreu);
			System.out.println("*"+player.pokemonAtual().pegaNome() + " usa " + player.pokemonAtual().golpeAtual().pegaNome()+"*");
			sofreu.pokemonAtual().receberDano(dano);
			System.out.println("");
			if(dano > 0)
				System.out.println(sofreu.pokemonAtual().pegaNome() + " foi atingido.");
			else 
				System.out.println(player.pokemonAtual().golpeAtual().pegaNome() + " foi inefetivo contra " + sofreu.pokemonAtual().pegaNome());
			System.out.println("O pokemon " + sofreu.pokemonAtual().pegaNome() + 
					" esta com: " + sofreu.pokemonAtual().pegaHPAtual() + "/" + sofreu.pokemonAtual().pegaHPMax() + " HP.");
			System.out.println("");
			if (!(sofreu.pokemonAtual().podeBatalhar())){
				System.out.println("O pokemon "+ sofreu.pokemonAtual().pegaNome() + " não pode mais lutar");
				
				System.out.println("");
				
				System.out.println(sofreu.pegaNome() + ": " + 
						sofreu.pokemonAtual().pegaNome() + " volte para a pokebola!");
				
				System.out.println("*"+ sofreu.pokemonAtual().pegaNome() + " sai do campo de batalha*");
				
				System.out.println("");
				
				sofreu.trocarPokemonAtual();
				if (sofreu.pokemonAtual().podeBatalhar()){
					System.out.println(sofreu.pegaNome() + ": " + 
							sofreu.pokemonAtual().pegaNome() + ", eu escolho voce!");
				
					System.out.println("*"+sofreu.pokemonAtual().pegaNome() + " entra no campo de batalha*");
				
					System.out.println("");
				}
			}
		}
		
		private int calcularDano(Treinador player, Treinador sofreu){
			int i = (int) ((((((2*100/5)+2)*player.golpeAtual().pegaPoder()*(player.pokemonAtual().pegaAtaque()/sofreu.pokemonAtual().pegaDefesa()))/50)+2)*Tipo.modificador(player.golpeAtual().pegaTipo(), sofreu.pokemonAtual().pegaTipo1(), sofreu.pokemonAtual().pegaTipo2()));
			double conflitipo = Tipo.modificador(player.golpeAtual().pegaTipo(), sofreu.pokemonAtual().pegaTipo1(), sofreu.pokemonAtual().pegaTipo2());
			if (i <= 0 && conflitipo != 0){
				return 1;
			}
			else {
				return i;
			}
		}
	}
	
	private class UsarItem extends Eventos{

		public UsarItem() {
			super(2);
		}

		public String descricao(Treinador player) {
			return player.pegaNome() + " usou " + player.pegaItem().pegaNome() + ".";
		}

		public void acao(Treinador player, Treinador sofreu) {
			player.pokemonAtual().receberCura(player.pegaItem());
			if (player.pokemonAtual().pegaHPAtual() > 0){
				System.out.println(player.pokemonAtual().pegaNome() + " foi curado!");
				System.out.println(player.pokemonAtual().pegaNome()+ " esta com: " + 
						player.pokemonAtual().pegaHPAtual() + "/" + player.pokemonAtual().pegaHPMax() + " HP.");
				System.out.println("");
			}
		}
		
	}
	
	private class TrocarPokemon extends Eventos{

		public TrocarPokemon() {
			super(3);
		}

		public String descricao(Treinador player) {
			return player.pegaNome() + " vai trocar de pokemon: ";
		}

		public void acao(Treinador player, Treinador sofreu) {
			
			System.out.println(player.pegaNome() + ": " + 
					player.pokemonAtual().pegaNome() + " volte para a pokebola!");
			
			System.out.println("*"+ player.pokemonAtual().pegaNome() + " sai do campo de batalha*");
			
			System.out.println("");
			
			player.trocarPokemonAtual();
			
			System.out.println(player.pegaNome() + ": " + 
					player.pokemonAtual().pegaNome() + ", eu escolho voce!");
			
			System.out.println("*"+player.pokemonAtual().pegaNome() + " entra no campo de batalha*");
			
			System.out.println("");
		}
		
	}
	
	private class Fugir extends Eventos{

		public Fugir() {
			super(4);
		}

		public String descricao(Treinador player) {
			return player.pegaNome() + " foge da batalha.";
		}

		public void acao(Treinador player, Treinador sofreu) {
			player.escolheFugir();
		}
		
	}
	
	class Reiniciar1 extends Eventos{

		public Reiniciar1() {
			super(5);
		}

		public String descricao(Treinador player) {

			return "================ NOVO ================";
		}

		public void acao(Treinador player, Treinador sofreu) {
			double fator = 100*((double)player.pokemonAtual().pegaHPAtual()/(double)player.pokemonAtual().pegaHPMax());
			if (fator <= 10 && fator > 0 && player.partyRestante() == 1){
				inserirEvento(Sa, new Fugir());
			} else if (fator <= 20 && player.pegaNome() != null){
				inserirEvento(Sa, new UsarItem());
			} else if (fator <= 35 && player.partyRestante() > 1 && player.pegaNome() != null){
				inserirEvento(Sa, new TrocarPokemon());
			} else{
				inserirEvento(Sa, new Atacar()); 
			}
			
			/* Random gerador = new Random();
			int acaorand = gerador.nextInt(100);
			
			if (acaorand <= 62) {
				inserirEvento(Sa, new Atacar());
			} else if (acaorand <= 83) {
				inserirEvento(Sa, new TrocarPokemon());
			} else if (acaorand <= 98) {
				inserirEvento(Sa, new UsarItem());
			} else {
				inserirEvento(Sa, new Fugir());
			} */
			
			
			/*inserirEvento(Sa, new Atacar());
			inserirEvento(Sa, new TrocarPokemon());
			inserirEvento(Sa, new UsarItem());*/
			
			inserirEvento(Sa, new Reiniciar1());
		}
		
	}
	
	private class Reiniciar2 extends Eventos{

		public Reiniciar2() {
			super(5);
		}

		public String descricao(Treinador player) {
			System.out.println("=============== TURNO ================");
			return "";
		}

		public void acao(Treinador player, Treinador sofreu) {
			double fator = 100*((double)player.pokemonAtual().pegaHPAtual()/(double)player.pokemonAtual().pegaHPMax());
			if (fator <= 5 && fator > 0 && player.partyRestante() == 1 ){
				inserirEvento(Sb, new Fugir());
			} else if (fator <= 20 && player.pegaNome() != null){
				inserirEvento(Sb, new UsarItem());
			} else if (fator <= 35 && player.partyRestante() > 1 && player.pegaNome() != null){
				inserirEvento(Sb, new TrocarPokemon());
			} else{
				inserirEvento(Sb, new Atacar()); 
			}
			
			/* Random gerador = new Random();
			int acaorand = gerador.nextInt(100);
			
			if (acaorand <= 62) {
				inserirEvento(Sb, new Atacar());
			} else if (acaorand <= 83) {
				inserirEvento(Sb, new TrocarPokemon());
			} else if (acaorand <= 98) {
				inserirEvento(Sb, new UsarItem());
			} else {
				inserirEvento(Sb, new Fugir());
			} /*
			
			
			/*inserirEvento(Sb, new Atacar());
			inserirEvento(Sb, new TrocarPokemon());
			inserirEvento(Sb, new UsarItem());*/
			
			inserirEvento(Sb, new Reiniciar2());
		}
		
	}
	
	public static void main(String[] args) {
		Treinador Theo = new Treinador("Theo", new int[]{0,1,2,3});
		Treinador John = new Treinador("John", new int[]{6,7,8,9});
		Batalha b = new Batalha(Theo, John);
		b.batalha();
	}

}