package com.zhangchi.JavaLearning.designpattern;

/**
 * @author Chi Zhang
 * @date 2018/2/2
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        Man man = new Man();
        ManDecoratorA md1 = new ManDecoratorA();
        ManDecoratorB md2 = new ManDecoratorB();

        md1.setPerson(man);
        md2.setPerson(md1);
        md2.eat();
    }
}

// Component
interface Person {

    void eat();
}

// ConcreteComponent
class Man implements Person {

    public void eat() {
        System.out.println("男人在吃");
    }
}

// Decorator
abstract class Decorator implements Person {

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void eat() {
        person.eat();
    }
}

// ConcreteDectrator
class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}
class ManDecoratorB extends Decorator {

    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类");
    }
}