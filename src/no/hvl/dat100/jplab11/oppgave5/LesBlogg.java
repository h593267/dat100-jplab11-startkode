package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Integer;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		// DENNE VAR SYKT VANSKELIG!
		Blogg blogg = new Blogg();
		try {
			String filnavnStr = mappe + filnavn;
			File fil = new File(filnavnStr);
			
			FileReader file = new FileReader(fil);
			BufferedReader reader = new BufferedReader(file);
	
			String line;
			line = reader.readLine();
			
			int lengde = Integer.parseInt(line);
			
			Innlegg[] innlegglist = new Innlegg[lengde];
			blogg = new Blogg(lengde);
			int n = 0;
			
			
			while ((line = reader.readLine()) != null) {
				if (line.equals(TEKST)) {
					
					line = reader.readLine();
					int id = Integer.parseInt(line);
					
					line = reader.readLine();
					String bruker = line;
					
					line = reader.readLine();
					String dato = line;
					
					line = reader.readLine();
					int likes = Integer.parseInt(line);


					line = reader.readLine();
					String tekst = line;
					
					innlegglist[n] = new Tekst(id, bruker, dato, likes, tekst);
					n++;
					
				} else if (line.equals(BILDE)) {
					
					line = reader.readLine();
					int id = Integer.parseInt(line);
					
					line = reader.readLine();
					String bruker = line;
					
					line = reader.readLine();
					String dato = line;
					
					line = reader.readLine();
					int likes = Integer.parseInt(line);

					line = reader.readLine();
					String tekst = line;
					
					line = reader.readLine();
					String url = line;
					
					innlegglist[n] = new Bilde(id, bruker, dato, likes, tekst, url);
					n++;
				}
			} 
			
			for (int i = 0; i < lengde; i++) {
				blogg.leggTil(innlegglist[i]);
			}
			
			reader.close();
			file.close();

		} catch (FileNotFoundException e){
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		return blogg;
	} 
}
