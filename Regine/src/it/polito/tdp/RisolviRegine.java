package it.polito.tdp;

import java.util.ArrayList;
import java.util.List;

public class RisolviRegine {
	
//	N dimensione scacchiera
	
	public List<List<Integer>> trovaRegine(int N) {
// prepara la lista di soluzione parziale
		List<Integer> parziale = new ArrayList<Integer>();
		List<List<Integer>> soluzioni = new ArrayList<List<Integer>>();
//		preparo i dati su cui lavorare
		cercaRegine(N, parziale, 0, soluzioni);
//		System.out.println(soluzioni);
		return soluzioni;
	}
	
	// posizione una regina alla 'riga'
//	compatibilmente con le regine già presenti
//	nelle righe precedenti ('parziale')
	
	int d = 0;
	private void cercaRegine(int N, List<Integer>parziale, int riga, List<List<Integer>> soluzioni) {
		
		if(riga==N) {/* trovato soluzione */
//			System.out.println(parziale);
			soluzioni.add(new ArrayList<Integer>(parziale));
			return;
		}

	
		for(int col=0; col<N; col++) {
//			possiamo anche ottimizzare per simmetria
//			if(mettere la regina nella colonna 'col' è compatibile con le regine precedenti)
//				 aggiungi la regina alla colonna 'col' nella soluzione parziale
			if(reginaCompatibile(parziale, riga, col))	{
				parziale.add(col);
				cercaRegine(N, parziale, riga+1, soluzioni);
				parziale.remove(parziale.size()-1);
			}
		}
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