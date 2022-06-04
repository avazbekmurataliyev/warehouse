    package uz.sklad.omborxona.payload;

    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.util.Date;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public class OutputProductDTO {

        private Integer productId ;

        private Double amount ;

        private Double price ;

        private Integer outputId ;

    }
