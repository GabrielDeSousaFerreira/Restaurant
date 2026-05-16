package br.com.gabriel.restaurante.view;

import br.com.gabriel.restaurante.entities.Categories;
import br.com.gabriel.restaurante.entities.Product;
import br.com.gabriel.restaurante.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Order(2)
public class RestaurantMenu implements CommandLineRunner{
    private final ProductRepository productRepository;
    private static final String HEADER =  "==========================" +
                                        "\n==  MENU DO RESTAURANTE ==" +
                                        "\n==========================";

    public RestaurantMenu(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void run(String... args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        List<Product> shoppingCart = new ArrayList<>();

        while(true){
            IO.println(HEADER);
            IO.println("Escolha uma opção:");
            IO.println("1- Ver cardapio");
            IO.println("2- Fazer pedido");
            IO.println("3- Ver meu pedido");
            IO.println("4- Finalizar pedido e sair");
            IO.println("5- Sair");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    showOMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    IO.println("Obrigado, volte sempre!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    IO.println("Erro. Opção invalida!");
            }
        }
    }

    private void showOMenu(){
        List<Product> todos = productRepository.findAll();

        System.out.println("\n========= CARDÁPIO DO RESTAURANTE =========");
        for (Categories cat : Categories.values()) {
            IO.println("\n--- " + cat + " ---");
            todos.stream()
                    .filter(p -> p.getCategories() == cat)
                    .forEach(p -> IO.println("Prato: " + p.getName() + "\nDescrição: " + p.getDescription() + "\nPreço = R$ " + p.getPrice() + "\n"));
        }
    }

    private void showShoppingCart(List<Product> shoppingCart){
        if (shoppingCart.isEmpty()){
            IO.println("\nCarrinho vazio!!");
            return;
        }
        IO.println("===== PEDIDOS ====");
        for (Product p : shoppingCart) {
            IO.println("- " + p.getName() + " R$" + p.getPrice());
        }
        double totalPayment = shoppingCart.stream().mapToDouble(Product::getPrice).sum();
        System.out.printf("Total a pagar = #.2f", totalPayment, "\n");
    }
}
