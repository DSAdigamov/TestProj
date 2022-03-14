import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class Main{


    public static void main(String args[]) throws IOException {

        int column = 0;
        //Проверяем есть ли аргумент
        if (args.length != 0)
        {
            try {
                if (Integer.parseInt(args[0]) > 0 && Integer.parseInt(args[0]) < 15) {
                    column = Integer.parseInt(args[0]);
                }
                else
                {
                    System.out.println("Неверный аргумент");
                    return;
                }
            } catch (NumberFormatException e)
            {
                System.out.println("Ошибка: " + e.getMessage());
                return;
            }
        }
        else
        {
            //Считывем значение из application.yml
            try {
                InputStream inputStream = new FileInputStream(new File("application.yml"));
                Yaml yaml = new Yaml();
                Map<String, Object> data = yaml.load(inputStream);
                inputStream.close();
                column = (int) data.values().toArray()[0];
            } catch (IOException e)
            {
                System.out.println("Ошибка: " + e);
            }

        }

        //Устанавливаем константу для класса
        AirportData.setArgCol(column);


        DataParser parser = new DataParser();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку, по которой будет осуществляться поиск:");
        String line = scanner.nextLine();

        //Начало отсчета времени
        double start = System.nanoTime();

        try {
            ArrayList<AirportData> list = parser.FindWords("airports.csv", line, column);

            double end = System.nanoTime();

            //Сортируем список
            Collections.sort(list, AirportData::compareTo);


            for (int i = 0; i < list.size(); i++) {
                System.out.println("");
                System.out.println(list.get(i).toString());
            }
            System.out.println("");


            System.out.println("Кол-во найденных строк: " + list.size());
            System.out.println("Затраченное время на поиск: " + (end - start)/ 10000000.000 + "mls");

        }catch (IOException e)
        {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

}
