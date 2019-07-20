package pa;

import configuration.Configurations;
import index.IndexServiceImpl;
import interfaces.services.ConfigurationService;
import interfaces.services.IndexService;
import lexer.SimpleTokenizer;
import search.SearchServiceImpl;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        ConfigurationService configurationService = Configurations.createConfiguration();
        IndexService indexService = new IndexServiceImpl(new SimpleTokenizer());
        SearchServiceImpl abstractSearchService = new SearchServiceImpl(new SimpleTokenizer());

        indexService.addToIndex((Path) null);

        abstractSearchService.search("qwe ewq");
    }
}
