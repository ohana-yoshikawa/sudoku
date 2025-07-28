package model;

public class Jogada {
    private final int valor;
    private final int casaIndex;
    private final int blocoIndex;
    private final TipoJogada tipoJogada;

    public Jogada(int valor, int linha, int coluna, TipoJogada tipoJogada) {
        this.valor = valor;
        casaIndex = Tabuleiro.indiceCasaNoBloco(linha, coluna);
        blocoIndex = Tabuleiro.indiceDoBloco(linha, coluna);
        this.tipoJogada = tipoJogada;
    }

    public int getValor() {
        return valor;
    }

    public int getCasaIndex() {
        return casaIndex;
    }

    public int getBlocoIndex() {
        return blocoIndex;
    }

    public TipoJogada getTipoJogada() {
        return tipoJogada;
    }
}
