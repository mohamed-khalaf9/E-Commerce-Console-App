package model;

public class UserModel {
    private String name;
    private String email;
    private  String password;
    private Role role;

    public UserModel(String name, String email, String password, Role role) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
