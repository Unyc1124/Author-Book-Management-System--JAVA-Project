package Model;

public abstract class Artist {

    /* Author attributes */
    private int id;
    private String name;
    private String birthday;
    private String email;
    private String gender;

    public Artist(int id,String name,String birthday, String email, String gender) {
        this.id = id;
        this.name = name;
        this.birthday=birthday;
        this.email = email;
        this.gender = gender;
    }
    /*Using Setter method to set the value of a field for author */

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setbirthday(String birthday) {
        this.birthday = birthday;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    /*Using getter method to retrieve the value of the private instance variable of authors */

    public int getId() {
        return this.id;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getGender() {
        return this.gender;
    }


    // Implementation of the generateDescription method from the AuthorDesc interface
    public abstract String generateDescription();

    public abstract String displayAuthor();
}



