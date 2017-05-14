package controlador;

public class ListaDePokemons {
	private Pokemon[] Lista = new Pokemon[151];
	
	public ListaDePokemons (){
		Lista[0] = new Pokemon("Venusaur", new int[]{0,1,2,3}, 80, 82, 83, "Grass", "Poison");
		Lista[1] = new Pokemon("Charizard", new int[]{4,5,6,7}, 78, 84, 78, "Fire", "Flying");
		Lista[2] = new Pokemon("Blastoise", new int[]{8,9,10,11}, 79, 83, 100, "Water", "Water");
		Lista[3] = new Pokemon("Raichu", new int[]{20,21,22,23}, 60, 90, 55, "Eletric", "Eletric");
		Lista[4] = new Pokemon("Ninetales", new int[]{5,21,24,25}, 73, 76, 75, "Fire", "Fire");
		Lista[5] = new Pokemon("Alakazam", new int[]{25,26,27,28}, 55, 50, 45, "Psychic", "Psychic");
		Lista[6] = new Pokemon("Machamp", new int[]{29,30,3,13}, 90, 130, 80, "Fighting", "Fighting");
		Lista[7] = new Pokemon("Golem", new int[]{12,13,14,15}, 80, 110, 130, "Rock", "Ground");
		Lista[8] = new Pokemon("Magnetom", new int[]{16,17,18,19}, 50, 60, 95, "Steel", "Eletric");
		Lista[9] = new Pokemon("Scyther", new int[]{4,32,34,31}, 70, 110, 80, "Grass", "Bug");
		Lista[10] = new Pokemon("Dragonite", new int[]{33,13,11,34}, 91, 134, 95, "Dragon", "Flying");
		Lista[11] = new Pokemon("Gengar", new int[]{28,37,36,35}, 60, 65, 60, "Ghost", "Poison");
	}
	
	public Pokemon pegarPokemon(int index){
		return Lista[index].criarCopia();
	}
	
	public void imprimirInfoDosPokemons(){
		for (int i = 0; i < Lista.length; i++){
			if (Lista[i] != null){
				Lista[i].imprimirInfo();
			}
		}
	}

}
