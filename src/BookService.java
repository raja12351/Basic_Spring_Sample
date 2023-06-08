import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BookService {
    static BookRepository bookRepository = new BookRepository();
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public void addAuthor(Author author) {
        bookRepository.addAuthor(author);
    }

    public Book updatePages(int noOfPages, String bookName) throws RuntimeException {
        Optional<Book> bookOptional = bookRepository.getBookByName(bookName);
        if(bookOptional.isEmpty()){
            throw new RuntimeException("Can not find the book by name :" + bookName);
        }
        Book book = bookOptional.get();
        book.setPages(noOfPages);
        bookRepository.addBook(book);
        return book;
    }

    public List<String> listOfAuthors() {
        List<Book> books = bookRepository.getAllBooks();
        Collections.sort(books,(a,b)->{
            return b.getPages()-a.getPages();
        });
        int maxPages = books.get(0).getPages();
        List<String> authors = new ArrayList<>();
        for(Book book : books){
            if(book.getPages()==maxPages){
                authors.add(book.getAuthor_name());
            }
        }
        return authors;
    }
}
