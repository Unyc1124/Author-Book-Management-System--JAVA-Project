package Model;

import java.util.ArrayList;

abstract class FileHandlingBook {
    abstract public ArrayList<Book> readJsonFile(String file_path);// Add other abstract methods here if needed
    abstract public void writeJsonFile(ArrayList<Book> books);
}
