package geekbrains.lesson3;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "One", 110));
        products.add(new Product(2, "Two", 222));
        products.add(new Product(3, "Three", 300));
        products.add(new Product(4, "Four", 440));
        products.add(new Product(5, "Five", 555));
    }

    public void add(Product product) {
        if (product.getCost() < 0) {
            throw new IllegalArgumentException("The cost must be greater than 0");
        }
        if (product.getTitle().isEmpty()) {
            throw new IllegalArgumentException("The title cannot be empty");
        }
        products.add(product);
    }

    public Product getById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> getByListId(List<Integer> ids) {
        ArrayList<Product> res = new ArrayList<>();
        for (Product p : products) {
            if (ids.contains(p.getId())) {
                res.add(p);
            }
        }
        return res;
    }

    public Product updateById(int id, String newTitle) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setTitle(newTitle);
                return p;
            }
        }
        return null;
    }

    public Product updateById(int id, double newCost) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setCost(newCost);
                return p;
            }
        }
        return null;
    }

    public Product deleteById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                return p;
            }
        }
        return null;
    }
}
