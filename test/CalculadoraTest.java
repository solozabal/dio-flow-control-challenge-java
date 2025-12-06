import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para as operações matemáticas.
 */
public class CalculadoraTest {

    /**
     * Testa a operação de soma com diferentes valores.
     */
    @ParameterizedTest
    @CsvSource({
            "5, 3, 8",
            "10, -5, 5",
            "0, 0, 0",
            "-10, -5, -15",
            "2.5, 3.5, 6.0"
    })
    @DisplayName("Teste de soma com parâmetros")
    void testSoma(double a, double b, double esperado) {
        assertEquals(esperado, a + b, 0.001);
    }

    /**
     * Testa a operação de subtração.
     */
    @Test
    @DisplayName("Teste de subtração básica")
    void testSubtracao() {
        assertEquals(2, 5 - 3);
        assertEquals(-2, 3 - 5);
        assertEquals(0, 5 - 5);
    }

    /**
     * Testa a operação de multiplicação.
     */
    @Test
    @DisplayName("Teste de multiplicação")
    void testMultiplicacao() {
        assertEquals(15, 5 * 3);
        assertEquals(-15, 5 * -3);
        assertEquals(0, 5 * 0);
    }

    /**
     * Testa a operação de divisão válida.
     */
    @Test
    @DisplayName("Teste de divisão válida")
    void testDivisaoValida() {
        assertEquals(2.5, 5.0 / 2.0, 0.001);
        assertEquals(-2.5, -5.0 / 2.0, 0.001);
    }

    /**
     * Testa que divisão por zero com inteiros lança exceção.
     * CORRIGIDO: Usando int para garantir ArithmeticException
     */
    @Test
    @DisplayName("Teste de divisão por zero (inteiros)")
    void testDivisaoPorZeroInteiros() {
        assertThrows(ArithmeticException.class, () -> {
            int a = 5;
            int b = 0;
            int resultado = a / b;  // ArithmeticException: / by zero
        });
    }

    /**
     * Testa que divisão por zero com doubles retorna infinito.
     * CORRIGIDO: Testando comportamento correto para double
     */
    @Test
    @DisplayName("Teste de divisão por zero (doubles)")
    void testDivisaoPorZeroDoubles() {
        double resultado = 5.0 / 0.0;
        assertTrue(Double.isInfinite(resultado));
        assertEquals(Double.POSITIVE_INFINITY, resultado);

        double resultadoNegativo = -5.0 / 0.0;
        assertTrue(Double.isInfinite(resultadoNegativo));
        assertEquals(Double.NEGATIVE_INFINITY, resultadoNegativo);
    }

    /**
     * Testa divisão zero por zero (NaN).
     */
    @Test
    @DisplayName("Teste de divisão 0/0 (NaN)")
    void testDivisaoZeroPorZero() {
        double resultado = 0.0 / 0.0;
        assertTrue(Double.isNaN(resultado));
    }

    /**
     * Testa operações mistas (int/double).
     */
    @Test
    @DisplayName("Teste de operações mistas")
    void testOperacoesMistas() {
        // Int para exceção
        assertThrows(ArithmeticException.class, () -> {
            int x = 10 / 0;
        });

        // Double para infinito
        double y = 10.0 / 0.0;
        assertTrue(Double.isInfinite(y));
    }
}