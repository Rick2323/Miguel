
package Logic;


import java.util.Scanner;

/**
 * Classe que serve para o jogador poder interagir com as perguntas que 
 * são feitas durante o jogo.
 * 
 * @author Miguel Lobato
 * @version 1.1 (2020.05.20)
 */
public class InputReader {

    private Scanner reader;
/**
 * Permitenos escrever para a consola para interagir com as perguntas do jogo.
 */
    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Devolve um texto proveniente do teclado.
     *
     * @param question a pergunta.
     *
     * @return a linha a seguir à pergunta.
     */
    public String getText(String question) {
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);

        return reader.nextLine();
    }

    /**
     * Devolve um inteiro proveniente do teclado.
     *
     * @param question a pergunta
     *
     * @return um inteiro
     */
    public int getInteger(String question) {
        if (question == null) {
            question = "";
        }
        question += "> ";
        System.out.print(question);
        int number = -1;
        number = reader.nextInt();

        return number;
    }

    /**
     * Devolve um decimal proveniente do teclado.
     *
     * @param question a pergunta
     *
     * @return um numero real
     */
    public double getDouble(String question) {
        if (question == null) {
            question = "";
        }
        question += "Valor> ";

        double number = -1.0;

        while (number <= 0.0) {
            System.out.print(question);

            while (!reader.hasNextDouble()) {
                reader.nextLine();
                System.out.print(question);
            }

            number = reader.nextDouble();
            System.out.println(number);
        }
        reader.nextLine();

        return number;
    }
}
