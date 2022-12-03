package com.gb.ker;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    Product[] products;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        if (products == null) {
            products = new Product[10];
            for (int i = 0; i < products.length; i++) {
                products[i] = new Product(i + 1, "Product #2022." + (i + 1), (float) Math.random() * (1000 - 10 + 1) + 10);
            }
        }
        for (Product product : products) {
            resp.getWriter().printf(
                    "<h1>Art. %d: %s - %.2f$</h1>", product.id(), product.title(), product.cost()
            );
            resp.getWriter().printf("</body</html>");
        }

        resp.getWriter().close();
    }
}
