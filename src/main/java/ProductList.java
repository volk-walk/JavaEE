import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "ProductList", urlPatterns = "/list")
public class ProductList extends HttpServlet {
    private static Logger logger = (Logger) LoggerFactory.getLogger(ProductList.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product(i,"Product-" + i, i*10 + 50);
            productList.add(product);
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        for (Product p : productList) {
            resp.getWriter().printf("<h1>"+p.productInfo()+"<h1>");
        }
        resp.getWriter().printf("</body><html>");
        resp.getWriter().close();
    }
}