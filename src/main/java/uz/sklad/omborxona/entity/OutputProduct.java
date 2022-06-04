    package uz.sklad.omborxona.entity;


    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import javax.persistence.*;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity

    public class OutputProduct {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id ;
        @ManyToOne(optional = false)
        private Product product ;

        private Double amount ;

        private Double price ;
        @ManyToOne(optional = false)
        private Output output ;

    }
