package model.verificadores;

import model.Tabuleiro;

public class VerificadorBloco implements Verificador {
    @Override
    public boolean verificar(Tabuleiro tabuleiro) {
        boolean estaErrado = false;
        for (int i = 0; i < 9; i++) {
            estaErrado = tabuleiro.getBlocos(i).verificaBloco();
        }
        return estaErrado;
    }
}
