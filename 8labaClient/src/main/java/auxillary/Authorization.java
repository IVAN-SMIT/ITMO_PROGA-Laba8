package auxillary;

import connection.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;




public class Authorization {

    public static int port = 9890;

    static String username = null;
    static String password;
    static String passwordFin = null;
    static String result = "НЕВЕРНЫЙ ПАРОЛЬ";
    static String resultReg ="ПОЛЬЗОВАТЕЛЬ С ТАКИМ ИМЕНЕМ УЖЕ СУЩЕСТВУЕТ";

    public static connectionManager client;


    public static String authorization(String username, String pass) {
        try {

            try {
                client = new connectionManager("localhost", port);
            } catch (IOException e) {
                System.out.println(e);
            }

            if (client != null){
                    password = String.valueOf(pass);
                    passwordFin = new PasswordFormat().toSHA256(password);
                    assert client != null;
                    resultReg = client.sendMessage(new Request("registration", username, passwordFin)).gettextResponse();
                    if (result.equals("ПОЛЬЗОВАТЕЛЬ С ТАКИМ ИМЕНЕМ УЖЕ СУЩЕСТВУЕТ")){
                        return "занято";
                    }
                    if (result.equals("РЕГИСТРАЦИЯ ПРОИЗОШЛА УСПЕШНО")){
                        return "успех";
                    }
                    if (result.equals("ОШИБКА")){
                        return "ошибка";
                    }
        }else return "потеря соединения";
        }catch (Exception e){
            return "Cервер не найден";
           // System.out.println(e);
        }
        return "err";
    }

    public static String login(String username, String pass) throws NoSuchAlgorithmException, IOException {
        try {

            try {
                client = new connectionManager("localhost", port);
            } catch (IOException e) {
                System.out.println(e);
            }

            if(client!= null) {
                password = String.valueOf(pass);
                passwordFin = new PasswordFormat().toSHA256(password);
                assert client != null;
                result = client.sendMessage(new Request("enter", username, passwordFin)).gettextResponse();
                if (result.equals("НЕВЕРНЫЙ ПАРОЛЬ")) {
                    return "не пароль";
                }
                if (result.equals("ПОЛЬЗОВАТЕЛЯ С ТАКИМ ИМЕНЕМ НЕ СУЩЕСТВУЕТ")) {
                    return "не существует";
                }
                if(result.equals("ВХОД ВЫПОЛНЕН")){
                    return "вход";
                }
            }else {return "потеря соединения";}
        } catch (Exception e) {
            return "Cервер не найден";
           // System.out.println(e);
        }
        return "err";
    }


    public static String getUsername(){
        if (username != null){
            return username;
        }
        return null;
    }
    public static String getPassword(){
        if (passwordFin != null){
            return passwordFin;
        }
        return null;
    }
}
