package com.iesvirgendelcarmen.proyecto.LeerCSV.modelo;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.io.FileOutputStream;

import javax.swing.JFrame;
import javax.swing.JTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerarPDF extends JFrame {
	private static final long serialVersionUID = 4504962558942944277L;
	
	public void print(JTable table) {
		Document document = new Document(PageSize.A4.rotate());
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("jTable.pdf"));
			int numeroDePaginas = table.getRowCount()/22;

			
			document.open();
			document.add(new Paragraph("Tabla de coches"));
			writer.newPage();
			PdfContentByte cb = writer.getDirectContent();
			
			PdfTemplate template = cb.createTemplate(800, 500);
			
			cb.saveState();
			@SuppressWarnings("deprecation")
			Graphics2D g2 = cb.createGraphicsShapes(800, 500);
			
			Shape oldClip = g2.getClip();
			g2.clipRect(0, 0, 800, 500);
			table.print(g2);
			g2.setClip(oldClip);
			
			g2.dispose();
			
			cb.restoreState();
			document.newPage();
			document.close();
			
			
			for(int i=0; i < numeroDePaginas; i++) {
				System.out.println("hol");
				document.newPage();
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
