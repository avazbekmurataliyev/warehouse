package uz.sklad.omborxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sklad.omborxona.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{

}
