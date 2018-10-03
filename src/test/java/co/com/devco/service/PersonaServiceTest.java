package co.com.devco.service;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PersonaServiceTest {


    PersonaService personaService = spy(new PersonaService());


    @Test
    public void testDadoTengoUnIdentificadorValidoEntoncesLaListaNoDebeSerVacia() {
        String idTransaccion = "123";
        List<String> resultado = personaService.consultarMovientos(idTransaccion);
        assertThat(resultado, is(not(empty())));
    }

    @Test
    public void testDadoTengoUnIdentificadorinvalidoEntoncesLaListaDebeSerVacia() {
        String idTransaccion = "456";
        List<String> resultado = personaService.consultarMovientos(idTransaccion);
        assertThat(resultado, is(empty()));
    }


}
