package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
/*
 * springBoot与动态代理
    在 Spring Framework 工程中 AOP 默认使用 JDK 动态代理;springBoot默认使用cglib 。
    1、cglib可以支持继承代理。JDK 动态代理可能导致的类型转化异常问题 J如果直接注入impl时可能会报错
    2、在 SpringBoot 中，如果需要默认使用 JDK 动态代理，可以通过配置项 spring.aop.proxy-target-class=false 来进行修改，
    3、使用JDK动态代理时获取不到实现类方法上的注解
    4、使用JDK代理必须实现接口也是一个非常糟糕的体验
在启动类上通过 @EnableAspectJAutoProxy(proxyTargetClass = false) 配置已无效
 */
public class CglibHandler implements MethodInterceptor {
    // cglib 通过继承实现代理，可以代理没有接口的类,是被代理类的子类
    // ASM字节码操作框架
    // 相比JDK动态代理，速度较快，但创建代理对象的开销较大
    // 依赖 net.sf.cglib 在JDK9引入模块化与依赖管理- JPMS之后，默认情况下不再允许访问 java.base 模块中的 java.lang 需要开启安全支持

    private Object target;

    public CglibHandler(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        logBefore();
        Object returnValue = proxy.invokeSuper(obj, args);
        logAfter();
        return returnValue;
    }

    private void logBefore() {
        System.out.println("Log before method execution");
    }

    private void logAfter() {
        System.out.println("Log after method execution");
    }
}

 class CGLIBDynamicProxyDemo {
    public static void main(String[] args) {
        UserServiceImpl impl = new UserServiceImpl();
        CglibHandler proxy = new CglibHandler(impl);
        UserServiceImpl userServiceProxy = (UserServiceImpl) proxy.getProxyInstance();

        // 调用方法前后会执行增强内容
        // 调用方法
        userServiceProxy.createUser(18, "张睿泽");

        userServiceProxy.update("张三");
        String name = userServiceProxy.select();
        System.out.println(name);
    }
}


