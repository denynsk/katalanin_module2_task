package Service;

import Entity.Book;
import dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("PROD")
public class BookServiceDB implements BookService {
    @Value("${book.defaultAuthor}")
    private String defaultAuthor;
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceDB(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        books.forEach(book -> {
            BookDto bookDto = new BookDto()
                    .setId(book.getId())
                    .setName(book.getName())
                    .setAuthor(book.getAuthor())
                    .setYear(book.getYear());
            bookDtoList.add(bookDto);
        });
        return bookDtoList;
    }

    @Override
    public void createBook(BookDto bookDto) {
        Book book = new Book()
                .setName(bookDto.getName())
                .setYear(bookDto.getYear())
                .setAuthor(bookDto.getAuthor());
        List<Book> arrayList = new ArrayList<>();
        arrayList.add(book);
        bookRepository.saveAll(arrayList);
    }

}
