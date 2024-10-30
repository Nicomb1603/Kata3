import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        TitleTypeHistogram titleTypeHistogram = new TitleTypeHistogram();

        Map<Title.TitleType, Integer> histogram = titleTypeHistogram.createHistogram(loadFile("./title.basics.tsv"));
        titleTypeHistogram.printHistogramValues(histogram);


    }

    private static List<Title> loadFile(String s) throws IOException {
        TsvTitleReader reader = new TsvTitleReader(new File(s));
        return reader.read();
    }


}
