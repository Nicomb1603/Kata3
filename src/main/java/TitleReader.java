import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public interface TitleReader {
    List<Title> read() throws IOException;
}
