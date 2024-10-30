import java.util.List;
import java.util.Map;

public interface Histogram<T, Q> {
    Map<T, Integer> createHistogram(List<Q> items);
    void printHistogramValues(Map<T, Integer> histogram);
}
