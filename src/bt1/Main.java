package bt1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //tạo file
        File file = new File("data.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            String content = readFile();   // Đọc nội dung từ file
            int wordCount = countWords(content);   // Đếm số lượng từ
            System.out.println("Nội dung của file là: " + content);
            System.out.println("Số lượng từ trong file: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Hàm để đọc nội dung từ file và trả về một chuỗi
    private static String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(" "); // Đọc từng dòng và thêm vào chuỗi, cách nhau bằng khoảng trắng
            }
        }
        return sb.toString();
    }

    // Hàm để đếm số lượng từ trong chuỗi
    private static int countWords(String text) {
        String[] words = text.split(" "); // Tách chuỗi thành mảng các từ, sử dụng khoảng trắng làm dấu phân cách
        return words.length; // Độ dài của mảng chính là số lượng từ
    }
}
