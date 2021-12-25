package IRCTC.dto;

import java.io.Serializable;

public class FromToFilterCriteriaDTO implements Serializable {

    private String sourceId;
    private String destId;
    private String journeyDate;

    public FromToFilterCriteriaDTO(String sourceId, String destId, String journeyDate) {
        super();
        this.sourceId = sourceId;
        this.destId = destId;
        this.journeyDate = journeyDate;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getDestId() {
        return destId;
    }

    public void setDestId(String destId) {
        this.destId = destId;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

}
