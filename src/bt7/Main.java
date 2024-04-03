package bt7;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Tạo một đối tượng để ghi vào tệp nhị phân
        MyObject obj1 = new MyObject("Hung", 123);

        try {
            // Tạo một FileOutputStream để ghi vào tệp nhị phân
            FileOutputStream fileOutputStream = new FileOutputStream("data.bin");
            // Tạo một ObjectOutputStream để ghi các đối tượng vào tệp nhị phân
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Ghi đối tượng vào tệp nhị phân
            objectOutputStream.writeObject(obj1);

            // Đóng các luồng
            objectOutputStream.close();
            fileOutputStream.close();

//            System.out.println("Đã ghi đối tượng vào tệp nhị phân thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên tệp nhị phân: ");
            String fileName = scanner.nextLine();

            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            List<Object> objectList = new ArrayList<>();
            try {
                while (true) {
                    Object obj = objectInputStream.readObject();
                    objectList.add(obj);
                }
            } catch (EOFException e) {

            }

            objectInputStream.close();
            fileInputStream.close();

            // Hiển thị danh sách đối tượng
            for (Object obj : objectList) {
                System.out.println(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}