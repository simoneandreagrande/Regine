package it.polito.tdp;

import java.util.ArrayList;
import java.util.List;

public class RisolviRegine2 {
	
//	N dimensione scacchiera
	
	public List<Integer> trovaRegine(int N) {
// prepara la lista di soluzione parziale
		List<Integer> parziale = new ArrayList<Integer>();
		List<Integer> soluzione = new ArrayList<Integer>();
//		preparo i dati su cui lavorare
		cercaRegine(N, parziale, 0, soluzione);
//		System.out.println(soluzioni);
		return soluzione;
	}
	
	// posizione una regina alla 'riga'
//	compatibilmente con le regine già presenti
//	nelle righe precedenti ('parziale')
	
	int d = 0;
	private boolean cercaRegine(int N, List<Integer>parziale, int riga, List<Integer> soluzione) {
		
		if(riga==N) {/* trovato soluzione */
//			System.out.println(parziale);
			soluzione.addAll(parziale);
			return true;
		}

	
		for(int col=0; col<N; col++) {
//			possiamo anche ottimizzare per simmetria
//			if(mettere la regina nella colonna 'col' è compatibile con le regine precedenti)
//				 aggiungi la regina alla colonna 'col' nella soluzione parziale
			if(reginaCompatibile(parziale, riga, col))	{
				parziale.add(col);
				boolean trovato = cercaRegine(N, parziale, riga+1, soluzione);
				if(trovato)
					return true;
				parziale.remove(parziale.size()-1);
			}
		}
		return false;
	}

	private boolean reginaCompatibile(List<Integer>parziale, int riga, int col) {
		
		for(int rigaR = 0; rigaR<parziale.size(); rigaR++) {
			int colR = parziale.get(rigaR);
			
			if (rigaR==riga)
				return false;
			
			if(colR==col)
				return false;
			// guardo diagonali per regine, ora sono torri
		
			if(rigaR-colR == riga-col)
				return false;
			
			if(rigaR+colR == riga+col) {
				return false;
			}
		}
		return true;
	}
}