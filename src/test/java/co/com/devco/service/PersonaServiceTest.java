package co.com.devco.service;

import static org.mockito.Mockito.spy;

import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(JUnitParamsRunner.clasconsultarMovientoss)
//@RunWith(SpringRunner.class)
//@PrepareForTest({EtapaService.class, ActividadService.class, PersonaService.class})

@RunWith(PowerMockRunner.class)
@PrepareForTest({PersonaService.class, EtapaService.class, ActividadService.class})
public class PersonaServiceTest {

/*
    @Mock
    private EtapaService mockEtapaService;

    @Mock
    private ActividadService mockActividadService;*/


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private Logger logger;


    @InjectMocks
    PersonaService personaService = spy(new PersonaService());

    @Before
    public void setup() {
        //mockStatic(ActividadService.class, EtapaService.class, PersonaService.class);
        //mockStatic(Control.class);
    }


    /*@Test
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
    }*/

   /* @Test
    public void testCuandoMiEdadEsCeroEntoncesElArregloDeberiTenerLlorar(){
        String[] actividadesInfancia = {"Correr", "Saltar", "Ir a piscina", "Llorar"};
        when(mockEtapaService.obtenerEtapaDeVida(anyInt())).thenReturn(INFANCIA);
        when(mockActividadService.obtenerActividades(Matchers.any())).thenReturn(actividadesInfancia);
        int edad = 0;
        String[] resultado = personaService.obtenerActividadesPorEdad(edad);
        assertThat(resultado, not(emptyArray()));
        assertThat(resultado, hasItemInArray("Llorar"));
    }


   @Test
    public void testCuandoLaPersonaEsNulaEntoncesDebeResponderUnaExcepcion() throws Exception {
      try {
          String resultado = personaService.presentarPersona(null);
          fail("no debe llegar aqui");
      }catch (Exception ex){
          assertEquals("persona no valida", ex.getMessage());
      }
   }*/


