package controlador;

public class Tipo {
	private static final String[] tipos = new String[]{
		"Normal",	"Fighting",
		"Flying",	"Poison",
		"Ground",	"Rock",
		"Bug",		"Ghost",
		"Steel",	"Fire",
		"Water",	"Grass",
		"Electric",	"Psychic",
		"Ice",		"Dragon",
		"Dark",		"Fairy"
	};
	private static final double[][] tabela = new double[][]{
		{   1,   1,   1,   1,   1, 0.5,   1,   0, 0.5,   1,   1,   1,   1,   1,   1,   1,   1,   1},
		{   2,   1, 0.5, 0.5,   1,   2, 0.5,   0,   2,   1,   1,   1,   1, 0.5,   2,   1,   2, 0.5},
		{   1,   2,   1,   1,   1, 0.5,   2,   1, 0.5,   1,   1,   2, 0.5,   1,   1,   1,   1,   1},
		{   1,   1,   1, 0.5, 0.5, 0.5,   1, 0.5,   0,   1,   1,   2,   1,   1,   1,   1,   1,   2},
		{   1,   1,   0,   2,   1,   2, 0.5,   1,   2,   2,   1, 0.5,   2,   1,   1,   1,   1,   1},
		{   1, 0.5,   2,   1, 0.5,   1,   2,   1, 0.5,   2,   1,   1,   1,   1,   2,   1,   1,   1},
		{   1, 0.5, 0.5, 0.5,   1,   1,   1, 0.5, 0.5, 0.5,   1,   2,   1,   2,   1,   1,   2, 0.5},
		{   0,   1,   1,   1,   1,   1,   1,   2,   1,   1,   1,   1,   1,   2,   1,   1, 0.5,   1},
		{   1,   1,   1,   1,   1,   2,   1,   1, 0.5, 0.5, 0.5,   1, 0.5,   1,   2,   1,   1,   2},
		{   1,   1,   1,   1,   1, 0.5,   2,   1,   2, 0.5, 0.5,   2,   1,   1,   2, 0.5,   1,   1},
		{   1,   1,   1,   1,   2,   2,   1,   1,   1,   2, 0.5, 0.5,   1,   1,   1, 0.5,   1,   1},
		{   1,   1, 0.5, 0.5,   2,   2, 0.5,   1, 0.5, 0.5,   2, 0.5,   1,   1,   1, 0.5,   1,   1},
		{   1,   1,   2,   1,   0,   1,   1,   1,   1,   1,   2, 0.5, 0.5,   1,   1, 0.5,   1,   1},
		{   1,   2,   1,   2,   1,   1,   1,   1, 0.5,   1,   1,   1,   1, 0.5,   1,   1,   0,   1},
		{   1,   1,   2,   1,   2,   1,   1,   1, 0.5, 0.5, 0.5,   2,   1,   1, 0.5,   2,   1,   1},
		{   1,   1,   1,   1,   1,   1,   1,   1, 0.5,   1,   1,   1,   1,   1,   1,   2,   1,   0},
		{   1, 0.5,   1,   1,   1,   1,   1,   2,   1,   1,   1,   1,   1,   2,   1,   1, 0.5, 0.5},
		{   1,   2,   1, 0.5,   1,   1,   1,   1, 0.5, 0.5,   1,   1,   1,   1,   1,   2,   2,   1}
	};
	
	public static double modificador(String tipoAtaque, String tipoPokemon1, String tipoPokemon2){
		if (tipoPokemon1.equalsIgnoreCase(tipoPokemon2)){
			return comparaTipo(tipoAtaque,tipoPokemon1);
		}
		return comparaTipo(tipoAtaque, tipoPokemon1) * comparaTipo(tipoAtaque, tipoPokemon2);
	}
	
	private static double comparaTipo(String ataque, String defesa){
		int Nataque = encontarTipo(ataque);
		int Ndefesa = encontarTipo(defesa);
		return tabela[Nataque][Ndefesa];
		
	}
	
	private static int encontarTipo(String tipo){
		for (int i = 0; i < tipos.length; i++){
			if (tipo.equalsIgnoreCase(tipos[i])){
				return i;
			}
		}
		return tipos.length-1;
	}
}