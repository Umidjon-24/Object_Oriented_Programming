public class LibraryBook {
    String bookTitle="Unknown";
    String author="Unknown";
    int pages=1;

    public String getBookTitle(){
        return bookTitle;
    }
    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public int getPages(){
        return pages;
    }
    public void setPages(int pages){
        if (pages>0) this.pages=pages;
    }
    public boolean isThick(){
        if (pages>500) return true;
        else return false;
    }

}
