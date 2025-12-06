# 🚦 Java Flow Control Interactive Challenge

![Java](https://img.shields.io/badge/Java-17%2B-blue.svg)
![JUnit](https://img.shields.io/badge/JUnit-5-orange.svg)
![Platform](https://img.shields.io/badge/Cross--Platform-Terminal%2FConsole-informational)
![License](https://img.shields.io/badge/license-MIT-yellow.svg)

> ***Take your next step in Java mastery!***  
> _A polished, interactive, and test-driven Java challenge for anyone who wants to prove understanding of basic control flow, input handling, and unit testing. Perfect for technical interviews, bootcamp spotlights, and learning portfolios._

---

## 🧩 **Features**

- **Interactive Menu System**: Friendly, guided, emoji-enhanced CLI experience.
- **Robust Input Validation**: Never lets a bad input ruin the fun!
- **Modular Exercises**:
    - Counter (between two numbers, with custom Java exceptions)
    - Basic Math Operations (add, subtract, multiply, divide, with zero/infinity checks)
    - Multiplication Table (for any integer, using both `for` and `while`)
    - Original Counter Mode (as per challenge instructions)
    - File Persistence: Save custom user messages, timestamped
- **Test-Driven Development**: 100% unit test coverage using JUnit 5.

---

## 🏗️ **Project Structure**

```text
dio-flow-control-challenge-java/
│
├── src/
│    ├── Contador.java
│    ├── MainMenu.java
│    └── ParametrosInvalidosException.java
├── test/
│    ├── ArquivoUtilTest.java
│    ├── CalculadoraTest.java
│    ├── ContadorTest.java
│    ├── TabuadaTest.java
│    └── ValidadorTest.java
├── mensagens_salvas.txt
├── README.md
```

---

## 🦾 **How Does It Work?**

### Main Menu

Just launch `MainMenu.java` via your IDE or terminal:
```sh
javac MainMenu.java
java MainMenu
```
You’ll see a rich menu like:
```text
╔══════════════════════════════════════════════════╗
║          BEM-VINDO AO MENU DE EXERCÍCIOS         ║
║                EM JAVA - VERSÃO 3.0              ║
╚══════════════════════════════════════════════════╝


╔══════════════════════════════════════════════════╗
║                MENU PRINCIPAL                    ║
╠══════════════════════════════════════════════════╣
║  1. 📊 Contador entre números                    ║
║  2. 🧮 Operações Matemáticas Básicas             ║
║  3. 🔢 Tabuada                                   ║
║  4. ⚙️  Exercício Contador Original              ║
║  5. 💾 Salvar Mensagem em Arquivo                ║
║  0. 🚪 Sair                                      ║
╚══════════════════════════════════════════════════╝

📝 Digite sua escolha: 
```

### Counting Example

Try counting from any `A` to `B`:
> First: `2`, Second: `7`  
> Prints:  
> `Number: 2, Number: 3, ..., Number: 7`  
> Handles errors in style if input is wrong.

### Save Messages

Write and persist your favorite quotes or notes!  
They’ll be timestamped and saved to `mensagens_salvas.txt`.

```text
============================================================
MENSAGEM SALVA EM: 06/12/2025 17:29:50
------------------------------------------------------------
ExecutionTest
------------------------------------------------------------
FIM DA MENSAGEM
============================================================

```
---

## ⚙️ **Run the Tests**

All exercises are professionally covered by JUnit 5!
```sh
# If you use Maven, place tests in src/test/java and run:
mvn test

# Or, run with your IDE: just right-click the test files and Run
```

---

## 🤝 **Contributing**

Pull requests, issues, and ideas are warmly welcomed!  
**Let’s keep the code clean, test-covered, and educational.**

---

## 📄 **License**

Licensed under the [MIT License](LICENSE).

---

<p align="center">
  <a href="https://www.linkedin.com/in/pedrosolozabal/">
    <img src="https://img.shields.io/badge/Pedro%20Solozabal-LinkedIn-blue?logo=linkedin&logoColor=white&style=for-the-badge" alt="Pedro Solozabal on LinkedIn">
  </a>
</p>