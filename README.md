# CRUD-JAVA

Sistema CRUD completo com **User**, **Product** e **Order** implementado em Java puro com arquitetura DDD (Domain-Driven Design).

---

## 📚 Sobre o Projeto

Primeiro projeto Java aplicando CRUD multi-entidade com separação de camadas (domain, repository, service, UI) e demonstração prática de relacionamentos entre entidades.

---

## 🧠 Conceitos Aplicados

- Domain-Driven Design (DDD)
- Padrão Repository
- Injeção de Dependência
- Enums e Value Objects
- Streams API (`.filter()`, `.findFirst()`, `.toList()`)
- Exception Handling
- Relacionamentos entre entidades

---

## 🏗️ Estrutura do Projeto

```text
Crud/
├── src/
│    ├── domain/          # Entidades (User, Product, Order, OrderItem, OrderState)
│    ├── repository/      # Interfaces e implementações (persistência em memória)
│    ├── service/         # Lógica de negócio e validações
│    └── UI/              # Main.java (demonstração do fluxo completo)
└── README.md
