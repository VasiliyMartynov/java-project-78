### Hexlet tests and linter status:
[![Actions Status](https://github.com/VasiliyMartynov/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/VasiliyMartynov/java-project-78/actions)
[![Java CI](https://github.com/VasiliyMartynov/java-project-78/actions/workflows/check.yml/badge.svg)](https://github.com/VasiliyMartynov/java-project-78/actions/workflows/check.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/6aa1f8e4549bf6f89239/maintainability)](https://codeclimate.com/github/VasiliyMartynov/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/6aa1f8e4549bf6f89239/test_coverage)](https://codeclimate.com/github/VasiliyMartynov/java-project-78/test_coverage)


VasiliyMartynov
/
java-project-78


### Описание
Валидатор данных – библиотека, с помощью которой можно проверять корректность любых 
данных. Подобных библиотек множество в каждом языке, так как практически все 
программы работают с внешними данными, которые нужно проверять на корректность. В первую очередь речь идет про данные форм заполняемых пользователями.

### Цель проекта
Направленный на прокачку проектирования архитектуры в
объектно-ориентированном стиле. 

### Список инструментов
IDE IntelliJ IDEA,
Java 17,
Gradle,
checkstyle.sourceforge.io,
CodeClimate,
Make,
Markdown,
JUnit,


#### Пример использования 

<pre><code>
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

// строки
StringSchema schema = v.string().required();

schema.isValid("what does the fox say"); // true
schema.isValid(""); // false

// числа
NumberSchema schema = v.number().required().positive();

schema.isValid(-10); // false
schema.isValid(10); // true

// объект Map с поддержкой проверки структуры
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

MapSchema schema = v.map().sizeof(2).shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "");
human2.put("age", null);
schema.isValid(human1); // false
</pre></code>
