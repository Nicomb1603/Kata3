import org.jfree.data.category.CategoryDataset;

import java.util.Map;

public interface DrawHistogram<T, I> {
    CategoryDataset createDataset(Map<T,I> histogram);
    void showHistogram();
}
