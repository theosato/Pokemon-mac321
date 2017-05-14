package controladorBatalha;

public class ControladorBatalha {
	protected SetDeEventos Sa = new SetDeEventos();
	protected SetDeEventos Sb = new SetDeEventos();
	
	public void inserirEvento(SetDeEventos S, EventosBatalha c) { 
		S.inserir(c); 
	}
	
	public void run(Treinador a, EventosBatalha Ea, Treinador b, EventosBatalha Eb) {
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
