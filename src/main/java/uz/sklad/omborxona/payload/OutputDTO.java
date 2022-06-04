package uz.sklad.omborxona.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OutputDTO {

    private Integer warehuoseId;

    private Integer currencyId ;

    private String factureNumber ;

}
