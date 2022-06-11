package internationalization;

import java.util.ListResourceBundle;

public class Bundle_en_AU extends ListResourceBundle {
    @Override
    protected Object[][] getContents(){
        return new Object[][]{
                {"Выход", "Exit"},
                {"Регистрация","Registration"},
                {"Зарегистрироваться","Register"},
                {"Вход", "Enter"},
                {"enter", "Enter"},
                {"Имя пользователя", "Username"},
                {"Пароль", "Password"},
                {"История запросов","History"},
                {"Очистить коллекцию","Clear"},
                {"Перемешать","Shuffle"},
                {"Показать всё","Show"},
                {"Это поле обязательное","This field is required"},
                {"Пользователь с таким именем уже существует", "A user with this name already exists"},
                {"Такого пользователя не существует","There is no such user"},
                {"Удалить по climate","Remove by climate"},
                {"Сведения","Info"},
                {"Помощь","Help"},
                {"Удалить по id","Remove by id"},
                {"Удалить последний","Remove last"},
                {"Фильтровать по carCode","Filter by carCode"},
                {"Поставить мне баллы","Give me points"}

        };
    }
}
