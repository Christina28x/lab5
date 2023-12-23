package reflection;

/**
 * Класс, наследующий класс SomeInterface
 */
public class OtherImpl implements SomeInterface {

    /**
     * Переопределенный метод из SomeInterface
     */
    @Override
    public void doSome() {
        System.out.println("B");
    }
}
