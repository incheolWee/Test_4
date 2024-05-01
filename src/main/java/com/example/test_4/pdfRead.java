//package com.example.test_4;
//
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfReader;
//import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
//
//import java.io.IOException;
//
//public class pdfRead {
//    public static void main(String[] args){
//        String file = "path/result/new.pdf";
//        try{
//            readpdf(file);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//    private static void readpdf(String file) throws IOException {
//        PdfReader pr = new PdfReader(file);
//        PdfDocument doc = new PdfDocument(pr);
//        int num = doc.getNumberOfPages();
//
//        for (int i = 1; i <= num; i++) {
//            String str = PdfTextExtractor.getTextFromPage(doc.getPage(i));
//            System.out.println(str);
//        }
//    }
//}
