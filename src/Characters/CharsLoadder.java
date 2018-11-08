package Characters;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class CharsLoadder {
	
	private Player chrs[] = new Player[209];
	private int indexControl = 0;
	

	public void loadChars() {
		
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
            	this.loadChar(line);
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
	
	public Player[] getChars() {
		return this.chrs;
	}
	
	private void loadChar(String line) {
		String[] itens = line.split(",");
		
		String id =  itens[0];
		String name = itens[1];
		String fatherName = itens[2];
		String fatherId = itens[3];
		String motherName = itens[4];
		String motherId = itens[5];
		String spouses = itens[6];
		String spousesIds = itens[7];
		
		Player ch = new Player(id, name, fatherName, fatherId, motherName, motherId, spouses, spousesIds);
		this.chrs[this.indexControl] = ch;
		this.indexControl++;
	}
}
