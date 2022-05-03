package pl.library.libraryview.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.library.libraryview.model.Reader;
import pl.library.libraryview.repository.ReaderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;


    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader addReader(String firstName, String lastName, String address,
                            String telephoneNumber) {
        Reader reader = Reader.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .telephoneNumber(telephoneNumber)
                .registrationDate(LocalDate.now())
                .build();
        return readerRepository.save(reader);
    }

    public Optional<Reader> getReader(int readerId) {
        return readerRepository.findById(readerId);
    }

    public List<Reader> findReadersByFullName(String firstName, String lastName) {
        return readerRepository.findAllByFullName(firstName, lastName);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public void registerResignation(int readerId) {
        Reader reader = getReader(readerId).orElseThrow();
        reader.setResignationDate(LocalDate.now());
        readerRepository.save(reader);
    }

    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    public void deleteReader(Reader reader) {
        readerRepository.delete(reader);
    }

    public Optional<Reader> findById(Integer readerId) {
        return readerRepository.findById(readerId);
    }
}
