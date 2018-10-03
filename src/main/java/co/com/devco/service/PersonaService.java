package co.com.devco.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import co.com.devco.model.EtapaVida;
import co.com.devco.model.Persona;
import org.springframework.util.StringUtils;

public class PersonaService {

    private static String[] actividadesInfancia = {"Correr", "Saltar", "Ir a piscina", "Llorar"};
    private static String[] actividadesJoven = {"Correr", "Saltar", "Ir a piscina", "Estudia en colegio", "Escucha musica"};
    private static String[] actividadesAdolescencia = {"Estudia en universidad", "Sale de compras", "Apuesta"};
    private static String[] actividadesJuevntud = {"Estudia en universidad", "Trabaja", "Sale a comer con amigos"};
    private static String[] actividadesAdulto = {"Programa", "Enferma", "Cuida su familia"};
    private static String[] actividadesAnciano = {"Sale a la playa", "Compra bienes", "Cuida su nietos"};

    public String presentarPersona(Persona persona) throws Exception {

        if (persona == null) {
            throw new NullPointerException("persona no valida");
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

    public int calcularAnioNacimiento(int edad) throws Exception {
        int anioActual = LocalDate.now().getYear();

        if (edad > anioActual) {
            throw new Exception("la edad es invalida por favor verifique");
        }

        if (edad < 0) {
            throw new Exception("la edad es invalida por favor verifique");
        }

        return anioActual - edad;
    }

    public List<String> consultarMovientos(String idTransaccion) {
        List lista = new ArrayList<String>();
        if (idTransaccion.equals("123"))
            lista.add("123");
        return lista;
    }

    public String[] obtenerActividadesPorEdad(int edad) {
        EtapaVida etapaAux = obtenerEtapaDeVida(edad);
        if (etapaAux != null) {
            return obtenerActividades(etapaAux);
        } else {
            return null;
        }
    }

    protected EtapaVida obtenerEtapaDeVida(int edad) {
        return Optional.ofNullable(EtapaVida.values())
                .map(etapaVidas -> {
                    return Arrays.stream(etapaVidas)
                            .filter(etapa -> edad >= etapa.getInicio() && edad <= etapa.getFin())
                            .findFirst()
                            .orElse(null);
                }).orElse(null);
    }

    protected String[] obtenerActividades(EtapaVida etapaVida) {
        switch (etapaVida) {
            case INFANCIA:
                return actividadesInfancia;
            case JOVEN:
                return actividadesJoven;
            case ADOLESCENCIA:
                return actividadesAdolescencia;
            case JUVENTUD:
                return actividadesJuevntud;
            case ADULTO:
                return actividadesAdulto;
            case ANCIANO:
                return actividadesAnciano;
            default:
                return null;
        }
    }


}
