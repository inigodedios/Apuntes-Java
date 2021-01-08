import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest {
    //https://www.jetbrains.com/help/idea/testing.html#create-test-resources-root

    /*ANOTACIONES
     *@Test
     *Marcaremos con la anotación @Test los métodos que queramos que JUnit ejecute.
     *Estos serán los métodos en los que implementemos nuestras pruebas.
     *
     * @Before
     *El método se ejecutará antes de cada prueba (antes de ejecutar cada uno de los métodos marcados con @Test).
     * Será útil para inicializar los datos de entrada y de salida esperada que se vayan a utilizar en las pruebas.
     *
     *@After
     *Se ejecuta después de cada test. Nos servirá para liberar recursos que se hubiesen inicializado en el
     * método marcado con @Before.
     *
     *@BeforeClass
     *Se ejecuta una sola vez antes de ejecutar todos los tests de la clase. Se utilizarán para crear estructuras de
     * datos y componentes que vayan a ser necesarios para todas las pruebas. Los métodos marcados con esta anotación
     *
     *@AfterClass
     * Se ejecuta una única vez después de todos los tests de la clase. Nos servirá para liberar los recursos
     * inicializados en el método marcado con @BeforeClass, y al igual que este último, sólo se puede aplicar
     * a métodos estáticos.
     *
     * @Ignore
     * Indica a JUnit que el método de test está deshabilitado. Útil cuando el código ha cambiado sustancialmente y el
     * test no está adaptado. Es de buena práctica indicar el motivo de por qué se ha deshabilitado.
     *
     *(expected = NullPointerException.class)
     * Se pone al lado del @X para definir que es lo que esperamos exactamente
     * @Test(expected = NullPointerException.class) MUY IMPORTANTE
     */

    /*
     * assertTrue([mensaje], condición booleana); --> Mensaje + Comprueba que la condición sea verdadera
     * assertFalse([mensaje], condición booleana); --> Mensaje + Comprueba que la condición sea falsa.
     * assertEquals([mensaje], valor esperado, valor actual); --> Mensaje + Comprueba que dos valores sean iguales. Nota: en arrays comprueba su referencia, no el contenido!)
     * assertSame([mensaje], valor esperado, valor actual); --> Mensaje + Comprueba que ambos parámetros sean el mismo objeto.
     * assertNotSame([mensaje], valor esperado, valor actual); --> Mensaje + Comprueba que ambos parámetros no sean el mismo objeto.
     * assertNull([mensaje], objeto); --> Mensaje + Comprueba que el objeto sea nulo.
     * assertNotNull([mensaje], objeto); --> Mensaje + Comprueba que el objeto no sea nulo.
     * fail([mensaje]); --> Hace que el método falle. Debería ser utilizado solo para comprobar que una parte del código de test no se ejecute o para hacer fallar un test no implementado.
     */

    //Prueba
    @Test
    public void test1() {
        assertEquals('c', 'i');
    }

   @Test
   public void test2(){
       assertEquals('c', 'c');
   }


}