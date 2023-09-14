package it.polito.tdp.versione2;

//Classe RisolviRegine.java
public class RisolviRegine {
 private int N;
 private int[][] scacchiera;

 public RisolviRegine(int n) {
     N = n;
     scacchiera = new int[N][N];
 }

 public void stampaScacchiera() {
     for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
             System.out.print(scacchiera[i][j] + " ");
         }
         System.out.println();
     }
     System.out.println();
 }

 private boolean posizioneSicura(int riga, int colonna) {
     // Controllo orizzontale
     for (int i = 0; i < colonna; i++) {
         if (scacchiera[riga][i] == 1) {
             return false;
         }
     }

     // Controllo diagonale superiore sinistra
     for (int i = riga, j = colonna; i >= 0 && j >= 0; i--, j--) {
         if (scacchiera[i][j] == 1) {
             return false;
         }
     }

     // Controllo diagonale inferiore sinistra
     for (int i = riga, j = colonna; i < N && j >= 0; i++, j--) {
         if (scacchiera[i][j] == 1) {
             return false;
         }
     }

     return true;
 }

 private boolean risolviNRegine(int colonna) {
     if (colonna >= N) {
         // Tutte le regine sono state posizionate
         stampaScacchiera();
         return true;
     }

     boolean risultato = false;
     for (int i = 0; i < N; i++) {
         if (posizioneSicura(i, colonna)) {
             scacchiera[i][colonna] = 1;
             risultato = risolviNRegine(colonna + 1) || risultato;
             scacchiera[i][colonna] = 0; // Backtracking
         }
     }

     return risultato;
 }

 public void risolvi() {
     if (!risolviNRegine(0)) {
         System.out.println("Nessuna soluzione trovata per " + N + " regine.");
     }
 }
}


