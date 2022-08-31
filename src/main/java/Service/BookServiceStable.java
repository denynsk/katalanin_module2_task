package Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import dto.BookDto;
import Service.BookService;
import java.util.List;
import java.util.UUID;

@Service
@Profile("DEV")
public class BookServiceStable implements BookService {
        @Value("${book.defaultAuthor}")
        private String defaultAuthor;
        @Value("${book.defaultName}")
        private String defaultName;
        @Value("${book.defaultYear}")
        private int defaultYear;

        @Override
        public List<BookDto> getAllBooks() {
            BookDto bookDto = new BookDto();
            bookDto.setId(UUID.randomUUID());
            bookDto.setName(defaultName);
            bookDto.setYear(defaultYear);
            bookDto.setAuthor(defaultAuthor);
            return List.of(bookDto);
        }

        @Override
        public void createBook(BookDto bookDto) {

        }
    }

