package com.example.test_4;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfViewer extends JFrame {

    public PdfViewer(String title) throws IOException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() throws IOException {
        PDDocument document = PDDocument.load(new File("path/result/new.pdf"));
        PDFRenderer renderer = new PDFRenderer(document);
        BufferedImage image = renderer.renderImage(0);

        JLabel label = new JLabel(new ImageIcon(image));
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Mouse Click at: x=" + e.getX() + ", y=" + e.getY());
            }
        });

        JScrollPane scrollPane = new JScrollPane(label);
        add(scrollPane, BorderLayout.CENTER);
        pack();
        document.close();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                PdfViewer viewer = new PdfViewer("PDF Viewer");
                viewer.setVisible(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
