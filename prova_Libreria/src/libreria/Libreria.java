package libreria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Libreria {

	public Map<String,Editore> editori = new TreeMap<>();
	
	public List<Libro> listaLibri = new ArrayList<>();
	
	public Map<Integer, Libro> classificaPerSettimana = new HashMap<>();
	
	public Map<Integer, Libro> classificaPerMese = new HashMap<>();
	
	public Map<Integer, Ordine> ordini = new HashMap<>();

	
    public Editore creaEditore(String nome, int tempoConsegna, String email){
    	Editore nuovoEditore = new Editore(nome,tempoConsegna,email);
    	editori.put(nome, nuovoEditore);
    	return nuovoEditore;
    }

    public Editore getEditore(String nome){
        return editori.get(nome);
    }

    @SuppressWarnings("rawtypes")
	public Collection getEditori(){
        return editori.values();
    }

    public Libro creaLibro(String titolo, String autore, int anno, double prezzo, String nomeEditore)throws EditoreInesistente {
    	Libro libro = new Libro(titolo,autore,anno,prezzo,nomeEditore);
    	if(!editori.containsKey(nomeEditore)) {throw new EditoreInesistente();}
    	else {listaLibri.add(libro);}
    	libro.setLibreria(this);
        return libro;
    }
    
    public Libro getLibro(String autore, String titolo){
    	if(titolo == null) {
    		for(Libro libro : listaLibri) {
    			if(libro.getAutore().equals(autore)) {return libro;}
    		}
    	}
    	if(autore == null) {
    		for(Libro libro : listaLibri) {
    			if(libro.getTitolo().equals(titolo)) {return libro;}
    		}
    	}
    	for(Libro libro : listaLibri) {
			if(libro.getTitolo().equals(titolo) && libro.getAutore().equals(autore)) {return libro;}
		}
    	return null;
    }
    
    @SuppressWarnings("rawtypes")
	public Collection getClassificaSettimana(final int settimana){
    	
    	for(Libro libro : listaLibri) {
    		classificaPerSettimana.put(libro.venditeSettimane.get(settimana),libro);
    	}
    	Map<Integer, Libro> ordinata = new TreeMap<>(Collections.reverseOrder());
    	ordinata.putAll(classificaPerSettimana);
 
        return ordinata.values();
    }
    
    @SuppressWarnings("rawtypes")
	public Collection getClassificaMese(final int mese){
    	
    	for(Libro libro : listaLibri) {
    		classificaPerMese.put(libro.venditeMesi.get(mese),libro);
    	}
    	Map<Integer, Libro> ordinata = new TreeMap<>(Collections.reverseOrder());
    	ordinata.putAll(classificaPerMese);
 
        return ordinata.values();

    }
    
	@SuppressWarnings("rawtypes")
	public Collection getOrdini(){
    	return ordini.values();
    }
	
	public void creaOrdine (Libro libro, String editore, int quantitaRiordino) {
		Ordine ordine = new Ordine(libro, editori.get(editore) , quantitaRiordino);
		ordini.put(ordine.getNumero(), ordine);
		
	}
	
    public void ordineRicevuto(int numOrdine){   	
    	ordini.get(numOrdine).setIsConsegnato(true);
    	ordini.get(numOrdine).getLibro().setQuantita(ordini.get(numOrdine).getLibro().getQuantita() + ordini.get(numOrdine).getQuantita());   	
    }
    
    public void leggi(String file){
    }

}
