package Model;

import java.util.Scanner;

public class Book extends Literature implements BookSumm{
    /* Book attributes */
    private String bookName;
    private String language;
    private int edition;
    private int copiesSold;
    private double pricePerCopy;


   //constructor
    public Book(int iid,String genre, String publicationDate, String bookName,String language,  int edition,int copiesSold,double pricePerCopy) {
        super(iid,genre,publicationDate);
        setBookName(bookName);
        setLanguage(language);
        setEdition(edition);
        setCopiesSold(copiesSold);
        setPricePerCopy(pricePerCopy);

    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public void setPricePerCopy(double pricePerCopy) {
        this.pricePerCopy = pricePerCopy;
    }

    public String getBookName() {
        return this.bookName;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getEdition() {
        return this.edition;
    }

    public int getCopiesSold() {
        return this.copiesSold;
    }

    public double getPricePerCopy() {
        return this.pricePerCopy;
    }

    public void checkBestSeller(int copiesSoldThreshold) {
        if (this.copiesSold > copiesSoldThreshold) {
            System.out.println(this.getBookName() + " is a bestseller!");
        } else {
            System.out.println(this.getBookName() + " is not a bestseller.");
        }

    }

    public void checkBestSeller() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to know if '" + this.getBookName() + "' is a bestseller? (Yes/No): ");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes")) {
            System.out.print("Enter the number of copies sold: ");
            int userCopiesSold = scanner.nextInt();
            if (userCopiesSold > 10000) {
                System.out.println(this.getBookName() + " is a bestseller!");
            } else {
                System.out.println(this.getBookName() + " is not a bestseller.");
            }
        } else if (response.equals("no")) {
            System.out.println("Okay, ignoring bestseller check.");
        } else {
            System.out.println("Invalid response. Ignoring bestseller check.");
        }

    }

    //public double calculateTotalRevenue() {
      //  return (double)this.getCopiesSold() * this.getPricePerCopy();
    //}

    public double calculateTotalRevenue() {
        try {
            return (double) this.getCopiesSold() * this.getPricePerCopy();
        } catch (ArithmeticException e) {
            System.err.println("An arithmetic error occurred: " + e.getMessage());
            return 0.0; // Return a default value or handle the error accordingly
        }
    }


    public String displayBook()
    {
        return "IiD: " + getIid() + "\n" +
                "Genre: " + getGenre() + "\n" +
                "Publication date: " + getPublicationDate() + "\n" +
                "Book Name : " + getBookName() + "\n" +
                "Language: " + getLanguage() + "\n" +
                "Edition: " + getEdition();
    }





}
