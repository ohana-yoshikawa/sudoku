package Controller;

import View.Menu;
import model.Jogada;
import model.Partida;
import model.TipoJogada;

public class SudokuController {
    public static void main(String[] args) {
        boolean continuar = true;
        Partida partida = new Partida(args);

        while (continuar) {
            int opcao = Menu.mostrarMenu();
            switch (opcao){
                case 1-> {
                    //inserir novo valor
                    Jogada jogada = Menu.solicitarJogada(TipoJogada.INSERIR);
                    partida.inserirValor(jogada);
                    partida.mostrarTabuleiro();
                }

                case 2->{
                    //apagar valor
                    Jogada jogada = Menu.solicitarJogada(TipoJogada.APAGAR);
                    partida.inserirValor(jogada);
                    partida.mostrarTabuleiro();
                }


                case 3->{
                    //verificar status do jogo
                    partida.verificaJogo();
                    partida.mostrarTabuleiro();

                }

                case 4->{
                    //limpar jogo
                    partida.limparJogo();
                    System.out.println("\n Limpando tabuleiro...");
                    partida.mostrarTabuleiro();
                }

                case 5->{
                    if (partida.verificarFinalizacaoJogo()) {
                        System.out.println("Parabéns! você concluiu o jogo!");
                        partida.mostrarTabuleiro();
                        continuar = false;
                    } else {
                        System.out.println("Ops! parece que algumas casas ainda não estão certas, continue tentando!");
                        partida.verificaJogo();
                        partida.mostrarTabuleiro();

                    }
                }
            }

        }


    }
}
