package com.cleanAqruitect.CleanArquitect.infraestructura.controlador;

import com.cleanAqruitect.CleanArquitect.aplicacion.Servicio.AccountService;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.AccountDto;
import com.cleanAqruitect.CleanArquitect.aplicacion.dto.ReportJson;
import com.cleanAqruitect.CleanArquitect.infraestructura.Report.ReportPDF;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("reportes")
public class Report {

    @Autowired
    AccountService accountService;

    @Autowired
    ReportPDF reportPDF;

    @GetMapping("/")
    public ResponseEntity<List<ReportJson>> findAccountByNroAccount(@RequestParam String clientId,
                                                                    @RequestParam String fechaIni, @RequestParam String fechaFin) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1 = formato.parse(fechaIni);
        Date fecha2 = formato.parse(fechaFin);
        List<ReportJson> reportJsons = accountService.fetchReportAccountJson(clientId, fecha1, fecha2);
        return   ResponseEntity.status(HttpStatus.OK).body(reportJsons);
    }

    @GetMapping("/pdf")
    public ResponseEntity<String> generatePdfReport(HttpServletResponse response,
      @RequestParam String clientId, @RequestParam String fechaIni,
       @RequestParam String fechaFin) throws IOException, DocumentException, ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha1 = formato.parse(fechaIni);
        Date fecha2 = formato.parse(fechaFin);
        List<AccountDto> accountDto = accountService.fetchReportAccount(clientId, fecha1, fecha2);
        byte[] data = reportPDF.generatePdfReport(response, accountDto);
        String base64String = Base64.getEncoder().encodeToString(data);
        return ResponseEntity.status(HttpStatus.OK).body(base64String);
    }

}
