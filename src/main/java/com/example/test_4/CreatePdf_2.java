package com.example.test_4;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CreatePdf_2 {
    public static void main(String[] args) {
        // 파일 경로와 이름 지정
        String path = "path/result/output.pdf";
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            // Set margins
            document.setMargins(20, 20, 20, 20);
            document.newPage();

            // 폰트와 단락 설정
            Font font = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL);
            Paragraph paragraph = new Paragraph("Hello, World!", font);
            paragraph.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph);

            System.out.println("PDF Created!");
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}
