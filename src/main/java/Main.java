import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // Создаем объект FileWriter для записи в файл "students.txt"
            FileWriter writer = new FileWriter("students.txt");

            // Создаем объект Scanner для считывания ввода с консоли
            Scanner scanner = new Scanner(System.in);

            // Инициализация переменных
            int choose = 1;
            int count = 0;
            ArrayList<String> students = new ArrayList<String>();

            // Запускаем цикл ввода данных о студентах, пока пользователь не решит завершить
            while (choose == 1) {
                count += 1;

                // Получаем имя студента
                System.out.print("Имя: ");
                var name = scanner.nextLine();

                // Получаем возраст студента
                System.out.print("Возраст: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Чистим буфер после считывания числа

                // Получаем средний балл студента
                System.out.print("Средний балл: ");
                double mark = scanner.nextDouble();
                scanner.nextLine(); // Чистим буфер после считывания числа

                // Формируем строку с информацией о студенте и добавляем ее в список
                String str = count + ") Имя: " + name + ", возраст: " + age + ", средний балл: " + mark;
                students.add(str);

                // Запрашиваем у пользователя продолжение ввода
                System.out.print("Продолжить? (0 - Нет, 1 - Да): ");
                choose = scanner.nextInt();
                scanner.nextLine(); // Чистим буфер после считывания числа
            }

            // Записываем информацию о студентах в файл
            for (String student : students) {
                writer.write(student + "\n");
            }

            // Закрываем файл и сканнер
            writer.close();
            scanner.close();
        } catch (IOException e) {
            // Обработка ошибок ввода/вывода
            System.err.println("Ошибка: " + e);
        } catch (InputMismatchException e) {
            // Обработка ошибок некорректного ввода
            System.err.println("Ошибка: " + e);
        }
    }
}
