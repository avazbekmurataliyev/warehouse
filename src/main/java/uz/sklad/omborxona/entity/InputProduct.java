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
    public class InputProduct {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id ;

        @ManyToOne(optional = false)
        private Product product ;

        private Double amount ;

        private Double price ;

        private Date expireDate ;
        @ManyToOne(optional = false)
        private Input input ;

    }
