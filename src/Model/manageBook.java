package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class manageBook extends FileHandlingBook implements Displayable{


    ArrayList<Book> books = new ArrayList<Book>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageBook(){
        readJsonFile("E:\\practice oopm exp 10\\src\\Model\\bookdata2.json");
    }


    public ArrayList<Book> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int iid = node.get("iid").asInt();
                    String genre = node.get("genre").asText();
                    String publicationDate = node.get("publicationDate").asText();
                    String bookName = node.get("bookName").asText();
                    String language = node.get("language").asText();
                    int edition = node.get("edition").asInt();
                    int copiesSold = node.get("copiesSold").asInt();
                    double pricePerCopy = node.get("pricePerCopy").asDouble();

                    Book book = new Book(iid, genre, publicationDate, bookName, language, edition, copiesSold, pricePerCopy);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
    public void writeJsonFile(ArrayList<Book> books) {
        // Implement the writeJsonFile method here // You can use the ObjectMapper to write the list of authors to a JSON file
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < books.size(); i++)
            {
                String book_str = Obj.writeValueAsString(books.get(i)); // Converting the Java object into a JSON string
                System.out.println(book_str); // Displaying Java object into a JSON string
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Iid");
        headers.add("Genre");
        headers.add("PublicationDate");
        headers.add("BookName");
        headers.add("Language");
        headers.add("Edition");
        headers.add("CopiesSold");
        headers.add("PricePerCopy");

        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the books list and then extracts the various attributes of the student such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> book_details = new ArrayList<String>();

        book_details.add(String.valueOf(books.get(line).getIid()));
        book_details.add(books.get(line).getGenre());
        book_details.add(books.get(line).getPublicationDate());
        book_details.add(books.get(line).getBookName());
        book_details.add(books.get(line).getLanguage());

        book_details.add(String.valueOf(books.get(line).getEdition()));
        book_details.add(String.valueOf(books.get(line).getCopiesSold()));
        book_details.add(String.valueOf(books.get(line).getPricePerCopy()));


        return book_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> books_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            books_subset.add(getLine(i));
        }
        return books_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    public ArrayList getTable() {
        return books;
    }
}



