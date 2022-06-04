package uz.sklad.omborxona.entity.template;

import lombok.Data;

import javax.persistence.*;
@Data
@MappedSuperclass
public abstract class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(nullable = false)
    private String name ;
    @Column(nullable = false)
    private boolean active ;

}
