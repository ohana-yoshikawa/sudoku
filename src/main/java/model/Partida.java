package model;

import View.MensagemView;
import model.verificadores.*;

import java.util.*;

public class Partida {
    private final List<Verificador> verificadores;

    private final Tabuleiro tabuleiro;
    public Partida(String[] args) {
        this.tabuleiro = new Tabuleiro();
        this.verificadores = List.of(
                new VerificadorTemCasaVazia(),
                new VerificadorLinha(),
                new VerificadorColuna(),
                new VerificadorBloco()
        );
        inserirCasasFixas(args);

    }

    public void inserirCasasFixas(String[] args) {
        String[] posicaoEvalor;
        String[] linhaEcoluna;
        String[] numeroEfixo;
        int blocoIndex, casaIndex;


        for (String arg : args) {

            posicaoEvalor = arg.split(";");
            numeroEfixo = posicaoEvalor[1].split(",");

            //verifica se a casa será fixa
            if (numeroEfixo[1].equals("true")) {

                //traduzir para posição global
                linhaEcoluna = posicaoEvalor[0].split(",");
                //int coluna = Integer.parseInt(linhaEcoluna[0]);
                //int linha = Integer.parseInt(linhaEcoluna[1]);
                int linha = Integer.parseInt(linhaEcoluna[0]);
                int coluna = Integer.parseInt(linhaEcoluna[1]);

                blocoIndex = Tabuleiro.indiceDoBloco(linha, coluna);
                casaIndex = Tabuleiro.indiceCasaNoBloco(linha, coluna);

                //inserir numero
                int valor = Integer.parseInt(numeroEfixo[0]);
                inserirValor(valor, blocoIndex, casaIndex);
            }
        }
    }

    //inseri valores fixos
    public void inserirValor(int valor, int blocoIndex, int casaIndex) {
       tabuleiro.getBlocos(blocoIndex).adicionaValorFixo(casaIndex, valor);
    }

    //inseri valores adicionados pelo usuário
    public void inserirValor(Jogada jogada) {
        if (verificarJogada(jogada)) {
            tabuleiro.getBlocos(jogada.getBlocoIndex()).adicionaValor(jogada);
        }
    }

    public boolean verificarJogada(Jogada jogada) {
        MensagemView mensagemView = new MensagemView();
        if (jogada.getTipoJogada() == TipoJogada.INSERIR) {
            if (tabuleiro.getBlocos(jogada.getBlocoIndex()).getCasa(jogada.getCasaIndex()).getValor() == 0) {
                return true;
            } else {
                System.out.println();
                mensagemView.mostrar("Esta casa já está ocupada! apague o valor antes de inserir um novo");
                System.out.println();
                return false;
            }
        } else if (jogada.getTipoJogada() == TipoJogada.APAGAR) {
            //verificar se é fixa
            if (tabuleiro.getBlocos(jogada.getBlocoIndex()).getCasa(jogada.getCasaIndex()).getValor() != 0) {
                if (!tabuleiro.getBlocos(jogada.getBlocoIndex()).getCasa(jogada.getCasaIndex()).isFixa()) {
                    return true;
                } else {
                    mensagemView.mostrar("\n Esta casa é fixa e não pode ser apagada!");
                }
            } else {
                mensagemView.mostrar("\n Esta casa já está vazia! selecione uma casa ocupada para apagar!");
                return false;
            }
        } else {
            throw new IllegalArgumentException("\n Tipo de jogada inválido: " + jogada.getTipoJogada());
        }
        return false;
    }

    public void verificaJogo() {
        //zera valores anteriores de errado
        limparCasasErradas();

        List<Verificador> verificadores = List.of(
                new VerificadorLinha(),
                new VerificadorColuna(),
                new VerificadorBloco()
        );

        for (Verificador v : verificadores) {
            v.verificar(tabuleiro);
        }

    }

    public void limparCasasErradas() {
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                if (tabuleiro.getMatriz(i, j).isErrada()) {
                    tabuleiro.getMatriz(i, j).setErrada(false);
                }
            }
        }
    }

    public void limparJogo() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!tabuleiro.getMatriz(i, j).isFixa()){
                    tabuleiro.getMatriz(i, j).setValor(0);
                }
            }
        }
        limparCasasErradas();
    }

    public boolean verificarFinalizacaoJogo() {
        for (Verificador v : verificadores) {
            if(v.verificar(tabuleiro)){
                return false;
            }
        }
        return true;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}

