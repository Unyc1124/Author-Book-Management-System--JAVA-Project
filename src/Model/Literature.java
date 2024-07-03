package Model;

public abstract class Literature {
    /* Book attributes */
    private int iid;
    private String genre;
    private String publicationDate;

    public Literature(int iid, String genre, String publicationDate) {
        this.iid = iid;
        this.genre = genre;
        this.publicationDate = publicationDate;
    }

    /* Using Setter methods to set the values of the instance variables for Book */
    public void setIid(int iid) {
        this.iid = iid;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    /* Using getter methods to retrieve the values of the instance variables of Book */
    public int getIid() {
        return this.iid;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getPublicationDate() {
        return this.publicationDate;
    }
}

