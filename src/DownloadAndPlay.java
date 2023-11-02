import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class DownloadAndPlay {
    public static void main(String[] args) {
        // Создаем поток для скачивания mp3-файла
        Thread mp3DownloadThread = new Thread(() -> {
            try {
                String mp3Url = "https://rur.hitmotop.com/get/music/20170902/Kavinsky_-_Nightcall_47960996.mp3";
                URL mp3URL = new URL(mp3Url);
                URLConnection mp3Connection = mp3URL.openConnection();
                InputStream mp3InputStream = mp3Connection.getInputStream();
                FileOutputStream mp3OutputStream = new FileOutputStream("C:\\Users\\Мария\\IdeaProjects\\Save\\музыка\\драйв.mp3");

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = mp3InputStream.read(buffer)) != -1) {
                    mp3OutputStream.write(buffer, 0, bytesRead);
                }

                mp3OutputStream.close();
                mp3InputStream.close();

                // Воспроизводим mp3-файл
                playMp3("C:\\Users\\Мария\\IdeaProjects\\Save\\музыка\\драйв.mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Создаем поток для скачивания и сохранения изображения
        Thread imageDownloadThread = new Thread(() -> {
            try {
                URL imageUrl = new URL("https://w.forfun.com/fetch/11/111f83349a9ecaef536b1f65c769c32f.jpeg");
                BufferedImage image = ImageIO.read(imageUrl);

                // Сохраняем изображение по указанному пути
                ImageIO.write(image, "jpg", new FileOutputStream("C:\\Users\\Мария\\IdeaProjects\\Save\\картинки\\госля.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Запускаем оба потока параллельно
        mp3DownloadThread.start();
        imageDownloadThread.start();
    }

    // Метод для воспроизведения mp3-файла
    public static void playMp3(String filePath) {
        try {
            Process process = Runtime.getRuntime().exec("cmd /c start " + filePath);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}