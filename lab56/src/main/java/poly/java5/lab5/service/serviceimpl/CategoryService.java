package poly.java5.lab5.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.java5.lab5.model.Category;
import poly.java5.lab5.model.Product;
import poly.java5.lab5.repository.CategoryRepositoryDAO;
import poly.java5.lab5.repository.ProductRepositoryDAO;
import poly.java5.lab5.service.serviceI.CategoryServicel;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService implements CategoryServicel {
    @Autowired
    private CategoryRepositoryDAO repo;

    @Override
    public Category save(Category category) {
        Category category1 = repo.save(category);
        return category1;
    }

    @Override
    public Category update(Category category) {
        Category category1 = repo.save(category);
        return category1;
    }

    @Override
    public void delete(Category category) {
        repo.delete(category);
    }

    @Override
    public List<Category> getList() {
        return repo.findAll();
    }

    @Override
    public Category getOne(UUID id) {
        return repo.getReferenceById(id);
    }
}
