package java_crud;

public class Gol extends Motor implements Carro {

    public Gol(){
        super(2020);
    }

    @Override
    public void carregar_motor() {
        System.out.println("O motor de ano: "+ this.ano + " está carregado");
    }

    @Override
    public void acelerar() {

    }

    @Override
    public void freiar() {

    }

    @Override
    public void parar() {

    }
}
