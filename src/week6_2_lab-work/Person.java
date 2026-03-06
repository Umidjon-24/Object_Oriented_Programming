public class Person {
    protected String name, id;
    protected int age;

    public Person(String name, String id, int age){
        this.name=name;
        this.id=id;
        this.age=age;
    }

    public void displayInfo(){
        System.out.printf("%s has %s ID and %d years old.", name, id, age);
    }
}

class Librarian extends Person{
    public Librarian(String name, String id, int age){
        super(name, id, age);
    }
    public void addBook(){
        System.out.println(name + "is adding book to the library");
    }
    public void removeBook(){
        System.out.println(name + "is removing book from the library");
    }
    public void issueBook(){
        System.out.println(name + " is issuing a book to the library");
    }
}

class Member extends Person{
    public Member(String name, String id, int age){
        super(name, id, age);
    }
    public void borrowBook(){
        System.out.println(name+" is borrowing a book from the library");
    }
    public void returnBook(){
        System.out.println(name+" is returning a book from the library");
    }
    public void viewBorrowedBooks(){
        System.out.println(name+" has these borrowed books from the library");
    }
}
class Guest extends Person{
    public Guest(String name, String id, int age){
        super(name, id, age);
    }
    public void viewCatalog(){
        System.out.println("Our guest "+name+" is watching the catalog");
    }
}
