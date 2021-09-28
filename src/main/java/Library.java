import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private Integer capacity;
    private ArrayList<Book> stock;
    private HashMap<String, Integer> booksByGenre;

    public Library(Integer capacity){
        this.capacity = capacity;
        this.stock = new ArrayList<>();
        this.booksByGenre = new HashMap<>();
    }

    public Object getCapacity() {
        return this.capacity;
    }

    public void addBook(Book book) {
        this.stock.add(book);
    }

    public int countStock() {
        return this.stock.size();
    }

    public Book removeBook() {
        return this.stock.remove(0);
    }

    public void checkOutBook(Borrower borrower) {
        if(borrower.canBorrow()){
            Book book = this.removeBook();
            borrower.addBook(book);
        }
    }

    public int getBooksByGenre(String key){
        addToHashMap();
        return booksByGenre.get(key);
    }


    private void addToHashMap(){
        for (int i=0; i < countStock(); i++){
            String bookKey = this.stock.indexOf(i);
            if (this.booksByGenre.containsKey(this.stock.get(i))){

            } else {
                this.booksByGenre.put(String.valueOf(this.stock.get(i)), 1);
            }
        }
    }
}
