import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataParser {

    public ArrayList FindWords(String filePath, String neededChars, int column) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        InputStreamReader stream = new InputStreamReader(file);
        BufferedReader reader = new BufferedReader(stream);

        ArrayList<AirportData> lines = new ArrayList<AirportData>();
        String line;
        while((line = reader.readLine()) != null)
        {
            line = line.replaceAll("\"", "");
            String[] splitedLine = line.split(",");
            if (splitedLine[column - 1].startsWith(neededChars) == true)
            {
                lines.add(new AirportData(splitedLine));
            }

        }
        reader.close();
        stream.close();
        file.close();
        return lines;
    }

}
