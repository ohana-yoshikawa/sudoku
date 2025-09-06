package View;

import model.Jogada;
import model.TipoJogada;


import java.util.Scanner;

public class MenuView {

    public static int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------SUDOKU MENU--------");
        System.out.println("1- Adicionar um número");
        System.out.println("2- Remover um número");
        System.out.println("3- Verificar status do jogo");
        System.out.println("4- Limpar jogo");
        System.out.println("5- Finalizar jogo");
        System.out.println("---------------------------");
        return Integer.parseInt(scanner.nextLine());
    }

    //limitar valores de 1 a 9 dps
    public static Jogada solicitarJogada(TipoJogada tipo) {
        Scanner sc = new Scanner(System.in);

        if (tipo == TipoJogada.INSERIR) {
            String mensagem;
            mensagem = "Qual número deseja adicionar?";
            int valor = lerNumeroEntre1e9(mensagem, sc);

            mensagem = "Em qual linha?";
            int linha = lerNumeroEntre1e9(mensagem, sc);

            mensagem = "em Qual coluna?";
            int coluna = lerNumeroEntre1e9(mensagem, sc);

            return new Jogada(valor, linha - 1, coluna - 1, tipo);
        } else if (tipo == TipoJogada.APAGAR) {
            String mensagem;

            mensagem = "Apagar o valor de qual linha?";
            int linha = lerNumeroEntre1e9(mensagem, sc);

            mensagem = "Qual coluna?";
            int coluna = lerNumeroEntre1e9(mensagem, sc);

            return new Jogada(0, linha - 1, coluna - 1, tipo);
        }

        throw new IllegalArgumentException("Tipo de jogada inválido: " + tipo);
    }

    private static int lerNumeroEntre1e9(String mensagem, Scanner sc) {
        int numero = 0;
        do {
            System.out.println(mensagem);
            try {
                numero = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Insira um número inteiro de 1 a 9");
            }
        } while (numero < 1 || numero > 9);
        return numero;
    }

}
