package br.com.gabriel.restaurante.view;

import br.com.gabriel.restaurante.entities.Categories;
import br.com.gabriel.restaurante.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuRenderer {
    public void showOMenu(List<Product> all){
        System.out.println("\n========= CARDÁPIO DO RESTAURANTE =========");
        for (Categories cat : Categories.values()) {
            IO.println("\n--- " + cat + " ---");
            all.stream()
                    .filter(p -> p.getCategories() == cat)
                    .forEach(p -> IO.println("Prato: " + p.getName() + "\nDescrição: " + p.getDescription() + "\nPreço = R$ " + p.getPrice() + "\n"));
        }
    }

    public void showShoppingCart(List<Product> shoppingCart){
        if (shoppingCart.isEmpty()){
            IO.println("\nCarrinho vazio!!");
            return;
        }
        IO.println("===== PEDIDOS ====");
        for (Product p : shoppingCart) {
            IO.println("- " + p.getName() + " R$" + p.getPrice());
        }
        double totalPayment = shoppingCart.stream().mapToDouble(Product::getPrice).sum();
        System.out.printf("Total a pagar = R$%.2f\n", totalPayment);
    }
}
