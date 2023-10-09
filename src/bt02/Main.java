package bt02;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<String> wordStack = new Stack<>();
        int choice;
        do {
            System.out.println("****************MENU***************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            System.out.print("Hãy lựa chọn): ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập câu: ");
                    String inputSentence = scanner.nextLine();
                    String[] words = inputSentence.split(" ");
                    for (String word : words) {
                        wordStack.push(word);
                    }
                    System.out.println("Văn bản đã được lưu trong stack.");
                    break;
                case 2:
                    System.out.print("Văn bản đảo ngược: ");
                    while (!wordStack.isEmpty()) {
                        System.out.print(wordStack.pop() + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Thoát.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại 1 -> 3.");
            }
        } while (true);
    }
}
