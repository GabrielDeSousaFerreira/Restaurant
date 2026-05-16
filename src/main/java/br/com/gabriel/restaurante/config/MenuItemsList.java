package br.com.gabriel.restaurante.config;

import br.com.gabriel.restaurante.entities.Categories;
import br.com.gabriel.restaurante.entities.Product;
import br.com.gabriel.restaurante.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@Order(1)
public class MenuItemsList implements CommandLineRunner {
    private final ProductRepository productRepository;

    public MenuItemsList(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0){

            productRepository.saveAll(List.of(
                new Product("Feijoada pequena ","Arroz, feijão preto com carnes selecionadas, farofa e couve", 34.99, Categories.FOODS),
                new Product("Feijoada grande ","Porção generosa com todos os acompanhamentos tradicionais", 59.99, Categories.FOODS),
                new Product("Picadinho ", "Arroz, feijão, carne picada com batatas e tempero da casa", 29.89, Categories.FOODS),
                new Product("Strogonoff de Frango ","Cubos de frango ao molho cremoso com champignon, acompanhados de arroz branco e batata palha", 28.59, Categories.FOODS),
                new Product("Lasanha à Bolanhesa ","Camadas de massa recheadas com molho bolonhesa, presunto, queijo e molho branco gratinado", 32.49, Categories.FOODS),
                new Product("Parmegiana de Carne ","Bife empanado coberto com molho de tomate e queijo gratinado, servido com arroz e fritas", 36.99, Categories.FOODS),
                new Product("Filé de Frango Grelhado ","Filé de frango temperado e grelhado, acompanhado de arroz, feijão e salada fresca", 24.99, Categories.FOODS),

                new Product("Água Mineral com Gás 500ml ", "Água mineral com gás servida gelada", 4.49, Categories.DRINKS),
                new Product("Água Mineral 500ml ", "Água mineral sem gás servida gelada", 3.49, Categories.DRINKS),
                new Product("Guaraná Antartica 500ml ", "Refrigelante cola em garrafa de 500ml", 6.49, Categories.DRINKS),
                new Product("Coca-Cola 2l ", "Rfrigerante cola em garrafa ideal para familia", 13.89, Categories.DRINKS),
                new Product("Sucos naturais 500ml ", "Sucos servidos gelados de Laranja, Maracuja e Limão.", 8.49, Categories.DRINKS),
                new Product("Heineken Long Neck 330ml ", "Cerveja puro malte servida bem gelada.", 9.99, Categories.DRINKS),
                new Product("Cerveja Brahma Duplo Malte 600ml ", "Cerveja leve e cremosa ideal para acompanhar refeições.", 13.89, Categories.DRINKS),

                new Product("Sorvete - ", "Sorvete cremoso napolitano", 11.89, Categories.DESSERTS),
                new Product("Pudim de Leite Condensado - ", "Pudim cremoso com calda de caramelo artesanal.", 9.89, Categories.DESSERTS),
                new Product("Petit Gateau - ", "Bolinho quente de chocolate com recheio cremoso acompanhado de sorvete.", 16.89, Categories.DESSERTS),
                new Product("Açai - ", "Acompnhado com leite em pó, banana, leite condensado, granola.", 13.49, Categories.DESSERTS)
            ));

            //p1, p2 , p3, p4, p5, p6, p7, b1, b2, b2, b3, b4, b5, b6, b7, s1, s2, s3, s4
        }
    }
}
