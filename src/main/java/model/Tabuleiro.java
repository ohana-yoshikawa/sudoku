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

    public static final String RESET = "\u001B[0m";
    public static final String AZUL = "\u001B[34m"; // azul para valores fixos
    public static final String ROXO = "\u001B[35m"; // branco para jogadas
    public static final String BRANCO = "\u001B[37m";
    public static final String VERMELHO = "\u001B[41m";


    public  void mostra() {
        int jinferior = 0;
        int jsuperior = 3;
        for (int l = 0; l < 3; l++) {
            int kinferior = 0;
            int ksuperior = 3;
            for (int i = 0; i < 3; i++) {
                for (int j = jinferior; j < jsuperior; j++) {
                    for (int k = kinferior; k < ksuperior; k++) {

                        exibeValor(blocos[j].getCasa(k));

                        if (((k + 1) % 3 == 0) && ((j + 1) % 3 != 0)) {
                            System.out.print("|");
                        }
                    }
                }
                System.out.println();
                kinferior = kinferior + 3;
                ksuperior = ksuperior + 3;
            }
            if (l != 2) {
                System.out.println("---------+---------+---------");
            }
            jinferior = jinferior + 3;
            jsuperior = jsuperior + 3;
        }
        System.out.println();
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
