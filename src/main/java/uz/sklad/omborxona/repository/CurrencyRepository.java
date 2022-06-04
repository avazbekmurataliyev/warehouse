package uz.sklad.omborxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sklad.omborxona.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
