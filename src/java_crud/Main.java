package java_crud;

import java.io.IOException;

class Main {
    public static void main(String[] args){

        Gol gol = new Gol();
        gol.carregar_motor();

        Carro meuCarroFurado = null;

        try {
            meuCarroFurado.acelerar();


            /* Exceções
                NullPointerException
                ArrayIndexOutOfBoundsException
                RuntimeException
                IOException
                ArithmeticException
            */

        } catch (NullPointerException exception){
            System.out.println("Vende carro furado");
        }
    }
}