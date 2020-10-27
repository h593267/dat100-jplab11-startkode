package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		
		super(id, bruker, dato, tekst);
		this.url = url;
		
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		
		super(id, bruker, dato, likes, tekst);
		this.url = url;
		
	}
	
	public String getUrl() {
		
		return url;

	}

	public void setUrl(String url) {
		
		this.url = url;
		
	}

	@Override
	public String toString() {
		String str = "BILDE" + "\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() +  "\n" + getTekst() + "\n" + url + "\n";
		return str;

	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		String str = "";
		
		str += "<h2>";
		str += getBruker();
		str += "@";
		str += getDato();
		str += " [";
		str += getLikes();
		str += "]";
		str += "</h2>";
		
		str += "\n";
		
		str += "<p>";
		str += getTekst();
		str += "</p>";
		
		str += "\n";
		
		str += "<iframe src="+ url +" height=600 width=800></iframe><hr>";
		
		str += "\n";
		return str;
				
	}
}
