package examples;

import impl.configuration.Configurations;
import impl.lexer.SimpleTokenizer;
import interfaces.services.ConfigurationService;
import interfaces.services.IndexService;
import interfaces.services.SearchService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        ConfigurationService configurationService = Configurations.createConfiguration(new SimpleTokenizer());
        IndexService indexService = configurationService.createIndexService();
        SearchService searchService = configurationService.createSearchService();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("Выберите действие: \n1 - индексировать, \n2 - удалить из индекса, \n3 - выполнить запрос к индексу, \n4 - закончить выполнение");
            String activity = in.readLine();
            switch (activity) {
                case "1":
                    System.out.println("Укажите путь, который хотите проиндексировать");
                    indexService.addToIndex(in.readLine());
                    break;
                case "2":
                    System.out.println("Укажите путь, который хотите удалить из индекса");
                    indexService.removeFromIndex(in.readLine());
                    break;
                case "3":
                    System.out.println("Введите запрос для поиска");
                    searchService.search(in.readLine()).forEach(System.out::println);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Вы запросили неизвестное действие! Попробуйте ещё раз.");
            }
        }
    }
}
