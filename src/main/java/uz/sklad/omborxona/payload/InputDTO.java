package uz.sklad.omborxona.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InputDTO {

    private String code ;

    private Integer warehuoseId;

    private Integer currencyId ;

    private String factureNumber ;

    private Integer supplierId ;
}
