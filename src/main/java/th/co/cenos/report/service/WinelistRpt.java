package th.co.cenos.report.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import th.co.cenos.report.intf.GenerateReportResponse;

@Service
@Qualifier("winelistRpt")
public class WinelistRpt implements ReportService {

    public GenerateReportResponse execute() {
        return GenerateReportResponse.builder().result("success").message("OK").build();
    }
}
