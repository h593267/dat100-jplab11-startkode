package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;

public class Blogg {

	Innlegg[] innleggtabell;
	int nesteledig;
	
	public Blogg() {
		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteledig; i++) {
			
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			} 
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (finnInnlegg(innlegg) != -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean ledigPlass() {
		
		if (nesteledig < innleggtabell.length) {
			return true;
		} 
		
		return false;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (finnes(innlegg)) {
			return false;
		}
		
		if (ledigPlass() ) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		
		return false;
	}
	
	public String toString() {
		String str = (nesteledig) + "\n";
		
		for (int i = 0; i < nesteledig; i++) {
			str += innleggtabell[i].toString();
		}
		
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		int lengde = innleggtabell.length * 2;
		Innlegg[] temptab = innleggtabell;
		innleggtabell = new Innlegg[lengde];
		
		for (int i = 0; i < temptab.length; i++) {
			innleggtabell[i] = temptab[i];
		}
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (innleggtabell.length >= nesteledig) { //hvis plass legger inn
			leggTil(innlegg);
		} else {
			utvid(); //hvis ikke, utvider
			leggTilUtvid(innlegg); //kaller på seg selv
		}
		
		return true; //denne metoden returnerer alltid true?
		
	}
	
	public boolean slett(Innlegg innlegg) { //tror man kan bruke finnes(), men klarte ikke
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].getId() == innlegg.getId()) {
				innleggtabell[i] = null;
				nesteledig = i; //dette ødelegger leggTil(), og overskriver alle kommende innlegg, hvis man fjerner et innlegg i midten av innleggtabell
				return true; //hele konseptet med nesteledig kollapser
			}
		}
		return false;
		
	}
	
	public int[] search(String keyword) {
		
		int[] tab = new int[nesteledig]; //lengde irrelevant, så lenge den er stor nok?
		int j = 0;
		String tekst;
		for (int i = 0; i < nesteledig; i++) {
			tekst = innleggtabell[i].toString();
			if (tekst.contains(keyword)) {
				tab[j] = innleggtabell[i].getId();
				j++;
			}
		}
		return tab;

	}
}