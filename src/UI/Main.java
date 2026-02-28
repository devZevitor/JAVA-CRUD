package UI;
import service.UserService;
import repository.UserRepositoryImplementation;
import repository.UserRepository;
import domain.User;

import java.util.ArrayList;

public class Main {
    public static void main(String[] arggs){

        UserRepository repository = new UserRepositoryImplementation();
        UserService service = new UserService(repository);


        service.criar_usuario(System.currentTimeMillis(), "José", "18-02-2007");
        service.criar_usuario(System.currentTimeMillis(), "Ana", "19-05-2000");


        ArrayList<User> usuarios = service.listar_usuario();

        System.out.println("Usuarios do sistema: \n");
        for(User usuario: usuarios){
            System.out.println(usuario.pegar_nome());
        }
    }
}
