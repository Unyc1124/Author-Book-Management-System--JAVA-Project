package View;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel  extends JPanel {
    JButton btn_author = new JButton();
    JButton btn_book = new JButton();

    JButton btn_createauthor = new JButton();

    JButton btn_createbook = new JButton();
    JButton btn_editauthor = new JButton();
    JButton btn_editbook = new JButton();
    JButton btn_delauthor = new JButton();
    JButton btn_delbook = new JButton();

    public ButtonPanel(){
        btn_author.setBackground(Color.pink);
        btn_author.setPreferredSize(new Dimension(80,25));
        btn_author.setText("Authors");
        this.add(btn_author);
        validate();
        repaint();
        btn_book.setBackground(Color.pink);
        btn_book.setPreferredSize(new Dimension(80,25));
        btn_book.setText("Books");
        this.add(btn_book);
        validate();
        repaint();

        btn_createauthor.setBackground(Color.pink);
        btn_createauthor.setPreferredSize(new Dimension(120,25));
        btn_createauthor.setText("Create Author");
        this.add(btn_createauthor);
        validate();
        repaint();
        btn_createbook.setBackground(Color.pink);
        btn_createbook.setPreferredSize(new Dimension(120,25));
        btn_createbook.setText("Create Book");
        this.add(btn_createbook);
        validate();
        repaint();
        btn_editauthor.setBackground(Color.pink);
        btn_editauthor.setPreferredSize(new Dimension(120,25));
        btn_editauthor.setText("Update Author");
        this.add(btn_editauthor);
        validate();
        repaint();
        btn_editbook.setBackground(Color.pink);
        btn_editbook.setPreferredSize(new Dimension(120,25));
        btn_editbook.setText("Update Book");
        this.add(btn_editbook);
        validate();
        repaint();
        btn_delauthor.setBackground(Color.pink);
        btn_delauthor.setPreferredSize(new Dimension(120,25));
        btn_delauthor.setText("Delete Author");
        this.add(btn_delauthor);
        validate();
        repaint();
        btn_delbook.setBackground(Color.pink);
        btn_delbook.setPreferredSize(new Dimension(120,25));
        btn_delbook.setText("Delete book");
        this.add(btn_delbook);
        validate();
        repaint();

    }

    public JButton getBtn_author() {
        return btn_author;
    }

    public JButton getBtn_book() {
        return btn_book;
    }
    public JButton getBtn_createauthor() {
        return btn_createauthor;
    }
    public JButton getBtn_createbook(){
        return  btn_createbook;
    }

    public JButton getBtn_editauthor() {
        return btn_editauthor;
    }
    public JButton getBtn_editbook() {
        return btn_editbook;
    }
    public JButton getBtn_delauthor() {
        return btn_delauthor;
    }
    public JButton getBtn_delbook() {
        return btn_delbook;
    }
}
