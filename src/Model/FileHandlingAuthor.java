package Model;

import java.util.ArrayList;

abstract class FileHandlingAuthor {
    abstract public ArrayList<Author> readJsonFile(String file_path);
    abstract public void writeJsonFile(ArrayList<Author> authors);
    //public void readCSVFile(String file_path);//public void readXMLFile(String file_path);
}
