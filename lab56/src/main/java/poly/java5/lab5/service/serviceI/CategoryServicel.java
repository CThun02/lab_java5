package poly.java5.lab5.service.serviceI;

import poly.java5.lab5.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryServicel {
    public Category save(Category category);
    public Category update(Category category);
    public void delete(Category category);
    public List<Category> getList();
    public Category getOne(UUID id);
}
