package front.utils.annotation;

public enum AuditSuccessType {
    SUCCESS(1),FAILED(0);

    private Integer auditSuccessTypeId;

    AuditSuccessType(int auditSuccessTypeId) {
        this.auditSuccessTypeId = auditSuccessTypeId;
    }

    public Integer getAuditSuccessTypeId() {
        return auditSuccessTypeId;
    }
}
