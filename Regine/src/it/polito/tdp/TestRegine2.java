package it.polito.tdp;

import java.util.List;

public class TestRegine2 {
	
	public static void main(String args[]) {
		
		RisolviRegine2 r = new RisolviRegine2();
		
//		r.trovaRegine(4);
		int n = 8;
		List<Integer> soluzione = r.trovaRegine(n);
		System.out.println(soluzione.size()/n);
		System.out.println(soluzione);
	}

}
