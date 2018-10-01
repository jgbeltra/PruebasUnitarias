package co.com.devco.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {

    private String nombre;
    private String apelido;
    private int edad;

}
