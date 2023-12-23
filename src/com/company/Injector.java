package com.company;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 *
 * Класс Injector реализует внедрение зависимостей в любой объект, содержащий поля
 * помеченные аннотацией @AutoInjectable
 */
public class Injector<T>{
    /**
     * Ссылка на объект конфигурации
     */
    private final Properties properties;

    /**
     * Класс конструктор
     * @param pathToPropertiesFile Путь к файлу.
     * @throws IOException Исключение, выдаваемое при возникновении ошибки ввода-выводa.
     */
    Injector(String pathToPropertiesFile) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(pathToPropertiesFile)));
    }

    /**
     * Inject принимает произвольный объект, исследует его на наличие полей с аннотацией AutoInjectable.
     * Если такое поле есть, посмотрите на его тип и поищите реализацию в файле ini.properties.
     * @param obj Объект любого класса
     * @return Объект с инициализированными полями с автоматически вводимой аннотацией
     */
    T inject(T obj) throws IOException, IllegalAccessException, InstantiationException {

        Class dependency;
        Class cl = obj.getClass();

        Field[] fields = cl.getDeclaredFields(); //Список всех полей в классе obj
        for (Field field: fields){

            Annotation a = field.getAnnotation(AutoInjectable.class); //Проверка аннотации
            if (a != null){

                String[] fieldType = field.getType().toString().split(" ");
                String equalsClassName = properties.getProperty(fieldType[1], null);

                if (equalsClassName != null){

                    try {
                        dependency = Class.forName(equalsClassName);

                    } catch (ClassNotFoundException e){
                        System.out.println("Not found class for " + equalsClassName);
                        continue;
                    }

                    field.setAccessible(true);
                    field.set(obj, dependency.newInstance()); //Инициализируем поле объектом, указанным в конфигурации
                }
                else
                    System.out.println("Not found properties for field type " + fieldType[1]);
            }
        }
        return obj;
    }
}