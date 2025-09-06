package View;


import model.Casa;
import model.Tabuleiro;

public class TabuleiroView {
    public static final String RESET = "\u001B[0m";
    public static final String AZUL = "\u001B[34m"; // azul para valores fixos
    public static final String ROXO = "\u001B[35m"; // roxo para jogadas
    public static final String BRANCO = "\u001B[37m"; //valores vazios
    public static final String VERMELHO = "\u001B[41m"; //jogadas erradas

    public void mostra(Tabuleiro tabuleiro) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Casa casa = tabuleiro.getMatriz(i, j);
                exibeValor(casa);
                if ((j + 1) % 3 == 0 && j != 8) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.println("---------+---------+---------");
            }
        }
    }

    private void exibeValor(Casa casa) {
        if (casa.getValor() == 0) {
            System.out.print(" " + BRANCO + casa.getValor() + RESET + " ");
        } else if (casa.isErrada()) {
            System.out.print(" " + VERMELHO + casa.getValor() + RESET + " ");
        } else if (casa.isFixa()) {
            System.out.print(" " + AZUL + casa.getValor() + RESET + " ");
        } else {
            System.out.print(" " + ROXO +casa.getValor() + RESET + " ");
        }
    }


}
