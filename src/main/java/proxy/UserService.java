package proxy;

public interface UserService {
    public String select();

    public void update(String name);

    public void createUser(int age, String name);
}
