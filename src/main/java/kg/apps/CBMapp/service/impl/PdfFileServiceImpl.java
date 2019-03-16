package kg.apps.CBMapp.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import kg.apps.CBMapp.model.Contact;
import kg.apps.CBMapp.model.ContactEmail;
import kg.apps.CBMapp.model.ContactMobile;
import kg.apps.CBMapp.service.PdfFileService;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@Service
public class PdfFileServiceImpl implements PdfFileService {

    SimpleDateFormat dateFormat =new SimpleDateFormat("dd-MMMMM-yyyy");


    @Override
    public boolean getContacsInPdf(Iterable<Contact> contacts) {

        try {
            Document document = new Document(PageSize.A4.rotate());
            document.setMargins(5,5,5,5);

            PdfWriter.getInstance(document, new FileOutputStream("Contacts.pdf"));

            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Paragraph headerText = new Paragraph();

            Chunk chunk = new Chunk("Contacts\n\n", font);
            headerText.add(chunk);
            headerText.setAlignment(Element.ALIGN_CENTER);

            document.add(headerText);

            PdfPTable table = new PdfPTable(7);
            addTableHeader(table);

            for (Contact contact :
                    contacts) {
                addRows(table,contact);
            }


            document.add(table);
            document.close();

            return true;
        }catch (Exception e){
            return false;
        }
    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Name", "Surname", "Nickname","Birthday","Company", "Phone Numbers","Emails")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRows(PdfPTable table,Contact contact) {
        table.addCell(contact.getName());
        table.addCell(contact.getSurname());
        table.addCell(contact.getNickname());
        table.addCell(dateFormat.format(contact.getBirthday()));
        table.addCell(contact.getCompany());

        StringBuilder stringMobiles=new StringBuilder();
        int n=1;
        for (ContactMobile mobile :
                contact.getMobiles()) {
            if (n!=1) stringMobiles.append('\n');
            stringMobiles.append(mobile.getPhoneNumber());
            n++;
        }

        table.addCell(stringMobiles.toString());

        StringBuilder stringEmails=new StringBuilder();
        n=1;
        for (ContactEmail email :
                contact.getEmails()) {
            if (n!=1) stringEmails.append("\n\n");
            stringEmails.append(email.getEmail());
            n++;
        }

        table.addCell(stringEmails.toString());

    }

    private void addCustomRows(PdfPTable table)
            throws URISyntaxException, BadElementException, IOException {
        Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
        Image img = Image.getInstance(path.toAbsolutePath().toString());
        img.scalePercent(10);

        PdfPCell imageCell = new PdfPCell(img);
        table.addCell(imageCell);

        PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
        horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(horizontalAlignCell);

        PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
        verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        table.addCell(verticalAlignCell);
    }



}