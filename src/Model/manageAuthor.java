package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class manageAuthor extends FileHandlingAuthor implements Displayable {
    public static ArrayList<Author> authors = new ArrayList<Author>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageAuthor(){
        readJsonFile("E:\\practice oopm exp 10\\src\\Model\\Authordata1.json");
    }


    public ArrayList<Author> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(new File(file_path));    // Read JSON file

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String name = node.get("name").asText();
                    String email = node.get("email").asText();
                    String birthday = node.get("birthday").asText();
                    String gender = node.get("gender").asText();
                    String category = node.get("category").asText();

                    Author author = new Author(id,name,birthday,email,gender,category);
                    authors.add(author);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authors;
    }

    @Override
    public void writeJsonFile(ArrayList<Author> authors) {
        // Implement the writeJsonFile method here // You can use the ObjectMapper to write the list of authors to a JSON file
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < authors.size(); i++)
            {
                String author_str = Obj.writeValueAsString(authors.get(i)); // Converting the Java object into a JSON string
                System.out.println(author_str); // Displaying Java object into a JSON string
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Email");
        headers.add("Birthday");
        headers.add("Gender");
        headers.add("Category");
        return headers;
    }

    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the FootballPlayer object
    at the specified index in the students list and then extracts the various attributes of the student such as their name, height, weight,
    etc. These attributes are then added to the ArrayList and returned.
     */
    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> author_details = new ArrayList<String>();

       author_details.add(String.valueOf(authors.get(line).getId()));
       author_details.add(authors.get(line).getName());
       author_details.add(authors.get(line).getEmail());
       author_details.add(authors.get(line).getBirthday());
       author_details.add(String.valueOf(authors.get(line).getGender()));
       author_details.add(authors.get(line).getCategory());
       return author_details;
    }

    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */
    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>>authors_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            authors_subset.add(getLine(i));
        }
        return authors_subset;
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

    public static ArrayList getTable() {
        return authors;
    }
}