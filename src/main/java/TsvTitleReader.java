
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleReader implements TitleReader {

    private final File source;

    public TsvTitleReader(File source) {
        this.source = source;
    }

    @Override
    public List<Title> read() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(source))) {
            readHeaderWith(reader);

            return readTitleWith(reader);
        }
    }


    private List<Title> readTitleWith(BufferedReader reader) throws IOException {
        List<Title> titles = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null) titles.add(titleOf(line));
        return titles;
    }

    private void readHeaderWith(BufferedReader reader) throws IOException {
        reader.readLine();
    }

    private Title titleOf(String l){
        String[] split = l.split("\t");
        return new Title(
                split[0],
                TitleTypeMapper.map(split[1]),
                split[2],
                split[3],
                toBoolean(split[4]),
                toInt(split[5]),
                toInt(split[6]),
                toInt(split[7]),
                split[8]);
    }

    private boolean toBoolean(String s) {
        return s.equals("1");
    }

    private int toInt(String s) {
        if(s.equals("\\N")) return 0;
        return Integer.parseInt(s);
    }

}
