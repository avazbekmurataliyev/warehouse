package uz.sklad.omborxona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.sklad.omborxona.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {

    Attachment findByName(String name);

}
