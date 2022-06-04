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

    public class Input {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Integer id ;

        private Date date ;

        private String code ;

        @OneToOne(optional = false)
        private Warehouse warehuose;

        @ManyToOne(optional = false)
        private Supplier supplier ;
        @OneToOne(optional = false)
        private Currency currency ;

        private String factureNumber ;

    }
