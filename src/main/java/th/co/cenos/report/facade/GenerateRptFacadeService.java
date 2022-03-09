package th.co.cenos.report.facade;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import th.co.cenos.report.intf.GenerateReportResponse;
import th.co.cenos.report.service.ReportService;

@Service
public class GenerateRptFacadeService {

    @Autowired
    ApplicationContext context ;

    public GenerateReportResponse generate(String reportKey){
        if(StringUtils.isEmpty(reportKey)){
            return GenerateReportResponse.builder().result("ERROR").message("No Report Key").build();
        }

        ReportService service = (ReportService) context.getBean(reportKey);
        if(service == null){
           return GenerateReportResponse.builder().result("ERROR").message(String.format("No Report Found %s",reportKey)).build();
        }

        return service.execute();
    }
}
