package kg.apps.CBMapp.service;

import kg.apps.CBMapp.model.Contact;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface PdfFileService {

    boolean getContacsInPdf(Iterable<Contact> contacts);

}
