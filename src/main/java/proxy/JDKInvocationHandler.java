package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 用于监听方法测试性能的Handler执行器
 */
public class JDKInvocationHandler implements InvocationHandler {
    // 通过反射实现 性能较差
    // 只能代理有实现了接口的类。代理类只能是接口的实现类，但不是真实的业务类的子类，与真正的业务类没有继承关系
    // 只能实现接口的代理

    private Object real;

    public JDKInvocationHandler(Object real) {
        this.real = real;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long begin = System.currentTimeMillis();

        // 真实业务对象当前的执行方法(基于反射的方式)
        // 它会调用目标方法并返回执行结果。
        Object returnValue = method.invoke(real, args);

        long end = System.currentTimeMillis();

        System.out.println("方法执行耗时" + (end - begin) + "毫秒！");

        return returnValue;

    }

}

class Test01 {
    public static void main(String[] args) {
        // 真实主题对象
        UserServiceImpl realUserService = new UserServiceImpl();

        // 获取类加载器
        ClassLoader classLoader = realUserService.getClass().getClassLoader();

        // 接口列表
        Class[] interfaces = realUserService.getClass().getInterfaces();

        // 创建InvocationHandler对象（动态代理的执行逻辑）
        JDKInvocationHandler h = new JDKInvocationHandler(realUserService);
        for (Class c : interfaces) {
        }

        // 创建一个代理对象（动态代理对象）
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, h);

        System.out.println(userServiceProxy instanceof UserService);
        System.out.println(userServiceProxy instanceof UserServiceImpl);

        // 调用方法
        userServiceProxy.createUser(18, "张睿泽");

        userServiceProxy.update("张三");
        String name = userServiceProxy.select();
        System.out.println(name);
    }
}
