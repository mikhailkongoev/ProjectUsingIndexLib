package examples;

import configuration.Configurations;
import interfaces.services.ConfigurationService;
import interfaces.services.IndexService;
import interfaces.services.SearchService;
import lexer.FilteringTokenizer;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        ConfigurationService configurationService = Configurations.createConfiguration(new FilteringTokenizer());
        IndexService indexService = configurationService.createIndexService();
        SearchService searchService = configurationService.createSearchService();

        indexService.addToIndex((Path) null);

        searchService.search("qwe ewq");
    }
}
