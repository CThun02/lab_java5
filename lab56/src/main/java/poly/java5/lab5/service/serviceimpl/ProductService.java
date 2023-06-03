package poly.java5.lab5.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import poly.java5.lab5.model.Product;
import poly.java5.lab5.repository.ProductRepositoryDAO;
import poly.java5.lab5.service.serviceI.ProductServiceI;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements ProductServiceI{
    @Autowired
    private ProductRepositoryDAO repo;

    @Override
    public Product save(Product productEntity) {
        Product product = repo.save(productEntity);
        return product;
    }

    @Override
    public Product update(Product productEntity) {
        Product product = repo.save(productEntity);
        return product;
    }

    @Override
    public void delete(Product productEntity) {
        repo.delete(productEntity);
    }

    @Override
    public List<Product> getList() {
        return repo.findAll();
    }

    @Override
    public Product getOne(UUID id) {
        Product product = repo.getReferenceById(id);
        return product;
    }

    @Override
    public Page<Product> getProducts(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return repo.findAll(pageable);
    }

    @Override
    public Page<Product> getProductsbyPrice(BigDecimal pricemin, BigDecimal pricemax, int pageNumber, int pagesize) {
        Pageable page = PageRequest.of(pageNumber, pagesize);
        return repo.findAllByPrice(pricemin, pricemax, page);
    }
}
