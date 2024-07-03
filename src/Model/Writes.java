package Model;

public class Writes{
    private String publication_date;
    Book ObjBook;
    Author ObjAuthor;

    public void author_writes_book(Author tempAuthor, Book tempBook, String temp_publication_date)
    {
        ObjAuthor = tempAuthor;
        ObjBook = tempBook;
        publication_date = temp_publication_date;
    }

  /*  public void display_book_publication()
    {
        System.out.println("The Book "+this.ObjBook.getBookName()+" written by "+this.ObjAuthor.getName()+ " was published on " + publication_date);
    }*/
}

