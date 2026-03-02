package domain;

public class User {

    private Long id_user;
    private String name;
    private String birthday;

    public User(Long id_user, String name, String birthday) {
        this.id_user = id_user;
        this.birthday = birthday;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public Long getId() {
        return this.id_user;
    }

    @Override
    public String toString() {
        return "User {" +
                "id_user=" + this.id_user +
                ", nome='" + this.name + '\'' +
                ", data_nascimento='" + this.birthday + '\'' +
                '}';
    }
}
