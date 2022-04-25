package pl.library.libraryview.service;

import org.springframework.web.bind.annotation.RestController;
import pl.library.libraryview.repository.ReaderRepository;

@RestController
public class ReaderService {

    private ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository) {
    }
}
