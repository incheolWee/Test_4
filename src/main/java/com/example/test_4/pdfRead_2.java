package com.example.test_4;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PRTokeniser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class pdfRead_2 {
    public static void main(String[] args) {
        String file = "path/result/new.pdf";
        try {
            readPdf(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readPdf(String file) throws IOException {
        PdfReader reader = new PdfReader(file);
        try {
            int numPages = reader.getNumberOfPages();
            for (int i = 1; i <= numPages; i++) {
                byte[] contentBytes = reader.getPageContent(i);
                PRTokeniser tokeniser = new PRTokeniser(contentBytes);
                StringBuilder extractedText = new StringBuilder();
                while (tokeniser.nextToken()) {
                    if (tokeniser.getTokenType() == PRTokeniser.TK_STRING) {
                        String text = tokeniser.getStringValue();
                        try {
                            // Assuming the PDF uses ISO encoding and trying to convert it to UTF-8
                            text = new String(text.getBytes("ISO-8859-1"), "UTF-8");
                            extractedText.append(text);
                        } catch (UnsupportedEncodingException e) {
                            extractedText.append(text);  // Fallback to the original text if encoding fails
                        }
                    }
                }
                System.out.println("Text from page " + i + ": " + extractedText.toString());
            }
        } finally {
            reader.close();
        }
    }
}
