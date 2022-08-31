package Service;

import dto.BookDto;
import java.util.List;

public interface BookService {
    List<BookDto> getAllBooks();

    void createBook(BookDto bookDto);
}
