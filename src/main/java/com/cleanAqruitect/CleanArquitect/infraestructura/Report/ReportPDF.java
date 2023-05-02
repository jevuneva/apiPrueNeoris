package com.cleanAqruitect.CleanArquitect.infraestructura.Report;

import com.cleanAqruitect.CleanArquitect.aplicacion.dto.AccountDto;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.MovementDto;
import com.cleanAqruitect.CleanArquitect.dominio.entidad.Movement;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ReportPDF {

    public byte[] generatePdfReport(HttpServletResponse response,
                                                    List<AccountDto> accounts) throws IOException, DocumentException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        Paragraph paragraph = new Paragraph("Movimientos de " + accounts.get(0).getClient().getNombre());
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);

        PdfPTable table = new PdfPTable(7);
        table.addCell("Fecha");
        table.addCell("Nro Cuenta");
        table.addCell("Tipo Cuenta");
        table.addCell("Saldo Inicial");
        table.addCell("Estado");
        table.addCell("Movimiento");
        table.addCell("Saldo Disponible");
        for (AccountDto account  : accounts){
            for (Movement mov: account.getMovementList()){
                table.addCell(mov.getDateMov().toString());
                table.addCell(account.getNroAccount());
                table.addCell(account.getTypeAccount());
                table.addCell(String.valueOf(account.getInitBalance()));
                table.addCell(String.valueOf(account.getStatus()));
                table.addCell(mov.getTypeMove() + " "  +String.valueOf(mov.getValue()));
                table.addCell(String.valueOf(mov.getBalance()));

            }
        }
        document.add(table);
        document.close();

        byte[] pdfBytes = outputStream.toByteArray();

        //response.setContentType("application/pdf");
        //response.setHeader("Content-Disposition", "inline; filename=report.pdf");
        //response.setContentLength(pdfBytes.length);

        return pdfBytes;
    }

}
