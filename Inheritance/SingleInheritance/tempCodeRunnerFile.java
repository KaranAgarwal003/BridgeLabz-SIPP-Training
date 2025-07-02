class Book{
    String title;
    int publicationyear;
    void displayInfo(){
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationyear);
    }
}
class Author extends Book{
    String name;
    String bio;
    Author(String name, String bio, String title, int publicationyear) {
        this.name = name;
        this.bio = bio;
        this.title = title;
        this.publicationyear = publicationyear;
    }
    @Override
    void displayInfo() {
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
        super.displayInfo();
}
public class LibraryManagementWithBooksAndAuthors {
    public static void main(String[] args) {
        Author author = new Author("J.K. Rowling", "British author, best known for the Harry Potter series.", "Harry Potter", 1997);
        author.displayInfo();
    }
}
}