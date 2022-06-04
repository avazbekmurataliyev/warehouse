package uz.sklad.omborxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sklad.omborxona.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
