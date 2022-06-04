package connection;

import java.io.*;
import java.nio.channels.*;
import java.net.*;

/**
 * я короче все что связано с подключением к серверу в один класс засунул
 * Я гений, не так ли?
 */

public class connectionManager {
    public static SocketChannel client;
    private  String address = null;
    private  int port = 0;
    public static String answer = null;

    public connectionManager(String address, int port) throws IOException {
        this.address = address;
        this.port = port;

            client = SocketChannel.open(new InetSocketAddress(address, port));
            client.configureBlocking(true);
    }

    public  Response sendMessage(Request msg) {
        if (!client.isOpen()) {
            System.out.println("Подключаемся к серверу...");

            try {
                client = SocketChannel.open(new InetSocketAddress(address, port));
                client.configureBlocking(true);
            } catch (Exception e) {
                System.out.println("Не удается подключиться к серверу.");
                return null;
            }
        }

        Response response = null;

        try {
            Socket socket = client.socket();

            ObjectOutput objectOutput = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            objectOutput.writeObject(msg);
            objectOutput.flush();

            try {
                ObjectInput objectInput = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                Object obj = objectInput.readObject();

                if (obj instanceof Response)
                    response = (Response) obj;
                System.out.println(response.gettextResponse()); //печатаем то что прилетает с сервера сразу же
                answer = response.gettextResponse();
            } catch (Exception e) {
                System.out.println("Произошла ошибка приема с сервера.");
            }

        } catch (IOException e) {
            System.out.println("Попытка соединения...");

            try {
                client.close();
            } catch (IOException ex) {
                System.out.println("Не удается закрыть соединение.");
            }
        }

        return response;
    }
}