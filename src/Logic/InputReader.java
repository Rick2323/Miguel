/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Miglob
 */
import java.util.Scanner;


public class InputReader {

    private Scanner reader;

    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Devolve um texto proveniente do teclado.
     *
     * @param question a pergunta.
     *
     * @return a linha a seguir á pergunta.
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
     * @param question
     *
     * @return
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
     * @param question
     *
     * @return
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
