package com.company;
import java.io.IOException;

/**
 * The Main class
 */
public class Main {
    /**
     * Основной метод
     * @param args Основные аргументы
     * @throws IOException Исключение, выдаваемое при возникновении ошибки ввода-вывода.
     * @throws InstantiationException Исключение при создании экземпляра
     * @throws IllegalAccessException Исключение при создании экземпляра без доступа к определению указанного класса, поля, метода или конструктора.
     */
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {

        SomeBean sb = (new Injector<SomeBean>("src/config/inj.properties").inject(new SomeBean()));
        sb.go();
    }
}