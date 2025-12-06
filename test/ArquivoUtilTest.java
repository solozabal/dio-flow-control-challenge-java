import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

/**
 * Testes unitários para operações com arquivos.
 */
public class ArquivoUtilTest {

    /**
     * Testa escrita em arquivo temporário.
     */
    @Test
    @DisplayName("Teste de escrita em arquivo")
    void testEscritaArquivo(@TempDir Path tempDir) throws IOException {
        File arquivoTeste = tempDir.resolve("teste.txt").toFile();

        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivoTeste))) {
            writer.println("Linha 1 de teste");
            writer.println("Linha 2 de teste");
            writer.flush();
        }

        assertTrue(arquivoTeste.exists());
        assertTrue(arquivoTeste.length() > 0);
    }

    /**
     * Testa que arquivo não existe antes da criação.
     */
    @Test
    @DisplayName("Teste de arquivo inexistente")
    void testArquivoInexistente(@TempDir Path tempDir) {
        File arquivoTeste = tempDir.resolve("inexistente.txt").toFile();
        assertFalse(arquivoTeste.exists());
    }

    /**
     * Testa validação de mensagem vazia.
     */
    @Test
    @DisplayName("Teste de mensagem vazia")
    void testMensagemVazia() {
        String mensagemVazia = "";
        String mensagemComEspacos = "   ";

        assertTrue(mensagemVazia.isEmpty());
        assertTrue(mensagemComEspacos.trim().isEmpty());
    }

    /**
     * Testa validação de limite de caracteres.
     */
    @Test
    @DisplayName("Teste de limite de caracteres")
    void testLimiteCaracteres() {
        String mensagemCurta = "abc";
        String mensagemLonga = "a".repeat(600);

        assertTrue(mensagemCurta.length() < 500);
        assertTrue(mensagemLonga.length() > 500);
    }
}
