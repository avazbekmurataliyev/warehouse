package uz.sklad.omborxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sklad.omborxona.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
