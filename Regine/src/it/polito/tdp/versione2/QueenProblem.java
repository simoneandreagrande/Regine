package it.polito.tdp.versione2;
public class QueenProblem {
    private static int[] queens;

    public static void solve(int N) {
        queens = new int[N];
        placeQueens(0, N);
    }

    private static void placeQueens(int row, int N) {
        if (row == N) {
            printSolution();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;
                placeQueens(row + 1, N);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - col == i - row || queens[i] - col == row - i) {
                return false;
            }
        }
        return true;
    }

    private static void printSolution() {
        int N = queens.length;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (queens[row] == col) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 4; // Change this value to the desired size of the chessboard
        solve(N);
    }
}
