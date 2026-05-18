package br.com.gabriel.restaurante.view;

import br.com.gabriel.restaurante.entities.Product;
import br.com.gabriel.restaurante.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
@Order(2)
public class RestaurantMenu implements CommandLineRunner{
    private final ProductRepository productRepository;
    private final MenuRenderer menuRenderer;
    private static final String HEADER =  "==========================" +
                                        "\n==  MENU DO RESTAURANTE ==" +
                                        "\n==========================";

    public RestaurantMenu(ProductRepository productRepository, MenuRenderer menuRenderer) {
        this.productRepository = productRepository;
        this.menuRenderer = menuRenderer;
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
            IO.println("4- Finalizar pedido");
            IO.println("5- Sair");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    List<Product> all = productRepository.findAll();
                    menuRenderer.showOMenu(all);
                    break;
                case 2:
                    IO.print("Digite o id do produto que deseja: ");
                    Long id = scanner.nextLong();
                    Optional<Product> productOpt = productRepository.findById(id);

                    if (productOpt.isPresent()){
                        Product p = productOpt.get();
                        shoppingCart.add(p);
                        IO.println(">>> " + p.getName() + "adicionado ao carrinho!");
                    } else {
                        IO.println("Produto não encontrato!");
                    }
                    break;
                case 3:
                    menuRenderer.showShoppingCart(shoppingCart);
                    break;
                case 4:
                    menuRenderer.showShoppingCart(shoppingCart);
                    IO.println("\nPagamento efeituado com sucesso!");
                    shoppingCart.clear();
                    break;
                case 5:
                    if (shoppingCart.isEmpty()){
                        IO.println("Obrigado, volte sempre!");
                        scanner.close();
                        System.exit(0);
                    } else {
                        IO.println("Necessario fazer o pagamento do pedido para sair!");
                    }
                    break;
                default:
                    IO.println("Erro. Opção invalida!");
            }
        }
    }
}
