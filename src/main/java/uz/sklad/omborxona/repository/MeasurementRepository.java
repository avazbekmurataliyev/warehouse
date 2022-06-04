package uz.sklad.omborxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sklad.omborxona.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
}
