package DF2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class provides a static method for uploading image files.
 */
public class ImageFileManager {
    /**
     * Uploads an image file to a specified destination path.
     *
     * @param imageFile The File object representing the image file to be uploaded.
     * @param destinationPath The path to the directory where the image file should be uploaded.
     * @throws IOException If an error occurs during the upload process.
     */
    public static void uploadImage(File imageFile, String destinationPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(imageFile);
             FileOutputStream fos = new FileOutputStream(destinationPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        File imageFile = new File("C:\\Users\\KBM  COMPUTERS\\Downloads\\IMG_0015.jpeg");
        String destinationPath = "uploaded_images/";
        try {
            uploadImage(imageFile, destinationPath);
            System.out.println("Image uploaded successfully!");
        } catch (IOException e) {
            System.err.println("Error uploading image: " + e.getMessage());
        }
    }
}
