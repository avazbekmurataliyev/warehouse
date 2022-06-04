    package uz.sklad.omborxona.entity;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import javax.persistence.*;
    import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity

    public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id ;

        private String firstName ;

        private String lastName ;

        private String phoneNumber ;

        private String password ;

        @ManyToMany
        private List<Warehouse> warehouse ;

        private String code ;

        private boolean active ;
    }
