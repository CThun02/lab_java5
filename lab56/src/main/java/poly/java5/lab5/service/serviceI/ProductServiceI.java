package poly.java5.lab5.service.serviceI;

import org.springframework.data.domain.Page;
import poly.java5.lab5.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductServiceI {
    public Product save(Product productEntity);
    public Product update(Product productEntity);
    public void delete(Product productEntity);
    public List<Product> getList();
    public Product getOne(UUID id);
    public Page<Product> getProducts(int pageNumber, int pageSize);
    public Page<Product> getProductsbyPrice(BigDecimal pricemin, BigDecimal pricemax, int pageNumber, int pageSize);
}
