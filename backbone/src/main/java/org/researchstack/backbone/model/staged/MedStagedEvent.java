package org.researchstack.backbone.model.staged;

import org.researchstack.backbone.task.Task;

import java.util.Date;

/**
 * Created by mauriciosouto on 7/9/17.
 */

public class MedStagedEvent {

    private String activity;
    private Date eventStartDate;
    private Date eventEndDate;
    private MedStagedActivityState status;
    private Task result;

    public MedStagedEvent() {
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public MedStagedActivityState getStatus() {
        return status;
    }

    public void setStatus(MedStagedActivityState status) {
        this.status = status;
    }

    public Task getResult() {
        return result;
    }

    public void addResult(Task result, MedStagedActivityState status) {
        this.result = result;
        this.status = status;
    }
}
