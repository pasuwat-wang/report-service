package th.co.cenos.report;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.co.cenos.report.intf.GenerateReportResponse;
import th.co.cenos.report.facade.GenerateRptFacadeService;
import th.co.cenos.util.JsonUtil;

@RestController
@Slf4j
@RequestMapping("/reportService")
public class ReportController {

    @Autowired
    GenerateRptFacadeService generateRptFacadeService;

    @Autowired
    JsonUtil jsonUtil;

    @GetMapping(path = "/generate/{reportKey}")
    @ResponseBody
    public GenerateReportResponse generate(@PathVariable  String reportKey){
        log.info("Generate Report {}",reportKey);
        GenerateReportResponse response = generateRptFacadeService.generate(reportKey);
        log.info("Generate Report Response {}", jsonUtil.toJsonString(response));
        return response;
    }

}
