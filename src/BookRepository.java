import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class BookRepository {
    HashMap<String,Book> bookData = new HashMap<>();
    HashMap<String,Author> authorData = new HashMap<>();
    public void addBook(Book book) {
        bookData.put(book.getName() , book);
    }

    public void addAuthor(Author author) {
        authorData.put(author.getName() , author);
    }

    public Optional<Book> getBookByName(String bookName) {
        for(String books : bookData.keySet()){
            if(books.equals(bookName)){
                return Optional.of(bookData.get(books));
            }
        }
        return Optional.empty();
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookData.values());
    }
}
