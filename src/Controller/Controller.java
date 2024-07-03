package Controller;

import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import View.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import Model.Model;
public class Controller {
    Model model;
    View view;
    public Controller(Model m, View v) {
        model = m;
        view = v;
       //view.centerInitialSetup(model.getManageAuthorData().getLinesBeingDisplayed(), model.getManageAuthorData().getHeaders().size());
     //  view.centerUpdate(model.getManageAuthorData().getLines(model.getManageAuthorData().getFirstLineToDisplay(), model.getManageAuthorData().getLastLineToDisplay()), model.getManageAuthorData().getHeaders());

        addButtonClick(m);
        addScrollingAuthor(m);
        addScrollingBook(m);
        addButtonClickCreateAuthor(m);
        try {
            addButtonClickCreateBook(m);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            addButtonClickEditAuthor(m);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            addButtonClickEditBook(m);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            addButtonClickDeleteAuthor(m);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            addButtonClickDeleteBook(m);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void addButtonClick(Model m)
    {
        view.getMf().getIp().getBp().getBtn_author().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Author Pressed");
                view.centerInitialSetup(model
                        .getManageAuthorData().getLinesBeingDisplayed(), model
                        .getManageAuthorData().getHeaders().size());

                view.centerUpdate(model
                        .getManageAuthorData().getLines(model
                                .getManageAuthorData().getFirstLineToDisplay(), model
                                .getManageAuthorData().getLastLineToDisplay()), model.getManageAuthorData().getHeaders());
            }
        });

        view.getMf().getIp().getBp().getBtn_book().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println("Book Pressed");
                view.centerInitialSetup(model.getManageBookData().getLinesBeingDisplayed(), model.getManageBookData().getHeaders().size());

