# 🎓 GUIA PRÁTICO - O QUE VOCÊ PRECISA FAZER

Aqui está um roteiro **passo a passo** para você refatorar seu código e aprender no processo!

---

## 📝 PASSO 1: REFATORAR User.java

### O que você precisa fazer:

1. **Renomear as variáveis:**
   - `id_user` → `id`
   - `data_nascimento` → `dataNascimento`
   - `nome` → manter igual (já está bom)

2. **Renomear os métodos getters:**
   - `pegar_nome()` → `getNome()`
   - `pegar_nascimento()` → `getDataNascimento()`
   - `pegar_Iduser()` → `getId()`

3. **Adicionar validações no construtor:**
   - Verificar se `id` é nulo ou menor/igual a zero
   - Verificar se `nome` é nulo ou vazio
   - Verificar se `dataNascimento` é nulo ou vazio
   - Se algo estiver inválido, lançar `IllegalArgumentException`

4. **Adicionar um método `toString()`:**
   ```java
   @Override
   public String toString() {
       return "User{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", dataNascimento='" + dataNascimento + '\'' +
               '}';
   }
   ```

### 💡 Dica:
Você vai precisar atualizar TODAS as chamadas para os métodos antigos nos outros arquivos também!

---

## 📝 PASSO 2: REFATORAR UserRepository.java

### O que você precisa fazer:

1. **Renomear os métodos:**
   - `salvar_usuario()` → `salvar()`
   - `buscar_usuario()` → `buscarPorId()`
   - `listar_usuarios()` → `listarTodos()`
   - `deletar_usuario()` → `deletar()`
   - `atualizar_usuario()` → `atualizar()`

2. **Mudar o tipo de retorno:**
   - `ArrayList<User>` → `List<User>` (import: `java.util.List`)

3. **Adicionar um novo método à interface:**
   ```java
   boolean existePorId(Long id);
   ```

### 💡 Dica:
Lembre-se que é uma **interface**, então você só declara o método, não implementa!

---

## 📝 PASSO 3: REFATORAR UserRepositoryImplementation.java

### O que você precisa fazer:

1. **Atualizar o tipo da lista:**
   - `private ArrayList<User> users` → `private List<User> usuarios`
   - Inicializar como: `new ArrayList<>()`

2. **Implementar os métodos renomeados:**
   - Atualizar nomes conforme a interface mudou

3. **Atualizar as chamadas aos getters do User:**
   - `u.pegar_Iduser()` → `u.getId()`
   - `user.pegar_Iduser()` → `user.getId()`

4. **Adicionar o método `existePorId()`:**
   ```java
   @Override
   public boolean existePorId(Long id) {
       return usuarios.stream()
               .anyMatch(u -> u.getId().equals(id));
   }
   ```

5. **Melhorar as mensagens:**
   - Adicionar emojis ou informações mais úteis nas mensagens de log
   - Exemplo: `"✓ Usuário salvo: " + user.getNome()`

### 💡 Dica:
Procure pela palavra `pegar_Iduser` no arquivo e substitua todas as ocorrências!

---

## 📝 PASSO 4: REFATORAR UserService.java

### O que você precisa fazer:

1. **Renomear todos os métodos:**
   - `criar_usuario()` → `criarUsuario()`
   - `listar_usuario()` → `listarUsuarios()`
   - `deletar_usuario()` → `deletarUsuario()`
   - `atualizar_usuario()` → `atualizarUsuario()`

2. **Adicionar um novo método:**
   ```java
   public User buscarPorId(Long id) {
       // Implementar logica para buscar usuário
   }
   ```

3. **Mudar `ArrayList` para `List`:**
   - Import: `java.util.List`
   - Return type: `List<User>` ao invés de `ArrayList<User>`

4. **Melhorar as validações:**
   - Criar um método privado `validarId()` que checa se ID é nulo ou <= 0
   - Criar um método privado `validarEntrada()` que valida id, nome e data
   - Usar esses métodos nos métodos públicos

5. **Usar o novo método `existePorId()`:**
   - Ao invés de: `if(repository.buscar_usuario(id_user) != null)`
   - Fazer: `if(!repository.existePorId(id))`

6. **Mudar exceções:**
   - `throw new Error()` → `throw new IllegalArgumentException()`

