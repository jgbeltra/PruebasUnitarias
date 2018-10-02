package co.com.devco.service;

import java.time.LocalDate;

import co.com.devco.model.Persona;
import org.springframework.util.StringUtils;

public class PersonaService {

    public String presentarPersona(Persona persona) throws Exception {

        if (persona == null) {
            throw new Exception("persona no valida");
        }
        if (StringUtils.isEmpty(persona.getNombre())) {
            throw new Exception("el nombre de la persona es requerido");
        }
        if (StringUtils.isEmpty(persona.getApelido())) {
            throw new Exception("el apellido de la persona es requerido");
        }
        if (persona.getEdad() <= 0) {
            throw new Exception("la edad de la persona no es valida");
        }
        return "Hola, soy " + persona.getNombre() + " " + persona.getApelido() + " de edad: " + persona.getEdad();
    }

    protected int getActualYear (){
        return LocalDate.now().getYear();
    }

    public int calcularAnioNacimiento(int edad) throws Exception {
        int anioActual = getActualYear();

        if (edad > anioActual) {
            throw new Exception("la edad es invalida por favor verifique");
        }

        if (edad < 0) {
            throw new Exception("la edad es invalida por favor verifique");
        }

        return anioActual - edad;
    }
}
