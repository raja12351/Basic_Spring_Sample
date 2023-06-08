import java.util.List;

//@RestController
//@AllArgsConstructor
//@NoArgsConstructor
public class BookController {
    static BookService bookService = new BookService();

//    @PostMapping("/add-book")
    public static String addBook(Book book){
        bookService.addBook(book);
        return "Book added Successfully";
    }

//    @PostMapping("/add-author")
    public static String addAuthor(Author author){
        bookService.addAuthor(author);
        return "Author added Successfully";
    }

//    PutMapping("/update-pages")
//    public static ResponseEntity<String> updatePages(int noOfPages , String BookName){
//        Book book = bookService.updatePages(noOfPages,BookName);
//        return Re
//    }

//    GetMapping("/authors-with-max-pages")
    public static ResponseEntity<List<String>> listOfAuthors(){
        List<String> authors = bookService.listOfAuthors();
        return ResponseEntiy<authors,httpCode.OK>;
    }
}
