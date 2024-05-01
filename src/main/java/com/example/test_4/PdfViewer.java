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
        BufferedImage image = renderer.renderImageWithDPI(0, 96); // Render with 96 DPI to match screen resolution

        ImageIcon imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("Mouse Click at: x=" + e.getX() + ", y=" + e.getY());
            }
        });

        // Use a JScrollPane to handle larger images and add scroll capabilities
        JScrollPane scrollPane = new JScrollPane(label);
        add(scrollPane, BorderLayout.CENTER);

        // Set the size of the JFrame to match A4 dimensions at 96 DPI
        setSize(new Dimension(794, 1123));
        setLocationRelativeTo(null); // Center the window on the screen

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
