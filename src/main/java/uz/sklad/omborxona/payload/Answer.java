package uz.sklad.omborxona.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {
    private String message ;

    private boolean success ;

}
