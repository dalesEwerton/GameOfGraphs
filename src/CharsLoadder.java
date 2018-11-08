import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class CharsLoadder {
	
	private Character chars[];
	
	public static void main(String[] args) {
		loadChars();
	}

	public static void loadChars() {
		
		String SUB_PATH = "/data/";
		String ROOT_PATH = Paths.get("").toAbsolutePath().toString();
		String DATA_FILE_NAME = "data.csv";
		String csvFile = ROOT_PATH + SUB_PATH + DATA_FILE_NAME;
		
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] item = line.split(cvsSplitBy);
               
                // TODO: Instanciate the chars when the data was with N/As 
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
