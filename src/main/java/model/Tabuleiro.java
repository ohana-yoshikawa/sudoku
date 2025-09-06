package model;

public class Tabuleiro {
    private final Bloco[] blocos;
    private final Casa[][] matriz;

    public Tabuleiro() {
        blocos = new Bloco[9];
        for (int i = 0; i < blocos.length; i++) {
            blocos[i] = new Bloco();
        }
        this.matriz = criaMatrizTabuleiro();
    }



    private Casa[][] criaMatrizTabuleiro() {
        Casa[][] matriz = new Casa[9][9];
        int blocoIndex = 0;
        for (int blocoLinha = 0; blocoLinha < 3; blocoLinha++) {
            for (int blocoColuna = 0; blocoColuna < 3; blocoColuna++) {
                Bloco bloco = blocos[blocoIndex];
                for (int i = 0; i < 3; i++) {         // linha dentro do bloco
                    for (int j = 0; j < 3; j++) {     // coluna dentro do bloco
                        int linhaMatriz = blocoLinha * 3 + i;
                        int colunaMatriz = blocoColuna * 3 + j;
                        int indexCasaNoBloco = i * 3 + j;
                        matriz[linhaMatriz][colunaMatriz] = bloco.getCasa(indexCasaNoBloco);
                    }
                }
                blocoIndex++;
            }
        }
        return matriz;
    }

    public Bloco getBlocos(int i) {
        return blocos[i];
    }

    public static int indiceCasaNoBloco(int linha, int coluna) {
        return ((linha % 3) * 3 + (coluna % 3));
    }

    public static int indiceDoBloco(int linha, int coluna) {
        return ((linha / 3 ) * 3 + (coluna / 3));
    }

    public Casa getMatriz(int i, int j) {
        return matriz[i][j];
    }


}
