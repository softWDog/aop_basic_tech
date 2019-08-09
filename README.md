> AOP为Aspect Oriented Programming的缩写，意为：面向切面编程。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率

### 应用场景

```java 
public interface Greeting {
    void sayHello();
}
```


```java
class Programmer implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello,I'm programmer");
    }
}
```

```java
class Student implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello,I'm student");
    }
}
```

```java
class Teacher implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello,I'm teacher");
    }
}
```

```java
public class Client {
    public static void main(String args[]) {
        Greeting greeting=new Student();
        greeting.sayHello();
        greeting=new Teacher();
        greeting.sayHello();
        greeting=new Programmer();
        greeting.sayHello();
    }
}
```
![image](https://imgchr.com/i/ebIptA)



需要在sayHello方法前后，分别输出call before,call after.

### 方法一（写死代码）
```java
class Programmer implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("call before");
        System.out.println("Hello,I'm programmer");
        System.out.println("call after");
    }
}
```

```java
class Student implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("call before");
        System.out.println("Hello,I'm student");
        System.out.println("call after");
    }
}
```

```java
class Teacher implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("call before");
        System.out.println("Hello,I'm teacher");
        System.out.println("call after");
    }
}
```

```java
public class Client1 {
    public static void main(String args[]) {
        Greeting greeting=new Student();
        greeting.sayHello();
        greeting=new Teacher();
        greeting.sayHello();
        greeting=new Programmer();
        greeting.sayHello();
    }
}
```
![image](https://imgchr.com/i/ebIptA)

这种写死代码的方式，如果类文件多至几百个，那么就需要改几百处代码。同时，如果我们引用的是第三方jar，这个时候我们根本就不能改变第三方的jar。


### 方法二（静态代理）
我们不去写死原来文件代码，我们给greeting接口写一个静态代理

```java
public class GreetingStaticProxy implements Greeting {
    private Greeting greeting;

    public GreetingStaticProxy(Greeting greeting) {
        this.greeting = greeting;
    }

    @Override
    public void sayHello() {
        before();
        greeting.sayHello();
        after();
    }

    private void after() {
        System.out.println("call after");
    }

    private void before() {
        System.out.println("call before");
    }
}
```


```java
public class Client2 {
    public static void main(String args[]) {
        Greeting studentStaticProxy=new GreetingStaticProxy(new Student());
        studentStaticProxy.sayHello();
        Greeting teacherStaticProxy=new GreetingStaticProxy(new Teacher());
        teacherStaticProxy.sayHello();
        Greeting programmerStaticProxy=new GreetingStaticProxy(new Programmer());
        programmerStaticProxy.sayHello();
    }
}
```
![image](https://imgchr.com/i/ebIPpt)

我们通过给greeting接口提供一个静态代理GreetingStaticProxy成功的解决了写死代码的问题，但是如果接口增多，比如增加一个Complain接口，那么就需要增加一个ComplainStaticProxy。最终XxxxStaticProxy类会越来越多。如何才能让这些代理类尽可能的减少？最好只有一个代理类，我们可以用JDK的动态代理。

### 方法三（JDK动态代理）
JDK动态代理关键类，InvocationHandler，Proxy这两个类。

```java
public class DynamicProxy {

    public static <T> T createProxy(final T t) {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before();
                Object result = method.invoke(t, args);
                after();
                return result;
            }
            private void after() {
                System.out.println("call after");
            }

            private void before() {
                System.out.println("call before");
            }
        });
    }
}

```


```java
public class Client3 {
    public static void main(String args[]) {
        Greeting studentDynaminProxy = DynamicProxy.createProxy(new Student());
        studentDynaminProxy.sayHello();
        Greeting teacherDynicProxy = DynamicProxy.createProxy(new Teacher());
        teacherDynicProxy.sayHello();
        Greeting programmerDynicProxy = DynamicProxy.createProxy(new Programmer());
        programmerDynicProxy.sayHello();
    }
}
```
![image](https://imgchr.com/i/ebIi1P)

及时增加了很多Greeting之外的接口，我们都可以通过DynamicProxy一个代理类来进行代理。但是这样做仍然存在一个问题，就是JDK提供的代理类只能代理接口，而不能代理没有接口的类。有什么方案可以解决这个问题么？

### 方法四(Cglib代理)
Cglib代理关键类，MethodInterceptor,Enhancer这两个类
```java
public class CglibDynamicProxy {
    public static <T> T createProxy(Class<T> tClass) {
        return (T) Enhancer.create(tClass, new MethodInterceptor() {
            public Object intercept(Object targerObject, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
                before();
                Object result = methodProxy.invokeSuper(targerObject, params);
                after();
                return result;
            }
            private void after() {
                System.out.println("call after");
            }
            private void before() {
                System.out.println("call before");
            }
        });
    }
}
```

```java
public class Client4 {
    public static void main(String args[]) {
        Student studentCglibProxy=CglibDynamicProxy.createProxy(Student.class);
        studentCglibProxy.sayHello();
        Teacher teacherCglibProxy=CglibDynamicProxy.createProxy(Teacher.class);
        teacherCglibProxy.sayHello();
        Programmer programmerCglibProxy=CglibDynamicProxy.createProxy(Programmer.class);
        programmerCglibProxy.sayHello();
    }
}
```
![image](https://imgchr.com/i/ebTyYd)
通过Cglib代理可以实现对所有类的代理，能够很好的解决我们的问题。JDK代理和Cglib是Spring AOP框架的核心。Spring里边有个事务注解@Transactional 的原理也就是在方法前connection.setAutoCommit(false)，然后在方法或connection.commit()来保证方法的事务的原子性。其中的技术也就是运用了JDK的动态代理和Cglib代理。


