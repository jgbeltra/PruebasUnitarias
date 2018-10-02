package co.com.devco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Persona {

    private String nombre;
    private String apelido;
    private int edad;

}
