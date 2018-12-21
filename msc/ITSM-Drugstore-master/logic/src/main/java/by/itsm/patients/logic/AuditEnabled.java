package by.itsm.patients.logic;

import org.springframework.stereotype.Component;

@Component
public class AuditEnabled {

    private boolean isEnabled;

    public AuditEnabled() {
        this.isEnabled = isEnabled;
    }

    public void setEnabled(boolean isEnabled){
        this.isEnabled = isEnabled;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
}
