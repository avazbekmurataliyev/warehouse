    package uz.sklad.omborxona.entity;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import javax.persistence.*;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id ;
        @Column(nullable = false)
        private String name ;
        @Column(nullable = false)
        private String code ;
        @OneToOne
        private Attachment photo  ;

        @OneToOne(optional = false)
        private Measurement measurement  ;

        @ManyToOne(optional = false)
        private Category category ;

    }
