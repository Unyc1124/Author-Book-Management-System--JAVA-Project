package Model;

public  class Author extends Artist implements AuthorDesc {
    private String category; // Additional attribute for the Author class

    // Constructors
    public Author(int id, String name, String birthday, String email, String gender,String category) {
        super( id,name, birthday, email,gender);
        setCategory(category);
    }

   // public Author(int id, String name,String birthday, String email,  String category) {
    //    super(id,name,birthday, email,category);
      //  setCategory(category);}

    public void setCategory(String category) {
        this.category = category;
    }// Setter for the 'category' attribute
    public String getCategory() {
        return this.category;
    } // Getter for the 'category' attribute

    // Implementation of the generateDescription method from the AuthorDesc interface
    @Override
    public String generateDescription() {
        return "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Birthday: " + getBirthday() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Gender: " + getGender() + "\n" +
                "Category: " + getCategory();
    }
    public String displayAuthor()
    {
        return "ID: " + getId() +"\t"+
                "Name: " + getName() + "\t" +
                "Birthday: " + getBirthday() +"\t"+
                "Email: " + getEmail() +  "\t"+
                "Gender: " + getGender() + "\t"+
                "Category: " + getCategory();
    }}
