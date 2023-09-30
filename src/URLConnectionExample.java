package src;
// Ниже приведен пример применения класса URLConnection

import java.net.*;
import java.io.*;
import java.util.Date;

public class URLConnectionExample {

    public static void main(String[] args) throws Exception{
        int c;
        URL myUrl = new URL("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fpermalink.php%3Fstory_fbid%3Dpfbid021GWx2a5KHKSdodnzecDTjBAvEPoq91ag8qGLyjeumhTAyDdS5YtduCquCsSMFQxGl%26id%3D100013401632329");
        URLConnection myUrlCon = myUrl.openConnection();

        // Получить дату
        long d = myUrlCon.getDate();
        if(d == 0)
            System.out.println("Сведения о дате отсутствуют.");
        else
            System.out.println("Дата: " + new Date(d));

        // Получить тип содержимого
        System.out.println("Типа содержимого: " + myUrlCon.getContentType());

        // Получить дату срока действия ресурса
        d = myUrlCon.getExpiration();
        if(d == 0)
            System.out.println("Сведения о сроке действия отсутствуют.");
        else
            System.out.println("Срок действия истекает: " + new Date(d));

        // Получить дату последней модификации
        d = myUrlCon.getLastModified();
        if(d == 0)
            System.out.println("Сведения о дате последней модификации отсутствуют.");
        else
            System.out.println("Дата последней модификации: " + new Date(d));

        // Получить длину содержимого
        long length = myUrlCon.getContentLengthLong();
        if(length == -1)
            System.out.println("Длина содержимого недоступна");
        else
            System.out.println("Длина содержимого: " + length);

        if(length != 0) {
            System.out.println("=== Содержимое ===");
            InputStream input = myUrlCon.getInputStream();
            while(((c = input.read()) != -1)) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("Содержимое недоступно.");
        }
    }

}