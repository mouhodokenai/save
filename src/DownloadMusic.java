import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadMusic {
    public static void main(String[] args) {
        // URL для скачивания файла
        String fileUrl = "https://rur.hitmotop.com/get/music/20220726/SHAMAN_-_YA_RUSSKIJJ_74622610.mp3";
        // Путь, по которому будет сохранен скачанный файл
        String savePath = "C:\\Users\\Мария\\IdeaProjects\\Save\\музыка\\песня.mp3";
        try {
            // Создание объекта URL
            URL url = new URL(fileUrl);
            // Открытие соединения с URL
            URLConnection connection = url.openConnection();
            // Получение входного потока для чтения данных
            InputStream inputStream = connection.getInputStream();
            // Создание файлового потока для записи данных в файл
            try (FileOutputStream outputStream = new FileOutputStream(savePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                // Чтение данных из входного потока и запись в файл
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("Файл успешно скачан: " + savePath);
        } catch (Exception e) {
            // В случае ошибки, выводим информацию о ней
            e.printStackTrace();
        }
    }
}
