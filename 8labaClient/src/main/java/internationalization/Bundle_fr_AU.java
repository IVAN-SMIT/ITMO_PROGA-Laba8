package internationalization;

import java.util.ListResourceBundle;

public class Bundle_fr_AU extends ListResourceBundle {
    @Override
    protected Object[][] getContents(){
        return new Object[][]{
                {"Выход", "Salida"},
                {"Регистрация","Enregistrement"},
                {"Зарегистрироваться","Register"},
                {"Вход", "Entrée"},
                {"enter", "Entrée"},
                {"Имя пользователя", "Nom d'utilisateu"},
                {"Пароль", "Password"},
                {"История запросов","Historique des requêtes"},
                {"Очистить коллекцию","Effacer la collection"},
                {"Перемешать","Shuffle"},
                {"Показать всё","Show All"},
                {"Это поле обязательное","Ce champ est obligatoire"},
                {"Пользователь с таким именем уже существует", "Un utilisateur avec ce nom existe déjà"},
                {"Такого пользователя не существует","There is no such user"},
                {"Удалить по climate","Supprimer par climate"},
                {"Сведения","Info"},
                {"Помощь","Aide"},
                {"Удалить по id","Supprimer par id"},
                {"Удалить последний","Supprimer le dernier"},
                {"Фильтровать по carCode","Filtrer par carCode"},
                {"Поставить мне баллы","Give me points"}
        };
    }
}
