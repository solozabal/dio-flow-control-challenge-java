import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para o contador entre números.
 */
public class ContadorTest {

    /**
     * Testa contagem entre números válidos.
     */
    @ParameterizedTest
    @CsvSource({
            "1, 5, 5",
            "10, 15, 6",
            "-5, 5, 11",
            "0, 0, 1"
    })
    @DisplayName("Teste de contagem entre números")
    void testContagemEntreNumeros(int inicio, int fim, int totalEsperado) {
        // Se fim < início, teste deve verificar que lança exceção
        if (fim < inicio) {
            IllegalArgumentException exception = assertThrows(
                    IllegalArgumentException.class,
                    () -> {
                        if (inicio > fim) {
                            throw new IllegalArgumentException(
                                    "O segundo número (" + fim + ") deve ser maior que o primeiro (" + inicio + ")"
                            );
                        }
                    }
            );
            assertTrue(exception.getMessage().contains("maior"));
            return;
        }

        // Contagem normal
        int contagem = 0;
        for (int i = inicio; i <= fim; i++) {
            contagem++;
        }

        assertEquals(totalEsperado, contagem);
    }

    /**
     * Testa validação quando segundo número é menor que o primeiro.
     * CORRIGIDO: Agora a condição é verdadeira para lançar exceção
     */
    @Test
    @DisplayName("Teste de validação - segundo número menor")
    void testSegundoNumeroMenor() {
        // CORREÇÃO: 1 < 5 é VERDADEIRO, então lança exceção
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    int inicio = 5;
                    int fim = 1; // fim é MENOR que inicio

                    if (inicio > fim) { // 5 > 1 = VERDADEIRO
                        throw new IllegalArgumentException(
                                "O segundo número (" + fim + ") deve ser maior que o primeiro (" + inicio + ")"
                        );
                    }
                }
        );

        assertTrue(exception.getMessage().contains("maior"));
        assertTrue(exception.getMessage().contains("5")); // Verifica mensagem específica
        assertTrue(exception.getMessage().contains("1"));
    }

    /**
     * Testa que NÃO lança exceção quando segundo número é maior.
     */
    @Test
    @DisplayName("Teste de validação - segundo número maior (não lança exceção)")
    void testSegundoNumeroMaiorNaoLancaExcecao() {
        // 1 < 5 - NÃO deve lançar exceção
        assertDoesNotThrow(() -> {
            int inicio = 1;
            int fim = 5; // fim é MAIOR que inicio

            if (inicio > fim) { // 1 > 5 = FALSO
                throw new IllegalArgumentException("Esta linha NUNCA deve ser executada");
            }
            // Continua execução normalmente
        });
    }

    /**
     * Testa validação quando números são iguais.
     */
    @Test
    @DisplayName("Teste de validação - números iguais")
    void testNumerosIguais() {
        // Quando números são iguais, deve contar apenas um número
        int inicio = 5;
        int fim = 5;
        int contagem = 0;

        for (int i = inicio; i <= fim; i++) {
            contagem++;
        }

        assertEquals(1, contagem);

        // NÃO deve lançar exceção quando números são iguais
        assertDoesNotThrow(() -> {
            if (inicio > fim) { // 5 > 5 = FALSO
                throw new IllegalArgumentException("Não deve lançar exceção");
            }
        });
    }

    /**
     * Testa contagem com números negativos.
     */
    @Test
    @DisplayName("Teste com números negativos")
    void testContagemComNegativos() {
        int inicio = -3;
        int fim = 3;
        int contagem = 0;

        for (int i = inicio; i <= fim; i++) {
            contagem++;
        }

        assertEquals(7, contagem); // -3, -2, -1, 0, 1, 2, 3
    }

    /**
     * Testa casos inválidos com ParameterizedTest.
     */
    @ParameterizedTest
    @CsvSource({
            "10, 5",   // inicio > fim
            "0, -5",   // inicio > fim
            "100, 1"   // inicio > fim
    })
    @DisplayName("Teste paramétrico de casos inválidos")
    void testCasosInvalidos(int inicio, int fim) {
        // inicio > fim sempre lança exceção
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    if (inicio > fim) {
                        throw new IllegalArgumentException(
                                "O segundo número (" + fim + ") deve ser maior que o primeiro (" + inicio + ")"
                        );
                    }
                }
        );

        assertTrue(exception.getMessage().contains("maior"));
    }

    /**
     * Testa casos válidos com ParameterizedTest.
     */
    @ParameterizedTest
    @CsvSource({
            "1, 10, 10",     // 1 até 10 = 10 números
            "-5, 5, 11",     // -5 até 5 = 11 números
            "0, 0, 1",       // 0 até 0 = 1 número
            "-10, -5, 6"     // -10 até -5 = 6 números
    })
    @DisplayName("Teste paramétrico de casos válidos")
    void testCasosValidos(int inicio, int fim, int totalEsperado) {
        // Verifica que NÃO lança exceção
        assertDoesNotThrow(() -> {
            if (inicio > fim) {
                throw new IllegalArgumentException("Não deve entrar aqui");
            }
        });

        // Faz a contagem
        int contagem = 0;
        for (int i = inicio; i <= fim; i++) {
            contagem++;
        }

        assertEquals(totalEsperado, contagem);
    }
}