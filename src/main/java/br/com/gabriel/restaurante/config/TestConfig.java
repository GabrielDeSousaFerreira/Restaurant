package br.com.gabriel.restaurante.config;

import br.com.gabriel.restaurante.entities.Product;
import br.com.gabriel.restaurante.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestConfig implements CommandLineRunner {
    private final ProductRepository productRepository;

    public TestConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0){
            Product p1 = new Product("Feijoada pequena, "," Arroz, feijão preto com carnes selecionadas, farofa e couve.", 34.99);
            Product p2 = new Product("Feijoada grande, ","Porção generosa com todos os acompanhamentos tradicionais.", 59.99);
            Product p3 = new Product("Picadinho", "Arroz, feijão, carne picada com batatas e tempero da casa.", 29.90);
            Product p4 = new Product("Strogonoff de Frango, "," Cubos de frango ao molho cremoso com champignon, acompanhados de arroz branco e batata palha.", 28.90);
            Product p5 = new Product("Lasanha à Bolanhesa, "," Camadas de massa recheadas com molho bolonhesa, presunto, queijo e molho branco gratinado.", 32.50);
            Product p6 = new Product("Parmegiana de Carne, "," Bife empanado coberto com molho de tomate e queijo gratinado, servido com arroz e fritas.", 36.90);
            Product p7 = new Product("Filé de Frango Grelhado, "," Filé de frango temperado e grelhado, acompanhado de arroz, feijão e salada fresca.", 24.90);

            productRepository.saveAll(List.of(p1, p2 , p3, p4, p5, p6, p7));
        }

        IO.println("\n==== CARDAPIO DO RESTAURANTE ====");
        List<Product> menu = productRepository.findAll();

        for (Product p : menu){
            IO.println("Item: " + p.getName());
            IO.println("Descrição: " + p.getDescription());
            IO.println("Preço: " + p.getPrice());
            IO.println("-------------------------------");
        }
    }
}
