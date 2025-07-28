package model.verificadores;

import model.Tabuleiro;

public class VerificadorTemCasaVazia implements Verificador{
    @Override
    public boolean verificar(Tabuleiro tabuleiro) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (tabuleiro.getMatriz(i, j).getValor() == 0){
                    return true;
                }
            }
        }
        return false;
    }
}