### 💡 Dica:
Adicionar validações torna seu código mais seguro! Sempre valide entrada do usuário.

---

## 📝 PASSO 5: REFATORAR Main.java

### O que você precisa fazer:

1. **Atualizar as chamadas aos métodos:**
   - `service.criar_usuario()` → `service.criarUsuario()`
   - `service.listar_usuario()` → `service.listarUsuarios()`
   - etc.

2. **Usar IDs específicos ao invés de `System.currentTimeMillis()`:**
   - `service.criarUsuario(1L, "José", "18-02-2007");`
   - `service.criarUsuario(2L, "Ana", "19-05-2000");`

3. **Adicionar mais operações CRUD:**
   - Demonstrar BUSCAR um usuário
   - Demonstrar ATUALIZAR um usuário
   - Demonstrar DELETAR um usuário

4. **Melhorar a saída:**
   - Usar `System.out.println()` com formatação
   - Adicionar seções com === TITULO ===
   - Usar `usuario.toString()` para exibir usuário completo

5. **Adicionar tratamento de exceções:**
   ```java
   try {
       service.criarUsuario(1L, "José", "18-02-2007");
   } catch (IllegalArgumentException e) {
       System.out.println("Erro: " + e.getMessage());
   }
   ```

### 💡 Dica:
Agora que o código está melhor, use o Main para demonstrar todas as funcionalidades!

---

## ✅ CHECKLIST DE REFATORAÇÃO

- [ ] **User.java**
  - [ ] Renomeou variáveis para camelCase
  - [ ] Renomeou getters para padrão Java
  - [ ] Adicionou validações no construtor
  - [ ] Implementou toString()

- [ ] **UserRepository.java**
  - [ ] Renomeou todos os métodos
  - [ ] Mudou ArrayList para List
  - [ ] Adicionou método existePorId()

- [ ] **UserRepositoryImplementation.java**
  - [ ] Atualizou para implementar novos métodos
  - [ ] Mudou para List<User>
  - [ ] Implementou existePorId()
  - [ ] Atualizou chamadas aos getters

- [ ] **UserService.java**
  - [ ] Renomeou todos os métodos
  - [ ] Mudou ArrayList para List
  - [ ] Adicionou método buscarPorId()
  - [ ] Criou validadores privados
  - [ ] Usou existePorId()
  - [ ] Trocou Error por IllegalArgumentException

- [ ] **Main.java**
  - [ ] Atualizou chamadas aos métodos
  - [ ] Usa IDs específicos (1L, 2L, 3L)
  - [ ] Demonstra CRUD completo
  - [ ] Tem tratamento de exceções

---

## 🧪 TESTANDO SEU CÓDIGO

Depois de refatorar tudo, compile assim:

```powershell
cd C:\Users\vx722\IdeaProjects\Crud
javac -d bin src/domain/*.java src/repository/*.java src/service/*.java src/UI/*.java
java -cp bin UI.Main
```

Se compilar sem erros e executar, parabéns! 🎉

---

## 💪 ORDEM RECOMENDADA

1. **Primeiro**: Refatore **User.java** (é a base)
2. **Depois**: Refatore **UserRepository.java** e **UserRepositoryImplementation.java**
3. **Depois**: Refatore **UserService.java**
4. **Por último**: Refatore **Main.java**

Isso garante que você não quebra dependências!

---

## 🎯 CONCEITOS QUE VOCÊ APRENDERÁ

- ✅ Convenções de nomes em Java (camelCase)
- ✅ Padrão de getters e setters
- ✅ Validação de entrada
- ✅ Tipos genéricos (List vs ArrayList)
- ✅ Exceções apropriadas
- ✅ Streams Java (filter, anyMatch)
- ✅ Injeção de dependência
- ✅ Padrão Repository
- ✅ Lógica CRUD
- ✅ DDD (Domain-Driven Design)

---

## 📚 RECURSOS ÚTEIS

**Para aprender mais:**
- Oracle Java Naming Conventions: https://www.oracle.com/java/technologies/
- DDD em Java: Pesquise "Domain-Driven Design Java"
- Padrão Repository: Pesquise "Repository Pattern"

---

**Boa sorte com a refatoração! Você consegue! 💪**

Se tiver dúvidas em algum passo, me avise e explico melhor! 🚀

