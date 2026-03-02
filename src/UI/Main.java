package UI;
import service.UserService;
import repository.UserRepositoryImplementation;
import repository.UserRepository;
import domain.User;

import java.util.List;

public class Main {
    public static void main(String[] arggs){

       try {
           UserRepository repository = new UserRepositoryImplementation();
           UserService service = new UserService(repository);


            User usuario1 = service.createUser(System.currentTimeMillis(), "José", "18-02-2007");
            User usuario2 =  service.createUser(System.currentTimeMillis(), "Ana", "19-05-2000");
            User usuario3 = service.createUser(System.currentTimeMillis(), "Maria", "20-10-1995");

           List<User> usuarios = service.listUser();

           System.out.println("Usuarios do sistema: \n");
           for(User usuario: usuarios){
               System.out.println(usuario.getName());
           }

           service.updateUser(service.createUser(usuario2.getId(), "Ana Silva", "19-05-2000"));
           service.deletarUsuario(usuario1.getId());


       } catch (IllegalArgumentException e) {
           System.out.println("Erro: " + e.getMessage());

       }
    }
}
