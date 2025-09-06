package Controller;

import View.MensagemView;
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
        MensagemView mensagemView = new MensagemView();

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


                case 3->
                    //verificar status do jogo
                    partida.verificaJogo();

                case 4->{
                    //limpar jogo
                    partida.limparJogo();
                    mensagemView.mostrar("\n Limpando tabuleiro...");
                }

                case 5->{
                    if (partida.verificarFinalizacaoJogo()) {
                        mensagemView.mostrar("Parabéns! você concluiu o jogo!");
                        continuar = false;
                    } else {
                        mensagemView.mostrar("Ops! parece que algumas casas ainda não estão certas, continue tentando!");
                        partida.verificaJogo();
                    }
                }
            }

        }


    }
}
