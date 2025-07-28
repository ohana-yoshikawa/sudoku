package model;

public class Casa {

    private int valor;
    private boolean errada;
    private boolean fixa;

    public Casa(){
        this.valor = 0;
        this.fixa = false;
        this.errada = false;
    }

    public void aplicarJogada(Jogada jogada){
        this.valor = jogada.getValor();
        this.errada = false;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isFixa() {
        return fixa;
    }

    public void setFixa(boolean fixa) {
        this.fixa = fixa;
    }

    public boolean isErrada() {
        return errada;
    }

    public void setErrada(boolean errada) {
        this.errada = errada;
    }
}
