package uz.sklad.omborxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sklad.omborxona.entity.Input;

public interface InputRepostory extends JpaRepository<Input,Integer> {
}