                view.centerUpdate(model.getManageBookData().getLines(model.getManageBookData().getFirstLineToDisplay(), model.getManageBookData().getLastLineToDisplay()), model.getManageBookData().getHeaders());

            }
        });
    }

    private void addScrollingAuthor(Model m)
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageAuthorData().getFirstLineToDisplay();
                int current_last_line = model.getManageAuthorData().getLastLineToDisplay();
                int no_of_players = model.getManageAuthorData().getTable().size();
                int no_of_display_lines = model.getManageAuthorData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageAuthorData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageAuthorData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageAuthorData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageAuthorData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageAuthorData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageAuthorData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageAuthorData().getLines(model.getManageAuthorData().getFirstLineToDisplay(), model.getManageAuthorData().getLastLineToDisplay()), model.getManageAuthorData().getHeaders());
            }
        });
    }

    private void addScrollingBook(Model m)
    {
        view.getMf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getManageBookData().getFirstLineToDisplay();
                int current_last_line = model.getManageBookData().getLastLineToDisplay();
                int no_of_players = model.getManageBookData().getTable().size();
                int no_of_display_lines = model.getManageBookData().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getManageBookData().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getManageBookData().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getManageBookData().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_players-1)
                {
                    model.getManageBookData().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_players-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_players - no_of_display_lines)
                    {
                        new_first_line = no_of_players-no_of_display_lines;
                        model.getManageBookData().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getManageBookData().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdate(model.getManageBookData().getLines(model.getManageBookData().getFirstLineToDisplay(), model.getManageBookData().getLastLineToDisplay()), model.getManageBookData().getHeaders());
            }
        });
    }

    private void addButtonClickCreateAuthor(Model m) {
        view.getMf().getIp().getBp().getBtn_createauthor().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                System.out.println("Create Author Pressed");

                //   Scanner scanner = new Scanner(System.in);

                ObjectMapper mapper = new ObjectMapper();
                ArrayList< Author> authors;
                authors = m.getManageAuthorData().getTable();

                int id = authors.size() + 1;
                Frame frame = new Frame("Author Form");
                frame.setSize(400, 300);

                Label nameLabel = new Label("Author name:");
                TextField nameInput = new TextField(20);

                Label emailLabel = new Label("email:");
                TextField emailInput = new TextField(20);

                Label birthdayLabel = new Label("Birthday:");
                TextField birthdayInput = new TextField(20);

                Label genderLabel = new Label("gender:");
                TextField genderInput = new TextField(20);

                Label categoryLabel = new Label("Category:");
                TextField categoryInput = new TextField(20);

                Button confirmButton = new Button("Confirm");

                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String name = nameInput.getText();
                        String email = emailInput.getText();
                        String birthday= birthdayInput.getText();
                        String gender = genderInput.getText();
                        String category = categoryInput.getText();


                        // Create an Authors object with the input data
                        Author author = new Author(id, name, birthday, email, gender, category);
                        authors.add(author);
                        try {
                            mapper.writeValue(Paths.get("src/Model/Authordata1.json").toFile(), authors);
                        } catch (IOException ea) {
                            System.out.println("Error is " + ea);
                        }



                        JOptionPane.showMessageDialog(null, "Author created and added to the array with id " + authors.size());


                        frame.dispose();
                    }
                });

                frame.setLayout(new GridLayout(8, 2));
                frame.add(nameLabel);
                frame.add(nameInput);
                frame.add(emailLabel);
                frame.add(emailInput);
                frame.add(birthdayLabel);
                frame.add(birthdayInput);
                frame.add(genderLabel);
                frame.add(genderInput);
                frame.add(categoryLabel);
                frame.add(categoryInput);

                frame.add(confirmButton);

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }
        });
    }

    private void addButtonClickCreateBook(Model m) throws IOException {
        view.getMf().getIp().getBp().getBtn_createbook().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                System.out.println("Create Book Pressed");

                //   Scanner scanner = new Scanner(System.in);

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Book> books;
                books = m.getManageBookData().getTable();

                int iid = books.size() + 1;
                Frame frame = new Frame("Book Form");
                frame.setSize(400, 300);

                Label genre = new Label("Book Genre:");
                TextField genreInput = new TextField(20);

                Label publicationDate = new Label("Publication date:");
                TextField publicationDateInput = new TextField(20);

                Label bookName = new Label("Book Name");
                TextField bookNameInput = new TextField(20);

                Label language = new Label("Language");
                TextField languageInput = new TextField(20);

                Label edition = new Label("Edition");
                TextField editionInput = new TextField(20);

                Label copiesSold = new Label("Copies Sold");
                TextField copiesSoldInput = new TextField(20);

                Label pricePerCopy = new Label("Price per copy ");
                TextField pricePerCopyInput = new TextField(20);

                Button confirmButton = new Button("Confirm");

                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String genre = genreInput.getText();
                        String publicationDate = publicationDateInput.getText();
                        String bookName  = bookNameInput.getText();
                        String language = languageInput.getText();
                        int edition =Integer.parseInt(editionInput.getText());
                        int copiesSold  =Integer.parseInt(copiesSoldInput.getText());
                        double pricePerCopy =Double.parseDouble(pricePerCopyInput.getText());


                        // Create an Airports object with the input data
                        Book book = new Book(iid, genre, publicationDate, bookName, language, edition, copiesSold, pricePerCopy);
                        books.add(book);

                        try {
                            mapper.writeValue(Paths.get("src/Model/bookdata1.json").toFile(), books);
                        } catch (IOException ea) {
                            System.out.println("Error is " + ea);
                        }


                        JOptionPane.showMessageDialog(null, "Book created and added to the array with id " + books.size());

                        frame.dispose();
                    }
                });

                frame.setLayout(new GridLayout(6, 2));
                frame.add(genre);
                frame.add(genreInput);
                frame.add(publicationDate);
                frame.add(publicationDateInput);
                frame.add(bookName);
                frame.add(bookNameInput);
                frame.add(language);
                frame.add(languageInput);
                frame.add(edition);
                frame.add(editionInput);
                frame.add(copiesSold);
                frame.add(copiesSoldInput);
                frame.add(pricePerCopy);
                frame.add(pricePerCopyInput);

                frame.add(confirmButton);

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }
        });
    }

    private void addButtonClickEditAuthor(Model m) throws IOException {
        view.getMf().getIp().getBp().getBtn_editauthor().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JFrame frame = new JFrame("Author Editor");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLayout(new FlowLayout());

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Author> authors;
                authors = m.getManageAuthorData().getTable();

                JTextField idField = new JTextField(10);
                JButton editButton = new JButton("Edit Attribute");

                frame.add(new JLabel("Enter Author Id to Update: "));
                frame.add(idField);
                frame.add(editButton);

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id = Integer.parseInt(idField.getText());
                        String a = JOptionPane.showInputDialog("What do you wish to edit\n1.Author name\n2.Email\n3.Birthday\n4.Gender\n5.Category");
                        int choice = Integer.parseInt(a);
                        switch (choice) {
                            case 1:
                                String name = JOptionPane.showInputDialog("Enter new name of author:");
                                authors.get(id - 1).setName(name);
                                break;
                            case 2:
                                String email = JOptionPane.showInputDialog("Enter new email:");
                                authors.get(id - 1).setEmail(email);
                                break;
                            case 3:
                                String birthday = JOptionPane.showInputDialog("Enter new birthday:");
                                authors.get(id - 1).setbirthday(birthday);
                                break;
                            case 4:
                                String gender= JOptionPane.showInputDialog("Enter  gender:");
                                authors.get(id - 1).setGender(gender);
                                break;
                            case 5:
                                String category = JOptionPane.showInputDialog("Enter new Category:");
                                authors.get(id - 1).setCategory(category);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Sorry Invalid Choice");


                        }

                        try {
                            mapper.writeValue(Paths.get("src/Model/Authordata1.json").toFile(), authors);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Author data updated successfully.");
                        frame.dispose();
                    }
                });

                frame.setVisible(true);

            }
        });
    }

    private void addButtonClickEditBook(Model m) throws IOException {
        view.getMf().getIp().getBp().getBtn_editbook().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JFrame frame = new JFrame("Book Editor");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLayout(new FlowLayout());

                ObjectMapper mapper = new ObjectMapper();
                ArrayList<Book> books;
                books = m.getManageBookData().getTable();

                JTextField idField = new JTextField(10);
                JButton editButton = new JButton("Edit Attribute");

                frame.add(new JLabel("Enter Book Id to Update: "));
                frame.add(idField);
                frame.add(editButton);

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int iid = Integer.parseInt(idField.getText());
                        String a = JOptionPane.showInputDialog("What do you wish to edit\n1.Genre\n2.Publication date\n3.Book name\n4.Language\n5.Edition\n6.Copies sold\n7.Price per copy");
                        int choice = Integer.parseInt(a);
                        switch (choice) {
                            case 1:
                                String genre = JOptionPane.showInputDialog("Enter new genre:");
                                books.get(iid - 1).setGenre(genre);
                                break;
                            case 2:
                                String publicationDate = JOptionPane.showInputDialog("Enter new publication date:");
                                books.get(iid - 1).setPublicationDate(publicationDate);
                                break;
                            case 3:
                                String bookName = JOptionPane.showInputDialog("Enter new book name:");
                                books.get(iid - 1).setBookName(bookName);
                                break;
                            case 4:
                                String language = JOptionPane.showInputDialog("Enter new Language:");
                                books.get(iid - 1).setLanguage(language);
                                break;
                            case 5:
                               int edition = Integer.parseInt(JOptionPane.showInputDialog("Enter new edition:"));
                                books.get(iid - 1).setEdition(Integer.parseInt(String.valueOf(edition)));
                                break;
                            case 6:
                                int copiesSold = Integer.parseInt(JOptionPane.showInputDialog("Enter copies sold:"));
                                books.get(iid - 1).setCopiesSold(Integer.parseInt(String.valueOf(copiesSold)));
                                break;
                            case 7:
                                double pricePerCopy = Double.parseDouble(JOptionPane.showInputDialog("Enter new price:"));
                                books.get(iid - 1).setPricePerCopy(Double.parseDouble(String.valueOf(pricePerCopy)));
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Sorry Invalid Choice");


                        }

                        try {
                            mapper.writeValue(Paths.get("src/Model/bookdata1.json").toFile(), books);
                        } catch (IOException ex) {
                            System.out.println(ex);
                        }

                        JOptionPane.showMessageDialog(null, "Book data updated successfully.");
                        frame.dispose();
                    }
                });

                frame.setVisible(true);

            }

        });
    }


    private void addButtonClickDeleteAuthor(Model m) throws IOException {
        view.getMf().getIp().getBp().getBtn_delauthor().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JFrame frame = new JFrame("Delete Author");
                frame.setSize(300, 150);
                frame.setLayout(new FlowLayout());

                JLabel idLabel = new JLabel("Enter Author ID to Delete:");
                JTextField idInput = new JTextField(10);

                JButton deleteButton = new JButton("Delete");

                frame.add(idLabel);
                frame.add(idInput);
                frame.add(deleteButton);

                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int IdToDelete = Integer.parseInt(idInput.getText());

                            ArrayList<Author> authors = m.getManageAuthorData().getTable();

                            if (IdToDelete >= 1 && IdToDelete <= authors.size()) {
                                String Name = authors.get(IdToDelete - 1).getName();
                                authors.remove(IdToDelete - 1);

                                ObjectMapper mapper = new ObjectMapper();
                                try {
                                    mapper.writeValue(Paths.get("src/Model/Authordata1.json").toFile(), authors);
                                    JOptionPane.showMessageDialog(frame, "Author Deleted: " + Name);
                                } catch (IOException ex) {
                                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame, "Invalid Author ID");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                        }
                        frame.dispose();
                    }

                });

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }

        });
    }


    private void addButtonClickDeleteBook(Model m) throws IOException {
        view.getMf().getIp().getBp().getBtn_delbook().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JFrame frame = new JFrame("Delete Book");
                frame.setSize(300, 150);
                frame.setLayout(new FlowLayout());

                JLabel idLabel = new JLabel("Enter book ID to Delete:");
                JTextField idInput = new JTextField(10);

                JButton deleteButton = new JButton("Delete");

                frame.add(idLabel);
                frame.add(idInput);
                frame.add(deleteButton);

                deleteButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            int IidToDelete = Integer.parseInt(idInput.getText());

                            ArrayList<Book> books = m.getManageBookData().getTable();

                            if (IidToDelete >= 1 && IidToDelete <= books.size()) {
                                String bookName = books.get(IidToDelete - 1).getBookName();
                               books.remove(IidToDelete - 1);

                                ObjectMapper mapper = new ObjectMapper();
                                try {
                                    mapper.writeValue(Paths.get("src/Model/bookdata1.json").toFile(), books);
                                    JOptionPane.showMessageDialog(frame, "Book Deleted: " + bookName);
                                } catch (IOException ex) {
                                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame, "Invalid Book ID");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                        }
                        frame.dispose();
                    }
                });

                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        frame.dispose();
                    }
                });

                frame.setVisible(true);
            }

        });
    }






}
