package domain;

public class User {

    private Long id_user;
    private String nome;
    private String data_nascimento;

    public User(Long id_user, String nome, String data_nascimento) {
        this.id_user = id_user;
        this.data_nascimento = data_nascimento;
        this.nome = nome;
    }

    public String pegar_nome() {
        return this.nome;
    }

    public String pegar_nascimento() {
        return this.data_nascimento;
    }

    public Long pegar_Iduser() {
        return this.id_user;
    }
}
