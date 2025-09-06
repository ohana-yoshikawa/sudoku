package Controller;

import View.MenuView;
import View.TabuleiroView;
import model.Jogada;
import model.Partida;
import model.TipoJogada;

public class SudokuController {
    public static void main(String[] args) {
        boolean continuar = true;
        Partida partida = new Partida(args);
        TabuleiroView tabuleiroView = new TabuleiroView();

        while (continuar) {
            tabuleiroView.mostra(partida.getTabuleiro());
            int opcao = MenuView.mostrarMenu();
            switch (opcao){
                case 1-> {
                    //inserir novo valor
                    Jogada jogada = MenuView.solicitarJogada(TipoJogada.INSERIR);
                    partida.inserirValor(jogada);
                }

                case 2->{
                    //apagar valor
                    Jogada jogada = MenuView.solicitarJogada(TipoJogada.APAGAR);
                    partida.inserirValor(jogada);
                }


                case 3->{
                    //verificar status do jogo
                    partida.verificaJogo();
                }

                case 4->{
                    //limpar jogo
                    partida.limparJogo();
                    System.out.println("\n Limpando tabuleiro...");
                }

                case 5->{
                    if (partida.verificarFinalizacaoJogo()) {
                        System.out.println("Parabéns! você concluiu o jogo!");
                        continuar = false;
                    } else {
                        System.out.println("Ops! parece que algumas casas ainda não estão certas, continue tentando!");
                        partida.verificaJogo();
                    }
                }
            }

        }


    }
}
