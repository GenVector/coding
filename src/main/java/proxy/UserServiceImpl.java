package proxy;

public class UserServiceImpl implements UserService {

    private String name;

    @Override
    public String select() {
        System.out.println("查询 selectById");
        return name;
    }

    @Override
    public void update(String name) {
        System.out.println("更新 update");
        this.name = name;
    }

    @Override
    public void createUser(int age, String name) {
        this.name = name;
        System.out.println("学生姓名：" + name + ",学生年龄：" + age);

    }

}