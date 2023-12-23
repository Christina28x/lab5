package reflection;

/**
 * Класс, наследующий класс SomeOtherInterface
 */
public class SODoer implements SomeOtherInterface {

    /**
     * Переопределенный метод из SomeOtherInterface
     */
    @Override
    public void doSome() {
        System.out.println("C");
    }
}
