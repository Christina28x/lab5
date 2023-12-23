package reflection;

/**
 * Класс, наследующий класс SomeInterface
 */
public class SomeImpl implements SomeInterface {

    /**
     Переопределенный метод из SomeOtherInterface
     */
    @Override
    public void doSome() {
        System.out.println("A");
    }
}
