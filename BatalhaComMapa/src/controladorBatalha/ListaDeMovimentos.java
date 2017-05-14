package controladorBatalha;

public class ListaDeMovimentos {
	private Ataque[] Lista = new Ataque[48];
	
	public ListaDeMovimentos (){
		
		Lista[0] = new Ataque(3, "Razor Leaf", 20, "Grass");
		Lista[1] = new Ataque(3, "Vine Whip", 18, "Grass");
		Lista[2] = new Ataque(1, "Solar Beam", 40, "Grass");
		Lista[3] = new Ataque(2, "Take Down", 30, "Normal");
		Lista[4] = new Ataque(2, "Air Slash", 25, "Flying");
		Lista[5] = new Ataque(2, "Flamethrower", 30, "Fire");
		Lista[6] = new Ataque(1, "Fire Blitz", 40, "Fire");
		Lista[7] = new Ataque(3, "Slash", 20, "Normal");
		Lista[8] = new Ataque(1, "Hydro Pump", 38, "Water");
		Lista[9] = new Ataque(2, "Surf", 30, "Water");
		Lista[10] = new Ataque(1, "Skull Bash", 42, "Normal");
		Lista[11] = new Ataque(2, "Ice Beam", 30, "Ice");
		Lista[12] = new Ataque(3, "Rock Throw", 21, "Rock");
		Lista[13] = new Ataque(2, "Earthquake", 33, "Ground");
		Lista[14] = new Ataque(2, "Rock Slide", 25, "Rock");
		Lista[15] = new Ataque(2, "Bulldoze", 20, "Ground");
		Lista[16] = new Ataque(1, "Zap Cannon", 40, "Eletric");
		Lista[17] = new Ataque(3, "Magnet Bomb", 20, "Steel");
		Lista[18] = new Ataque(2, "Spark", 22, "Eletric");
		Lista[19] = new Ataque(3, "Thunder Shock", 20, "Eletric");
		Lista[20] = new Ataque(2, "Thunderbolt", 30, "Eletric");
		Lista[21] = new Ataque(1, "Giga Impact", 50, "Normal");
		Lista[22] = new Ataque(2, "Volt Switch", 22, "Eletric");
		Lista[23] = new Ataque(1, "Thunder", 35, "Eletric");
		Lista[24] = new Ataque(1, "Overheat", 40, "Fire");
		Lista[25] = new Ataque(2, "Psyshock", 25, "Psychic");
		Lista[26] = new Ataque(1, "Future Sight", 40, "Psychic");
		Lista[27] = new Ataque(2, "Psychic", 30, "Psychic");
		Lista[28] = new Ataque(2, "Shadow Ball", 27, "Ghost");
		Lista[29] = new Ataque(2, "Karate Chop", 22, "Fighting");
		Lista[30] = new Ataque(2, "Dynamich Punch", 33, "Fighting");
		Lista[31] = new Ataque(2, "X-Scissor", 26, "Bug");
		Lista[32] = new Ataque(1, "Fury Cutter", 22, "Bug");
		Lista[33] = new Ataque(2, "Dragon Rush", 33, "Dragon");
		Lista[34] = new Ataque(1, "Wing Attack", 20, "Flying");
		Lista[35] = new Ataque(1, "Shadow Punch", 20, "Ghost");
		Lista[36] = new Ataque(2, "Shadow Claw", 26, "Ghost");
		Lista[37] = new Ataque(2, "Dark Pulse", 28, "Dark");
	}
	
	public Ataque pegarMov(int index){
		return Lista[index];
	}

}