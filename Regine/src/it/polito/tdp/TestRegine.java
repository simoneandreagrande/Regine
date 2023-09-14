package it.polito.tdp;

import java.util.List;

public class TestRegine {
	
	public static void main(String args[]) {
		
		RisolviRegine r = new RisolviRegine();
		
//		r.trovaRegine(4);
		
		List<List<Integer>> soluzioni = r.trovaRegine(8);
		System.out.println(soluzioni.size());
		
	}

}
