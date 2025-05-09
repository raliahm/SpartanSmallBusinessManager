package com.csc340.spartan_manager.administration_portal.Entity;

import com.mysql.cj.xdevapi.UpdateType;
import jakarta.persistence.*;
import net.jcip.annotations.Immutable;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "session_update_records")
public class SessionUpdateRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sessionId;

    @Column(unique = true)
    private String logicalSessionId;

    private UpdateType updateType;

    @ElementCollection
    @CollectionTable(name = "provider_updates", joinColumns = @JoinColumn(name = "record_id"))
    private List<EntityUpdateEntry> providerUpdates;

    @ElementCollection
    @CollectionTable(name = "business_updates", joinColumns = @JoinColumn(name = "record_id"))
    private List<EntityUpdateEntry> businessUpdates;

    @ElementCollection
    @CollectionTable(name = "customer_updates", joinColumns = @JoinColumn(name = "record_id"))
    private List<EntityUpdateEntry> customerUpdates;

    @ElementCollection
    @CollectionTable(name = "event_updates", joinColumns = @JoinColumn(name = "record_id"))
    private List<EntityUpdateEntry> eventUpdates;

    private String snapshotJson;

    private Timestamp createdAt;
    private String createdBy;
    private Boolean requiresAdminReview = false;
    private String reasonOrNote;



    private boolean completed = false;
    private Timestamp finalizedAt;

    public int getSessionId() {
        return sessionId;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public List<EntityUpdateEntry> getProviderUpdates() {
        return providerUpdates;
    }

    public List<EntityUpdateEntry> getBusinessUpdates() {
        return businessUpdates;
    }

    public List<EntityUpdateEntry> getCustomerUpdates() {
        return customerUpdates;
    }

    public List<EntityUpdateEntry> getEventUpdates() {
        return eventUpdates;
    }

    public String getSnapshotJson() {
        return snapshotJson;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Boolean getRequiresAdminReview() {
        return requiresAdminReview;
    }

    public String getReasonOrNote() {
        return reasonOrNote;
    }



    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }

    public void setProviderUpdates(List<EntityUpdateEntry> providerUpdates) {
        this.providerUpdates = providerUpdates;
    }

    public void setBusinessUpdates(List<EntityUpdateEntry> businessUpdates) {
        this.businessUpdates = businessUpdates;
    }

    public void setCustomerUpdates(List<EntityUpdateEntry> customerUpdates) {
        this.customerUpdates = customerUpdates;
    }

    public void setEventUpdates(List<EntityUpdateEntry> eventUpdates) {
        this.eventUpdates = eventUpdates;
    }

    public void setSnapshotJson(String snapshotJson) {
        this.snapshotJson = snapshotJson;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setRequiresAdminReview(Boolean requiresAdminReview) {
        this.requiresAdminReview = requiresAdminReview;
    }

    public void setReasonOrNote(String reasonOrNote) {
        this.reasonOrNote = reasonOrNote;
    }

    public String getLogicalSessionId() {
        return logicalSessionId;
    }

    public void setLogicalSessionId(String logicalSessionId) {
        this.logicalSessionId = logicalSessionId;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Timestamp getFinalizedAt() {
        return finalizedAt;
    }

    public void setFinalizedAt(Timestamp finalizedAt) {
        this.finalizedAt = finalizedAt;
    }

    public enum UpdateType {
        CREATED("Created"),
        MODIFIED("Modified"),
        DELETED("Deleted");

        private String description;

        // Constructor for enum constants
        UpdateType(String description) {
            this.description = description;
        }

        // Getter for the description
        public String getDescription() {
            return description;
        }

        // Inner class inside the enum
        public class UpdateDetail {

            private String detail;
            private String additionalInfo;

            // Constructor for inner class
            public UpdateDetail(String detail, String additionalInfo) {
                this.detail = detail;
                this.additionalInfo = additionalInfo;
            }

            // Getter for the detail
            public String getDetail() {
                return detail;
            }

            // Getter for additionalInfo
            public String getAdditionalInfo() {
                return additionalInfo;
            }

            // Method for printing detailed information
            public void printDetail() {
                System.out.println("Detail: " + detail);
                System.out.println("Additional Info: " + additionalInfo);
            }
        }
    }
}
