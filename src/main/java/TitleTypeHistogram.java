import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TitleTypeHistogram implements Histogram<Title.TitleType, Title> {

    @Override
    public Map<Title.TitleType, Integer> createHistogram(List<Title> read) {
        Map<Title.TitleType, Integer> histogram = new HashMap<>();
        read.forEach(t -> {
            histogram.putIfAbsent(t.titleType(), 0);
            histogram.compute(t.titleType(), (tt, i) -> i+1);
        });
        return histogram;
    }

    @Override
    public void printHistogramValues(Map<Title.TitleType, Integer> histogram) {
        for(Title.TitleType type : histogram.keySet()) {
            System.out.println(type + " " + histogram.get(type));
        }
    }

}
