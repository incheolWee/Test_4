package com.example.test_4;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class pdfCreate_2 {
    public static void main(String[] args) {
        String file = "path/result/sample.pdf";
        try {
            createPdf(file);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createPdf(String file) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        // Create fonts
        Font largeFont = new Font(Font.TIMES_ROMAN, 28, Font.NORMAL);
        Font mediumFont = new Font(Font.TIMES_ROMAN, 18, Font.NORMAL);

        // Create and add paragraphs
        Paragraph p1 = new Paragraph("Hello, This is Delftstack!", largeFont);
        p1.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p1);

        Paragraph p2 = new Paragraph("We help you understand the concepts.", mediumFont);
        document.add(p2);

        document.close();
    }
}
