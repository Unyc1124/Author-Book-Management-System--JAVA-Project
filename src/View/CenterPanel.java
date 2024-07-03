package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CenterPanel extends JPanel {

    ArrayList<JButton> header_buttons = new ArrayList<>();
    ArrayList<JButton> author_buttons = new ArrayList();

    public CenterPanel() {
        super();
    }

    public void createDisplay(int rows, int cols) {
        header_buttons.clear();
        author_buttons.clear();
        this.removeAll();
        this.revalidate();
        this.repaint();
        this.setLayout(new GridLayout(rows + 1, cols));

        // Create header buttons based on the number of columns
        for (int i = 1; i <= cols; i++) {
            JButton b = new JButton();
            b.setBackground(Color.pink);
            b.setPreferredSize(new Dimension(80, 25));
            header_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }

        // Create author buttons based on the number of rows and columns
        for (int i = 1; i <= rows * cols; i++) {
            JButton b = new JButton();
            b.setBackground(Color.orange);
            b.setPreferredSize(new Dimension(120, 25));
            author_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }

    public void updateDisplay(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            setHeaderButtonText(i, headers.get(i));
        }

        for (int author_no = 0; author_no < lines.size(); author_no++) {
            for (int author_col_no = 0; author_col_no < headers.size(); author_col_no++) {
                int button_no = author_no * headers.size() + author_col_no;
                String button_txt = lines.get(author_no).get(author_col_no);
                setAuthorButtonText(button_no, button_txt);
            }
        }
    }

    public void setHeaderButtonText(int button_no, String button_text) {
        header_buttons.get(button_no).setText(button_text);
    }

    public void setAuthorButtonText(int button_no, String button_text) {
        author_buttons.get(button_no).setText(button_text);
    }

    public ArrayList<JButton> getHeaderButtons() {
        return header_buttons;
    }

    public ArrayList<JButton> getAuthorButtons() {
        return author_buttons;
    }
}