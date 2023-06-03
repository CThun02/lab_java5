package poly.java5.lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.java5.lab5.model.Category;

import java.util.UUID;

@Repository
public interface CategoryRepositoryDAO extends JpaRepository<Category, UUID> {
}
