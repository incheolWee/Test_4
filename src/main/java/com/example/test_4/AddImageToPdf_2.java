package com.example.test_4;


import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;


import java.io.FileOutputStream;
import java.io.IOException;

public class AddImageToPdf_2 {
    public static void main(String[] args) {
        // 작성할 PDF 경로
        String srcPdf = "path/original/original.pdf";
        // 새롭게 만들 PDF 경로
        String destPdf = "path/result/new.pdf";
        // 추가하고 싶은 이미지  경로
        String imagePath = "path/image/sign.png";
        try {
            //1. 작성할 원본 문서 읽기
            PdfReader reader = new PdfReader(srcPdf);
           //2. 새롭게 만들 문서 이름과 문서 붙이기
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destPdf));
            //3. 이미지 가져오기
            Image img = Image.getInstance(imagePath);  // Ensure this path is correct
            //지정 좌표 작성
            img.setAbsolutePosition(400,120);
            //이미지 크기 조절
            img.scaleToFit(100,100);
            //첫번째 페이지에 이미지 붙이기
            stamper.getOverContent(1).addImage(img);
            //종료
            stamper.close();
            reader.close();
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
