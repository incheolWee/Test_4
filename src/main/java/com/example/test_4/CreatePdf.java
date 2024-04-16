package com.example.test_4;
//버전 7로 작성
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

public class CreatePdf {
    public static void main(String args[]) throws Exception {
        // 파일 경로와 이름 지정
        String path = "path/result/output.pdf";
        PdfWriter writer = new PdfWriter(path);

        // Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // pdf로 페이지 생성
        Document document = new Document(pdf, PageSize.A4);
        //마진 20으로 설정
        document.setMargins(20, 20, 20, 20);

        // Add paragraph to the document
        Paragraph paragraph = new Paragraph("Hello, World!")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN))
                .setFontSize(12)
                .setTextAlignment(TextAlignment.CENTER);

        document.add(paragraph);

        // 문서 종료
        document.close();

        System.out.println("PDF Created!");
    }
}