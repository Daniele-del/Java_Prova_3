package libreria;

public class Ordine {
	
	private Editore editore;
	private Libro libro;
	private int quantita;
	private int numero;
	private boolean consegnato = false;
	

	Ordine(Libro libro, Editore editore, int quantita){
		this.libro = libro;
		this.editore = editore;
		this.quantita = quantita;
    	numero = (int) (Math.random() * ( 99999 - 1 ));
	}
	
	
    public Editore getEditore(){
        return this.editore;
    }
    
    public Libro getLibro(){
        return this.libro;
    }
    
    public int getQuantita(){
        return this.quantita;
    }

    public boolean isConsegnato(){
        return consegnato;
    }
    
    public void setIsConsegnato(boolean consegnato) {
    	this.consegnato = consegnato;
    }

    public int getNumero(){
        return numero;
    }
}
