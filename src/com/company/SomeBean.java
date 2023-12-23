package com.company;
import reflection.SomeInterface;
import reflection.SomeOtherInterface;

/**
 * Класс, содержащий две аннотации
 */
public class SomeBean {

    @AutoInjectable
    private SomeInterface someField;
    @AutoInjectable
    private SomeOtherInterface otherField;

    /**
     * Конструктор по умолчанию
     */
    public SomeBean() {}

    /**
     * Метод, вызывающий методы интерфейса из полей с аннотациями.
     */
    public void go(){
        someField.doSome();
        otherField.doSome();
    }
}
