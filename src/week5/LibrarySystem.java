public class LibrarySystem {
    public void checkout(Professor professor, Book book){
        System.out.printf("Professor %s has checked out %s for research", professor.getName(), book.getTitle());
    }
}

class Book{
    private String title;
    private String author;

    public Book(String title, String author){
        this.title=title;
        this.author=author;
    }

    public String getTitle(){
        return title;
    }
}

class Professor{
    private String name;

    public Professor(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

