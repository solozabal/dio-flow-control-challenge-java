import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe principal que representa o menu interativo de exercícios em Java.
 * <p>
 * Esta classe gerencia um sistema de console que permite ao usuário escolher
 * entre diferentes exercícios programáticos, cada um implementando conceitos
 * fundamentais de programação em Java.
 * </p>
 *
 * @author Sistema de Exercícios
 * @version 3.0
 */
public class MainMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static final String ARQUIVO_MENSAGENS = "mensagens_salvas.txt";
    private static final DateTimeFormatter FORMATADOR_DATA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Método principal que inicia a execução do programa.
     * <p>
     * Exibe mensagem de boas-vindas e mantém o menu ativo em loop
     * até que o usuário escolha sair.
     * </p>
     *
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        exibirBoasVindas();

        boolean continuar = true;

        // Estrutura de repetição para manter o menu ativo
        while (continuar) {
            exibirMenu();

            // Validação forte da escolha do menu
            int escolha = lerOpcaoMenu();

            // Processar a escolha do usuário
            switch (escolha) {
                case 1:
                    executarContador();
                    break;
                case 2:
                    executarOperacoesMatematicas();
                    break;
                case 3:
                    executarTabuada();
                    break;
                case 4:
                    executarContadorOriginal();
                    break;
                case 5:
                    executarSalvarMensagem();
                    break;
                case 0:
                    continuar = false;
                    exibirMensagemDespedida();
                    break;
                default:
                    System.out.println("\n⚠️  Opção inválida! Digite um número entre 0 e 5.");
                    break;
            }

            if (continuar) {
                pausarExecucao();
            }
        }

        scanner.close();
        System.out.println("✅ Programa finalizado com sucesso.");
    }

    // ===================== MÉTODOS AUXILIARES DO MENU =====================

    /**
     * Exibe a mensagem de boas-vindas formatada no console.
     */
    private static void exibirBoasVindas() {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║          BEM-VINDO AO MENU DE EXERCÍCIOS         ║");
        System.out.println("║                EM JAVA - VERSÃO 3.0              ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println();
    }

    /**
     * Exibe o menu principal com todas as opções disponíveis.
     */
    private static void exibirMenu() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║                MENU PRINCIPAL                    ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║  1. 📊 Contador entre números                    ║");
        System.out.println("║  2. 🧮 Operações Matemáticas Básicas             ║");
        System.out.println("║  3. 🔢 Tabuada                                   ║");
        System.out.println("║  4. ⚙️  Exercício Contador Original              ║");
        System.out.println("║  5. 💾 Salvar Mensagem em Arquivo                ║");
        System.out.println("║  0. 🚪 Sair                                      ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    /**
     * Lê e valida a opção do menu digitada pelo usuário.
     * <p>
     * Continua solicitando entrada até que um valor válido seja fornecido.
     * </p>
     *
     * @return Opção válida do menu (0-5)
     */
    private static int lerOpcaoMenu() {
        while (true) {
            try {
                System.out.print("\n📝 Digite sua escolha: ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer

                if (escolha >= 0 && escolha <= 5) {
                    return escolha;
                } else {
                    System.out.println("⚠️  Opção inválida! Digite um número entre 0 e 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite apenas números (0-5).");
                scanner.nextLine(); // Limpar buffer inválido
            }
        }
    }

    /**
     * Pausa a execução aguardando o usuário pressionar Enter.
     */
    private static void pausarExecucao() {
        System.out.print("\n⏎  Pressione Enter para continuar...");
        scanner.nextLine();
    }

    /**
     * Exibe mensagem de despedida quando o usuário sai do programa.
     */
    private static void exibirMensagemDespedida() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║            OBRIGADO POR UTILIZAR                 ║");
        System.out.println("║          NOSSO MENU DE EXERCÍCIOS!               ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    // ===================== MÉTODOS DOS EXERCÍCIOS =====================

    /**
     * Exercício 1: Contador entre dois números.
     * <p>
     * Solicita dois números inteiros ao usuário e conta todos os números
     * entre eles, incluindo os extremos. Valida que o segundo número seja
     * maior que o primeiro.
     * </p>
     */
    private static void executarContador() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║         📊 CONTADOR ENTRE NÚMEROS                ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // Solicitar e validar o primeiro número
        int numero1 = lerNumeroInteiro("Digite o primeiro número: ");

        // Solicitar e validar o segundo número com validação adicional
        int numero2;
        while (true) {
            numero2 = lerNumeroInteiro("Digite o segundo número: ");

            if (numero2 > numero1) {
                break;
            } else if (numero2 == numero1) {
                System.out.println("⚠️  O segundo número não pode ser igual ao primeiro!");
                System.out.println("   Por favor, digite um número diferente.");
            } else {
                System.out.println("⚠️  O segundo número deve ser MAIOR que o primeiro!");
                System.out.println("   Por favor, digite novamente.");
            }
        }

        // Executar a contagem
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("🔢 Contando de " + numero1 + " até " + numero2 + ":");
        System.out.println("══════════════════════════════════════════════════");

        int totalNumeros = 0;
        for (int i = numero1; i <= numero2; i++) {
            System.out.println("   Número: " + i);
            totalNumeros++;
        }

        System.out.println("══════════════════════════════════════════════════");
        System.out.println("📈 Total de números contados: " + totalNumeros);
        System.out.println("══════════════════════════════════════════════════");
    }

    /**
     * Exercício 2: Operações Matemáticas Básicas.
     * <p>
     * Permite ao usuário escolher entre quatro operações matemáticas
     * (soma, subtração, multiplicação, divisão) e realizar o cálculo
     * com dois números fornecidos. Trata divisão por zero.
     * </p>
     */
    private static void executarOperacoesMatematicas() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║         🧮 OPERAÇÕES MATEMÁTICAS                 ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // Exibir menu de operações
        System.out.println("\nSelecione a operação desejada:");
        System.out.println("  1. ➕ Soma (+)");
        System.out.println("  2. ➖ Subtração (-)");
        System.out.println("  3. ✖️  Multiplicação (*)");
        System.out.println("  4. ➗ Divisão (/)");

        // Solicitar operação com validação
        int operacao;
        while (true) {
            operacao = lerNumeroInteiro("\n📝 Digite o número da operação (1-4): ");
            if (operacao >= 1 && operacao <= 4) {
                break;
            }
            System.out.println("⚠️  Operação inválida! Digite um número entre 1 e 4.");
        }

        // Solicitar os operandos
        System.out.println("\n─── DIGITE OS NÚMEROS PARA A OPERAÇÃO ───");
        double num1 = lerNumeroDecimal("Primeiro número: ");
        double num2 = lerNumeroDecimal("Segundo número: ");

        // Executar operação selecionada
        double resultado;
        String simbolo = "";
        boolean operacaoValida = true;

        try {
            switch (operacao) {
                case 1: // Soma
                    resultado = num1 + num2;
                    simbolo = "+";
                    break;
                case 2: // Subtração
                    resultado = num1 - num2;
                    simbolo = "-";
                    break;
                case 3: // Multiplicação
                    resultado = num1 * num2;
                    simbolo = "×";
                    break;
                case 4: // Divisão
                    if (Math.abs(num2) < 0.000001) { // Evita divisão por zero
                        throw new ArithmeticException("Divisão por zero não é permitida!");
                    }
                    resultado = num1 / num2;
                    simbolo = "÷";
                    break;
                default:
                    resultado = 0;
                    operacaoValida = false;
            }

            if (operacaoValida) {
                System.out.println("\n══════════════════════════════════════════════════");
                System.out.println("🧮 RESULTADO DA OPERAÇÃO:");
                System.out.printf("   %.2f %s %.2f = %.2f\n", num1, simbolo, num2, resultado);
                System.out.println("══════════════════════════════════════════════════");
            }

        } catch (ArithmeticException e) {
            System.out.println("\n❌ ERRO MATEMÁTICO: " + e.getMessage());
            System.out.println("   Por favor, tente novamente com valores válidos.");
        }
    }

    /**
     * Exercício 3: Tabuada.
     * <p>
     * Solicita um número inteiro ao usuário e exibe sua tabuada
     * completa de 1 a 10. Oferece opção de visualização adicional
     * usando diferentes estruturas de loop.
     * </p>
     */
    private static void executarTabuada() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║                 🔢 TABUADA                       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        int numero = lerNumeroInteiro("Digite um número inteiro para ver sua tabuada: ");

        // Tabuada usando for
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("📊 TABUADA DO " + numero + " (usando FOR):");
        System.out.println("══════════════════════════════════════════════════");

        for (int i = 1; i <= 10; i++) {
            System.out.printf("   %2d × %2d = %3d\n", numero, i, numero * i);
        }

        System.out.println("══════════════════════════════════════════════════");

        // Opção para ver com while
        if (lerRespostaSimNao("\n📝 Deseja ver a tabuada usando WHILE também? (S/N): ")) {
            System.out.println("\n══════════════════════════════════════════════════");
            System.out.println("📊 TABUADA DO " + numero + " (usando WHILE):");
            System.out.println("══════════════════════════════════════════════════");

            int i = 1;
            while (i <= 10) {
                System.out.printf("   %2d × %2d = %3d\n", numero, i, numero * i);
                i++;
            }

            System.out.println("══════════════════════════════════════════════════");
        }
    }

    /**
     * Exercício 4: Contador Original (fornecido).
     * <p>
     * Implementa a lógica original do exercício Contador, mantendo
     * o comportamento e validações conforme especificado.
     * </p>
     */
    private static void executarContadorOriginal() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║         ⚙️  CONTADOR ORIGINAL                     ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        System.out.println("\nEste exercício implementa a versão original do Contador.");
        System.out.println("──────────────────────────────────────────────────────");

        int parametroUm = lerNumeroInteiro("Digite o primeiro parâmetro: ");

        int parametroDois;
        while (true) {
            parametroDois = lerNumeroInteiro("Digite o segundo parâmetro: ");

            if (parametroDois > parametroUm) {
                break;
            }
            System.out.println("⚠️  O segundo parâmetro deve ser maior que o primeiro!");
            System.out.println("   Por favor, digite novamente.");
        }

        // Executar contagem conforme lógica original
        int contagem = parametroDois - parametroUm;
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("🖨️  IMPRIMINDO OS NÚMEROS:");
        System.out.println("══════════════════════════════════════════════════");

        for (int i = 1; i <= contagem; i++) {
            System.out.println("   Imprimindo o número " + i);
        }

        System.out.println("══════════════════════════════════════════════════");
        System.out.println("✅ Contagem concluída! Total: " + contagem + " números.");
        System.out.println("══════════════════════════════════════════════════");
    }

    /**
     * Exercício 5: Salvar Mensagem em Arquivo (Serialização).
     * <p>
     * Permite ao usuário escrever uma mensagem personalizada que será
     * salva em um arquivo de texto (.txt). Inclui data/hora da gravação
     * e tratamento de exceções de escrita.
     * </p>
     */
    private static void executarSalvarMensagem() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║         💾 SALVAR MENSAGEM EM ARQUIVO            ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        System.out.println("\nDigite sua mensagem pessoal (máximo 500 caracteres):");
        System.out.println("(Pressione Enter em uma linha vazia para finalizar)");
        System.out.println("══════════════════════════════════════════════════");

        StringBuilder mensagemCompleta = new StringBuilder();
        String linha;
        int contadorLinhas = 0;

        // Coletar múltiplas linhas de texto
        while (contadorLinhas < 10) { // Limite de 10 linhas
            System.out.print("Linha " + (contadorLinhas + 1) + ": ");
            linha = scanner.nextLine();

            if (linha.trim().isEmpty() && contadorLinhas > 0) {
                break; // Linha vazia encerra a entrada
            }

            if (mensagemCompleta.length() + linha.length() > 500) {
                System.out.println("⚠️  Limite de 500 caracteres atingido!");
                break;
            }

            mensagemCompleta.append(linha).append("\n");
            contadorLinhas++;
        }

        String mensagemFinal = mensagemCompleta.toString().trim();

        if (mensagemFinal.isEmpty()) {
            System.out.println("\n❌ Nenhuma mensagem foi digitada. Operação cancelada.");
            return;
        }

        // Salvar a mensagem no arquivo
        try {
            salvarMensagemNoArquivo(mensagemFinal);
            System.out.println("\n══════════════════════════════════════════════════");
            System.out.println("✅ MENSAGEM SALVA COM SUCESSO!");
            System.out.println("══════════════════════════════════════════════════");
            System.out.println("📁 Arquivo: " + ARQUIVO_MENSAGENS);
            System.out.println("📝 Caracteres salvos: " + mensagemFinal.length());
            System.out.println("📊 Linhas salvas: " + contadorLinhas);
            System.out.println("══════════════════════════════════════════════════");
        } catch (IOException e) {
            System.out.println("\n❌ ERRO AO SALVAR A MENSAGEM:");
            System.out.println("   " + e.getMessage());
            System.out.println("   Verifique as permissões do diretório.");
        }
    }

    /**
     * Salva uma mensagem no arquivo de texto.
     * <p>
     * Adiciona automaticamente data/hora e separadores para
     * facilitar a leitura posterior.
     * </p>
     *
     * @param mensagem A mensagem a ser salva no arquivo
     * @throws IOException Se ocorrer um erro de escrita no arquivo
     */
    private static void salvarMensagemNoArquivo(String mensagem) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_MENSAGENS, true))) {
            String dataHoraAtual = LocalDateTime.now().format(FORMATADOR_DATA);

            // Adicionar separador e cabeçalho
            writer.println("\n" + "=".repeat(60));
            writer.println("MENSAGEM SALVA EM: " + dataHoraAtual);
            writer.println("-".repeat(60));

            // Escrever a mensagem
            writer.println(mensagem);

            // Adicionar rodapé
            writer.println("-".repeat(60));
            writer.println("FIM DA MENSAGEM");
            writer.println("=".repeat(60));

            writer.flush(); // Garantir que os dados sejam escritos
        }
    }

    // ===================== MÉTODOS AUXILIARES DE VALIDAÇÃO =====================

    /**
     * Lê e valida um número inteiro da entrada do usuário.
     * <p>
     * Continua solicitando até que um número inteiro válido seja fornecido.
     * </p>
     *
     * @param mensagem Mensagem a ser exibida solicitando a entrada
     * @return Número inteiro validado
     */
    private static int lerNumeroInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print("📝 " + mensagem);
                int numero = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite um número inteiro.");
                scanner.nextLine(); // Limpar buffer inválido
            }
        }
    }

    /**
     * Lê e valida um número decimal (double) da entrada do usuário.
     * <p>
     * Continua solicitando até que um número decimal válido seja fornecido.
     * </p>
     *
     * @param mensagem Mensagem a ser exibida solicitando a entrada
     * @return Número decimal validado
     */
    private static double lerNumeroDecimal(String mensagem) {
        while (true) {
            try {
                System.out.print("📝 " + mensagem);
                double numero = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida! Digite um número válido (ex: 10, 3.14, -5).");
                scanner.nextLine(); // Limpar buffer inválido
            }
        }
    }

    /**
     * Lê e valida uma resposta Sim/Não do usuário.
     *
     * @param mensagem Mensagem a ser exibida solicitando a resposta
     * @return true se resposta for Sim, false se for Não
     */
    private static boolean lerRespostaSimNao(String mensagem) {
        while (true) {
            System.out.print("📝 " + mensagem);
            String resposta = scanner.nextLine().trim().toUpperCase();

            if (resposta.equals("S") || resposta.equals("SIM")) {
                return true;
            } else if (resposta.equals("N") || resposta.equals("NÃO") || resposta.equals("NAO")) {
                return false;
            } else {
                System.out.println("⚠️  Resposta inválida! Digite 'S' para Sim ou 'N' para Não.");
            }
        }
    }
}