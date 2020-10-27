package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		try {
			String filnavnStr = mappe + filnavn;
			File fil = new File(filnavnStr);
			PrintWriter skriver = new PrintWriter(fil);
			skriver.print(samling.toString());
			skriver.close();
			return true;
		} catch (FileNotFoundException e){
			return false;
		}
	}
}
