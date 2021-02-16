package libreria;

import java.util.TreeMap;

public class Libro {
	
	private String titolo;
	private String autore;
	private int anno;
	private double prezzo;
	private int quantita;
	private String nomeEditore;
	private int soglia;
	private int quantitaRiordino;
	private Libreria libreria;
	
	public TreeMap<Integer, Integer> venditeSettimane = new TreeMap<>();
	
	public TreeMap<Integer, Integer> venditeMesi = new TreeMap<>();
		
	Libro (String titolo, String autore, int anno, double prezzo, String nomeEditore){
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
		this.prezzo = prezzo;
		this.nomeEditore = nomeEditore;
	}
	
	public void setLibreria(Libreria libreria) {
		this.libreria = libreria;
	}
	
    public String getTitolo(){
        return titolo;
    }
    
    public String getAutore(){
        return autore;
    }
    
    public int getAnno(){
        return anno;
    }

    public double getPrezzo(){
        return prezzo;
    }
    
    public String getEditore(){
		return this.nomeEditore;
    }

    public void setQuantita(int q){  
    	this.quantita = q;
    }
    
    public int getQuantita(){
        return quantita;	
    }
    
    public void setParametri(int soglia, int quantitaRiordino){   
    	this.soglia = soglia;
    	this.quantitaRiordino = quantitaRiordino;   	
    }

    public void registraVendita(int settimana, int mese){
    	
    	if(venditeSettimane.containsKey(settimana)) {venditeSettimane.put(settimana, venditeSettimane.get(settimana) + 1);}
    	else {venditeSettimane.put(settimana, 1);}

    	if(venditeMesi.containsKey(mese)) {venditeMesi.put(mese, venditeMesi.get(mese) + 1);}
    	else {venditeMesi.put(mese, 1);}

    	quantita = quantita - 1;
    	if(quantita == soglia) {
    		libreria.creaOrdine(this, nomeEditore, quantitaRiordino );
    	}

    }




    
}
