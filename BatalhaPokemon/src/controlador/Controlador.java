package controlador;

class SetDeEventos {
	private Eventos[] eventos = new Eventos[1000];
	private int index = 0;
	private int prox = 0;
	
	public void inserir(Eventos e) {
		if(index >= eventos.length)
			return; 
		eventos[index++] = e;
	}
	
	public Eventos pegarProx() {
		boolean loop = false;
		int comecar = prox;
	    do {
	    	prox = (prox + 1) % eventos.length;
	    	if(comecar == prox) loop = true;
	    	if((prox == (comecar + 1) % eventos.length)&& loop)
	    		return null;
	    } while(eventos[prox] == null);
	    	return eventos[prox];
	}
	
	public void removerAtual() {
		eventos[prox] = null;
	}
}

public class Controlador {
	protected SetDeEventos Sa = new SetDeEventos();
	protected SetDeEventos Sb = new SetDeEventos();
	
	public void inserirEvento(SetDeEventos S, Eventos c) { 
		S.inserir(c); 
	}
	
	public void run(Treinador a, Eventos Ea, Treinador b, Eventos Eb) {
	    	System.out.println(Ea.descricao(a));
		    Ea.acao(a,b);
		    if (a.podeBatalhar() && b.podeBatalhar()){
		    	System.out.println(Eb.descricao(b));
		    	Eb.acao(b,a);
		    }
		    Sa.removerAtual();
		    Sb.removerAtual();
	}
}