import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadImage {
    public static void main(String[] args) {
        // URL изображения, которое нужно скачать
        String imageUrl = "https://cs9.pikabu.ru/post_img/2017/10/08/6/og_og_1507449740213986738.jpg";
        // Путь, по которому нужно сохранить изображение
        String savePath = "C:\\Users\\Мария\\IdeaProjects\\Save\\картинки\\мем.jpg";
        try {
            // Создаем объект URL для доступа к ресурсу по URL
            URL url = new URL(imageUrl);
            // Устанавливаем соединение с ресурсом по URL
            URLConnection connection = url.openConnection();
            // Получаем входной поток данных из соединения
            InputStream inputStream = connection.getInputStream();
            try (FileOutputStream outputStream = new FileOutputStream(savePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                // Считываем данные из входного потока и записываем их в файл
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            // Выводим сообщение об успешном скачивании
            System.out.println("Картинка успешно скачана: " + savePath);
        } catch (IOException e) {
            // В случае ошибки выводим информацию об ошибке
            e.printStackTrace();
        }
    }
}
