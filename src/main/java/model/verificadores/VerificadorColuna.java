package model.verificadores;

import model.Casa;
import model.Tabuleiro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerificadorColuna implements Verificador {

    boolean estaErrado = false;
    @Override
    public boolean verificar(Tabuleiro tabuleiro) {
        for (int i = 0; i < 9; i++) {
            Map<Integer, List<Casa>> duplicatas = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                if (tabuleiro.getMatriz(j, i).getValor() != 0) {
                    int valor = tabuleiro.getMatriz(j, i).getValor();
                    duplicatas.putIfAbsent(valor, new ArrayList<>());
                    duplicatas.get(valor).add(tabuleiro.getMatriz(j, i));

                    List<Casa> lista = duplicatas.get(valor);
                    if (lista.size() > 1) {
                        for(Casa casa : lista) {
                            casa.setErrada(true);
                            estaErrado = true;
                        }
                    }
                }
            }
        }
        return estaErrado;
    }


}
