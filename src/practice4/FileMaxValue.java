package practice4;

import java.util.List;

public class FileMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWrite readAndWrite = new ReadAndWrite();
        String PATH_NUMBER = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\bt-ss18\\numbers.txt";
        String PATH_RESULT = "C:\\Users\\ADMIN\\IdeaProjects\\MD2-JAVA\\bt-ss18\\result.txt";
        List<Integer> numbers = readAndWrite.readFile(PATH_NUMBER);
        int maxValue = findMax(numbers);
        readAndWrite.writeFile(PATH_RESULT, maxValue);
    }
}
