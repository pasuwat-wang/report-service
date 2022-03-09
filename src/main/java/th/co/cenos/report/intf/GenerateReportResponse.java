package th.co.cenos.report.intf;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerateReportResponse {
    private String result;
    private String fileName;
    private String message;
}
