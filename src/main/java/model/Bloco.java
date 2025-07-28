package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bloco {

    private final Casa[] casas;

    public Bloco() {
        casas = new Casa[9];
        for (int i = 0; i < casas.length; i++) {
            casas[i] = new Casa();
        }
    }

    public boolean verificaBloco() {
        boolean estaErrado = false;
        Map<Integer, List<Casa>> duplicatas = new HashMap<>();

        for (Casa casa : casas){
            int valor = casa.getValor();
            if (valor != 0) {
                duplicatas.putIfAbsent(valor, new ArrayList<>());
                duplicatas.get(valor).add(casa);
                List<Casa> lista = duplicatas.get(valor);

                if (lista.size() > 1) {
                    for(Casa casaDuplicada : lista) {
                        casaDuplicada.setErrada(true);
                        estaErrado = true;
                    }
                }
            }
        }
        return estaErrado;
    }

    public void adicionaValorFixo(int casaIndex, int valor) {
        this.casas[casaIndex].setValor(valor);
        this.casas[casaIndex].setFixa(true);
    }

    public void adicionaValor(Jogada jogada){
        this.casas[jogada.getCasaIndex()].aplicarJogada(jogada);
    }

    public Casa getCasa(int i) {
        if (i < 0 || i >= 9) throw new IndexOutOfBoundsException("Índice de casa inválido: " + i);
        return casas[i];
    }


}
