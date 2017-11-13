package vn.myclass.api.test;

import org.testng.annotations.Test;
import vn.myclass.model.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 31/7/2017.
 */
public class reviewHashMap {

    /*@Test
    public void checkHashMap() {
        Book b1= returnBookModel(101,"Let us C","Yashwant Kanetkar","BPB",8);
        Book b2= returnBookModel(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Book b3= returnBookModel(103,"Operating System","Galvin","Wiley",6);
        Book b4= returnBookModel(104,"Java Web","","tung lam", 9);
        Map<Integer, Book> map = new HashMap<Integer, Book>();
        map.put(1, b1);
        map.put(2, b2);
        map.put(3, b3);
        map.put(3, b4);
        for (Map.Entry<Integer, Book> item: map.entrySet()) {
            System.out.println(item.getKey()+ " detail");
            Book value = item.getValue();
            System.out.println(value.getId() +" ,"+ value.getName() +" ,"+ value.getAuthor() +" ,"+ value.getPublisher() +" ,"+ value.getQuantity());
        }
    }

    private Book returnBookModel(int id, String name, String author, String publisher, int quantity) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setQuantity(quantity);
        return book;
    }*/
}
