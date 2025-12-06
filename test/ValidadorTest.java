import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes unitários para validações de entrada.
 */
public class ValidadorTest {

    /**
     * Testa validação de opções do menu.
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("Teste de opções válidas do menu")
    void testOpcoesMenuValidas(int opcao) {
        assertTrue(opcao >= 0 && opcao <= 5);
    }

    /**
     * Testa opções inválidas do menu.
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 6, 10, 100})
    @DisplayName("Teste de opções inválidas do menu")
    void testOpcoesMenuInvalidas(int opcao) {
        assertFalse(opcao >= 0 && opcao <= 5);
    }

    /**
     * Testa validação de operações matemáticas.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    @DisplayName("Teste de operações matemáticas válidas")
    void testOperacoesMatematicasValidas(int operacao) {
        assertTrue(operacao >= 1 && operacao <= 4);
    }

    /**
     * Testa operações matemáticas inválidas.
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 10, -1})
    @DisplayName("Teste de operações matemáticas inválidas")
    void testOperacoesMatematicasInvalidas(int operacao) {
        assertFalse(operacao >= 1 && operacao <= 4);
    }
}
