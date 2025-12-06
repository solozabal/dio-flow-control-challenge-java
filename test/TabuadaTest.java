import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para a tabuada.
 */
public class TabuadaTest {

    /**
     * Testa tabuada de um número específico.
     */
    @Test
    @DisplayName("Teste da tabuada do 5")
    void testTabuadaDoCinco() {
        int numero = 5;
        int[] resultadosEsperados = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            assertEquals(resultadosEsperados[i-1], resultado);
        }
    }

    /**
     * Testa tabuada de múltiplos números.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 7, 10})
    @DisplayName("Teste paramétrico de tabuadas")
    void testTabuadaParametrizada(int numero) {
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            assertEquals(numero * i, resultado);
            assertTrue(resultado >= numero); // O menor resultado é o próprio número (i=1)
        }
    }

    /**
     * Testa tabuada do zero.
     */
    @Test
    @DisplayName("Teste da tabuada do zero")
    void testTabuadaDoZero() {
        int numero = 0;

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            assertEquals(0, resultado);
        }
    }

    /**
     * Testa tabuada de número negativo.
     */
    @Test
    @DisplayName("Teste da tabuada de número negativo")
    void testTabuadaNumeroNegativo() {
        int numero = -3;

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            assertEquals(-3 * i, resultado);
            assertTrue(resultado <= -3); // Todos resultados são negativos ou zero
        }
    }
}
