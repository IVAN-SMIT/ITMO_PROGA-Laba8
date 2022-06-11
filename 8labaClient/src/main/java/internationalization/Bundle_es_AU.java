package internationalization;

import java.util.ListResourceBundle;

public class Bundle_es_AU extends ListResourceBundle {
    @Override
    protected Object[][] getContents(){
        return new Object[][]{
                {"Выход", "Salida"},
                {"Регистрация","Registro"},
                {"Зарегистрироваться","Register"},
                {"Вход", "Enter"},
                {"enter", "Enter"},
                {"Имя пользователя", "Nombre de usuario"},
                {"Пароль", "Contraseña"},
                {"История запросов","historial"},
                {"Очистить коллекцию","borrar"},
                {"Перемешать","Shuffle"},
                {"Показать всё","Mostrar"},
                {"Это поле обязательное","This field is required"},
                {"Пользователь с таким именем уже существует", "A user with this name already exists"},
                {"Такого пользователя не существует","There is no such user"},
                {"Удалить по climate","eliminar por clima"},
                {"Сведения","Información"},
                {"Помощь","Ayuda"},
                {"Удалить по id","eliminar por id"},
                {"Удалить последний","eliminar el último"},
                {"Фильтровать по carCode","filtrar por carCode"},
                {"Поставить мне баллы","Give me points"}
        };
    }
}
