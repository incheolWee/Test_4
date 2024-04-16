package com.example.test_4;
//버전 5로 작성
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

public class AddImageToPdf {
    public static void main(String[] args) {
        try {
            // File path of the existing PDF
            String srcPdf = "path/original/original.pdf";
            // File path where the new PDF will be saved
            String destPdf = "path/result/new.pdf";
            // Path to the image you want to add
            String imagePath = "path/image/sign.png";

            // Create a PdfReader instance to read the existing PDF document
            PdfReader reader = new PdfReader(srcPdf);
            // Create a PdfStamper instance to modify the PDF, using PdfReader and output destination
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destPdf));

            // Get the image and set its position and size
            Image image = Image.getInstance(imagePath);
            image.setAbsolutePosition(400, 120); // Position at (x=50, y=500)
            image.scaleToFit(100, 100); // Scale to fit within 100x100 units

            // Add the image to each page
            int n = reader.getNumberOfPages();
            for (int i = 1; i <= n; i++) {
                PdfContentByte content = stamper.getOverContent(i);
                content.addImage(image);
            }

            // Close the PdfStamper and PdfReader
            stamper.close();
            reader.close();
        } catch (IOException | com.itextpdf.text.DocumentException e) {
            e.printStackTrace();
        }
    }
}