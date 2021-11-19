package day05;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public List<ProductWithPiece> numberOfProductsByType() {
        List<ProductWithPiece> result = new ArrayList<>();
        for (Product product : products) {
            ProductWithPiece pwp = new ProductWithPiece(product.getType());
            int index;
            if ((index = result.indexOf(pwp)) >= 0) {
                result.get(index).incrementCount();
            } else {
                result.add(pwp);
            }
        }
        return result;
    }

    public List<Product> getProducts() {
        return products;
    }
}
