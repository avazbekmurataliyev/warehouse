package uz.sklad.omborxona.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Output {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private Date date ;
    @ManyToOne(optional = false)
    private Warehouse warehuose ;
    @OneToOne(optional = false)
    private Currency currency ;
    @Column(nullable = false)
    private String factureNumber ;
    @Column(nullable = false)
    private String code ;

}
