package geekbrains.firstapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        ArrayList<Product> products = new ArrayList<>();
        createProducts(products);
        out.println("<html><body><ul>");
        for (Product p : products) {
            out.println("<li>" + String.format("%d %s %.2f", p.getId(), p.getTitle(), p.getCost()) + "</li>");
        }
        out.println("</ul></body></html>");
        out.close();
    }

    private void createProducts(ArrayList<Product> products) {
        products.add(new Product(1, "one", 100));
        products.add(new Product(2, "two", 220));
        products.add(new Product(3, "three", 300.3));
        products.add(new Product(4, "four", 404));
        products.add(new Product(5, "five", 500.5));
        products.add(new Product(6, "six", 600));
        products.add(new Product(7, "seven", 700));
        products.add(new Product(8, "eight", 800));
        products.add(new Product(9, "nine", 900));
        products.add(new Product(10, "ten", 1000));
    }
}
