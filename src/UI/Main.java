package UI;
import domain.Order;
import domain.OrderState;
import repository.OrderRepository;
import repository.OrderRepositoryImplementation;
import service.OrderService;
import domain.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImplementation;
import service.ProductService;
import service.UserService;
import repository.UserRepositoryImplementation;
import repository.UserRepository;
import domain.User;

import java.util.List;

public class Main {
    public static void main(String[] arggs){

       try {
        //Usuario CRUD
           UserRepository userRepository = new UserRepositoryImplementation();
           UserService userService = new UserService(userRepository);


           User usuario1 = userService.createUser("José", "18-02-2007");
           User usuario2 =  userService.createUser( "Ana", "19-05-2000");
           User usuario3 = userService.createUser("Maria", "20-10-1995");

           List<User> usuarios = userService.listUser();

           System.out.println("Usuarios do sistema: \n");
           for(User usuario: usuarios){
               System.out.println(usuario.getName());
           }

           usuario2 = userService.updateUser(userService.createUser("Ana Silva", "19-05-2000"));
           userService.deletarUsuario(usuario1.getId());

       //Produto CRUD
           ProductRepository productRepository = new ProductRepositoryImplementation();
           ProductService productService = new ProductService(productRepository);

           Product produto1 = productService.createProduct("Camiseta", "Camista basica", 29.99);
           Product produto2 = productService.createProduct( "Calça Jeans", "Larga", 79.99);
           Product produto3 = productService.createProduct("Tênis", "Tênis de corrida", 149.99);

           List<Product> produtos = productService.list();

           System.out.println("\nProdutos do sistema: \n");
           for(Product produto: produtos) {
               System.out.println(produto.getName());
           }

        // Pedido CRUD
           OrderRepository orderRepository = new OrderRepositoryImplementation();
           OrderService orderService = new OrderService(orderRepository);

           List<Integer> order1Quantity = List.of(2, 1, 1);
           Order order1 = orderService.createOrder(usuario2.getId(), produtos, order1Quantity);

           System.out.println(orderService.search(order1.getIdOrder()));

       } catch (IllegalArgumentException e) {
           System.out.println("Erro: " + e.getMessage());
       }
    }
}
