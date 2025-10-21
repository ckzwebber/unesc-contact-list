# Agenda de Contatos em Java

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/)
[![CLI](https://img.shields.io/badge/Interface-CLI-4EAA25?style=for-the-badge&logo=gnubash&logoColor=white)]()
[![I/O de Arquivos](https://img.shields.io/badge/Persist%C3%AAncia-Arquivos-blue?style=for-the-badge)]()

Bem-vindo ao repositório unesc-contact-list em Java!  
Uma aplicação de linha de comando para gerenciar contatos com importação/exportação de arquivos simples.

---

## ✨ Funcionalidades

- ✅ Importar contatos de arquivo (`nome&telefone&endereco`)
- ✅ Exportar contatos para arquivo
- ✅ Inserir contato
- ✅ Remover contato por telefone
- ✅ Remover contato por nome
- ✅ Localizar contato por nome
- ✅ Localizar contato por telefone
- ✅ Listar todos os contatos
- ✅ Realizar chamada (simulação)
- ✅ Limpar agenda

> Observação: contatos são armazenados em memória durante a execução. Use “Exportar” para salvar em disco.

---

## 🛠️ Tecnologias e Conceitos

- **Java 8+**
- **Coleções Java** (`Map`, `HashMap`)
- **I/O** (`BufferedReader`, `BufferedWriter`, `FileReader`, `FileWriter`, try-with-resources)
- **Entrada de dados** com `Scanner`
- **POO**: `Contato` (modelo), `Agenda` (regras de negócio/persistência), `Main` (CLI)
- Sem dependências externas

---

## 📁 Estrutura do Projeto

```
agenda-contatos-file/
│
├── src/
│   ├── Main.java      # Interface de linha de comando (menu)
│   ├── Agenda.java    # Operações de agenda + import/export de arquivos
│   └── Contato.java   # Modelo de dados do contato
│
└── .idea/             # Configurações da IDE (opcional)
```

---

## 📄 Formato de Importação/Exportação

- Uma linha por contato
- Delimitador: `&`
- Ordem dos campos: `nome & telefone & endereco`
- Restrições de validação:
  - `nome` até 30 caracteres
  - `telefone` com exatamente 11 dígitos
  - `endereco` até 100 caracteres
- Linhas inválidas são ignoradas e reportadas no console.

Exemplo de arquivo:

```
Joao Silva&47999999999&Rua A, 123
Maria Souza&47988888888&Avenida B, 456
```

---

## 🚀 Como Executar

### Pré-requisitos

- JDK 8 ou superior
- Terminal (bash/zsh/cmd/powershell)

### Passos

```bash
# (Opcional) Clone o repositório
# git clone <URL-DO-REPOSITORIO>
# cd agenda-contatos-file

# Compile os arquivos para a pasta out/
javac -d out src/*.java

# Execute a aplicação
java -cp out Main
```

Ao iniciar, você verá o menu interativo:

```
--- AGENDA DE CONTATOS ---
1 - Importar Contatos
2 - Exportar Contatos
3 - Inserir Contato
4 - Remover Contato (Telefone)
5 - Remover Contato (Nome)
6 - Localizar Contato (Nome)
7 - Localizar Contato (Telefone)
8 - Listar Todos os Contatos
9 - Realizar Chamada
10 - Limpar Agenda
11 - Sair
```

---

## 🧪 Dicas de Teste Manual

- Use “Inserir Contato” e depois “Listar” para validar criação
- Tente importar um arquivo com linhas inválidas para ver as mensagens de erro
- Teste a “Remoção” e as buscas por nome/telefone
- Antes de sair, “Exportar” para salvar seus contatos em arquivo

---

## 👤 Autor

Desenvolvido por [Carlos Miguel Webber](https://www.linkedin.com/in/cmiguelwm/).  
Sugestões e colaborações são bem-vindas!

---

## 📄 Licença

Nenhuma licença definida no repositório.  
Se desejar, adicione um arquivo `LICENSE` e atualize este README.
