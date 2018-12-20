package front.menu;

import java.util.Scanner;

public class MenuHelper {

    protected int readMenuClauseConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Please, type in the integer value");
                scanner.next();
            }
        }
    }

    protected String readStringClauseConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                return scanner.next();
            } else {
                scanner.next();
            }
        }
    }
}
