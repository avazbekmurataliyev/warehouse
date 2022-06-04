package uz.sklad.omborxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sklad.omborxona.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