   /* @Test
    public void testCuandoLaPersonaEsNulaEntoncesDebeResponderUnaExcepcion() throws Exception {
        try {
            String resultado = personaService.presentarPersona(null);
            fail("no debe llegar aqui");
        } catch (Exception ex) {
            assertEquals("persona no valida", ex.getMessage());
        }
    }

    @Test
    public void testCuandoElNombreDelaPersonaEsNuloEntoncesDebeResponderUnaExcepcion() throws Exception {
        try {
            persona = Persona.builder().build();
            String resultado = personaService.presentarPersona(persona);
            fail("no debe llegar aqui");
        } catch (Exception ex) {
            assertEquals("el nombre de la persona es requerido", ex.getMessage());
        }
    }

    @Test
    public void testCuandoElNombreDelaPersonaEsVacioEntoncesDebeResponderUnaExcepcion() throws Exception {
        try {
            persona = Persona.builder().nombre("").build();
            String resultado = personaService.presentarPersona(persona);
            fail("no debe llegar aqui");
        } catch (Exception ex) {
            assertEquals("el nombre de la persona es requerido", ex.getMessage());
        }
    }

    @Test
    public void testCuandoElApellidoDelaPersonaEsNuloEntoncesDebeResponderUnaExcepcion() throws Exception {
        try {
            persona = Persona.builder().nombre("johan").build();
            String resultado = personaService.presentarPersona(persona);
            fail("no debe llegar aqui");
        } catch (Exception ex) {
            assertEquals("el apellido de la persona es requerido", ex.getMessage());
        }
    }

    @Test
    public void testCuandoLaEdadDeLaPersonaEsCeroEntoncesDebeResponderUnaExcepcion() throws Exception {
        try {
            persona = Persona.builder().nombre("johan").apelido("beltran").edad(0).build();
            String resultado = personaService.presentarPersona(persona);
            fail("no debe llegar aqui");
        } catch (Exception ex) {
            assertEquals("la edad de la persona no es valida", ex.getMessage());
        }
    }

    @Test
    public void testCuandoTodosLosDatosDeUnaPersonaSonCorrectoEntoncesDebeRetornar() throws Exception {
        persona = Persona.builder().nombre("johan").apelido("beltran").edad(10).build();
        String resultado = personaService.presentarPersona(persona);
        assertEquals("Hola, soy johan beltran de edad: 10", resultado);
    }

    @Test
    public void testCuandoEsUnaEdadValidaEntoncesDeboObtenerElAnioDeNacimiento() throws Exception {
        when(personaService.obtenerAnioActual()).thenReturn(2018);
        int anioNacimiento = personaService.calcularAnioNacimiento(30);
        assertEquals(1988, anioNacimiento);
    }


    @Test
    public void testCuandoMiEdadEsCeroEntoncesElArregloDeberiTenerLlorar() {
        String[] actividadesInfancia = {"Correr", "Saltar", "Ir a piscina", "Llorar"};
        when(EtapaService.obtenerEtapaDeVida(anyInt())).thenReturn(INFANCIA);
        when(ActividadService.obtenerActividades(Matchers.any())).thenReturn(actividadesInfancia);
        int edad = 0;
        String[] resultado = personaService.obtenerActividadesPorEdad(edad);
        Assert.assertTrue(resultado.length > 0);
    }

    @Test
    public void testCuandoEsUnaEdadValidaEntoncesDeboObtenerElAnioDeNacimiento() throws Exception {
        when(PersonaService.obtenerAnioActual()).thenReturn(2018);
        int anioNacimiento = personaService.calcularAnioNacimiento(30);
        Assert.assertTrue(anioNacimiento == 1988);
    }

   @Test
    public void testCuandoCalcularSalarioEsMilEntoncesSalarioEs(){
       ArgumentCaptor<Integer> salarioBasicoDiaCaptor = ArgumentCaptor.forClass(Integer.class);
       ArgumentCaptor<Integer> salarioBasicoMesCaptor = ArgumentCaptor.forClass(Integer.class);

       int resultado = personaService.calcularSalario(1000);

       verify(personaService).calcularSalarioMes(salarioBasicoDiaCaptor.capture());
       int salarioMes = salarioBasicoDiaCaptor.getValue();
       verify(personaService).calcularSalarioMes(salarioMes);

   }



    private static final Object[] obtenerDatosDePersonaIncorrectaPorNombre() {
        return new Object[] {
                new Object[] {"", "Beltran", 10},
                new Object[] {null, "Beltran", 10}
        };
    }

    @Test
    @Parameters(method = "obtenerDatosDePersonaIncorrectaPorNombre")
    public void testCuandoUnaPersonaTieneElNombreIncorrectoEntoncesDebeResponder(String nombre, String apellido, int edad){
        try{
            Persona persona = Persona.builder().nombre(nombre).apelido(apellido).edad(edad).build();
            personaService.presentarPersona(persona);
        }catch (Exception ex){
            Assert.assertEquals("el nombre de la persona es requerido", ex.getMessage());
        }
    }

   @Test
    public void testCuandoSeGuardarUnaPersonaSuEdadSeraCuarenta(){
       doAnswer(new Answer<Void>() {
           @Override
           public Void answer(InvocationOnMock invocationOnMock) throws Throwable {
               Persona persona = invocationOnMock.getArgumentAt(0, Persona.class);
               persona.setEdad(40);
               return null;
           }
       }).when(personaService).establecerEdad(any(Persona.class));

       personaService.guardarPersona("Johan", "Beltran");
       verify(logger).info("la edad de la persona es {}", 40);
   }


   @Test
    public void testProbarInicializacionConNulo() throws Exception {

       Control mockControl = mock(Control.class);
       whenNew(Control.class).withAnyArguments().thenReturn(mockControl);

      Control mockActual =  personaService.obtenerInicializacionDePersona();

       MatcherAssert.assertThat(mockActual, org.hamcrest.Matchers.is(mockControl));

   }

   @Test
    public void testCuandoMiEdadEsCeroEntoncesElArregloDeberiTenerLlorar() {
        ArgumentCaptor<EtapaVida> etapaVidaCaptor = ArgumentCaptor.forClass(EtapaVida.class);
        String[] actividadesInfancia = {"Correr", "Saltar", "Ir a piscina", "Llorar"};
        when(EtapaService.obtenerEtapaDeVida(anyInt())).thenReturn(INFANCIA);
        when(ActividadService.obtenerActividades(Matchers.any())).thenReturn(actividadesInfancia);
        int edad = 0;
        String[] resultado = personaService.obtenerActividadesPorEdad(edad);
        Assert.assertTrue(resultado.length > 0);

        verifyStatic();
        ActividadService.obtenerActividades(etapaVidaCaptor.capture());
        EtapaVida etapaVida = etapaVidaCaptor.getValue();
        //verifyStatic();
        ActividadService.obtenerActividades(etapaVida);
    }




    @Test
    public void testProbarInicializacionConNulo() throws Exception {

        Control mockControl = PowerMockito.mock(Control.class);
        whenNew(Control.class).withAnyArguments().thenReturn(mockControl);

        Control mockActual =  PersonaService.obtenerInicializacionDePersona();

        MatcherAssert.assertThat(mockActual, org.hamcrest.Matchers.is(mockControl));

    }*/

    @Test
    public void testProbar() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("persona no valida");
        personaService.presentarPersona(null);
    }

}
