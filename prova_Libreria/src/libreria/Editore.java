package libreria;

import java.util.Comparator;

public class Editore {
	
	private String nome;
	private int tempoConsegna;
	private String email;
	
	Editore(String nome, int tempoConsegna, String email){
		this.nome = nome;
		this.tempoConsegna = tempoConsegna;
		this.email = email;
	}

    
    public String getNome(){
        return nome;
    }
    
    public int getTempoConsegna(){
        return tempoConsegna;
    }
    
    public String getEmail(){
        return email;
    }
    
    
   public static final Comparator<Editore> perNome = (n1,n2) -> n1.nome.compareTo(n2.getNome());
    
    
}
