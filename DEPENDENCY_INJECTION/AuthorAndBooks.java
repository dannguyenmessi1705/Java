package DEPENDENCY_INJECTION;

public class AuthorAndBooks {
    public static void main(String[] args) {
        Author[] authors = new Author[3];
        authors[0] = new Author("Dan", "messiprohy@gmail.com");
        authors[1] = new Author("Thang", "nguyenvanthanglootfreefire@gmail.com");
        authors[2] = new Author("Messi", "danprohy@gmail.com");
        Book book = new Book("Ky nang choi FreeFire", authors, 500000);
        System.out.println(book.getAuthorNames());

    }
    
}
class Author{
    private String name;
    private String email;
    public Author(String name, String email){
        this.name=name;
        this.email=email;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
}
class Book{
    private String name;
    private double price;
    private DEPENDENCY_INJECTION.Author[] authors;
    public Book(String name, Author[] authors, double price){
        this.name=name;
        this.authors=authors;
        this.price=price;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
public String getAuthorNames() {
		String authorNames = "";
		for (int i = 0; i < authors.length; i++) {
            if(i<authors.length - 1)
			authorNames += authors[i].getName() + ", ";
            else 
            authorNames += authors[authors.length - 1].getName();
		}
		
		return authorNames;
	}
}
