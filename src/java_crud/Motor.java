package java_crud;

public abstract class Motor {

    protected int ano;
    public Motor(int ano){
        this.ano = ano;
    }

    public abstract void carregar_motor();

    public void ligar(){
        System.out.println("VRUMMMM");
    };
}
