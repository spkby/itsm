package front.utils.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
/*@Target(ElementType.METHOD)
@Inherited*/
public @interface Auditable {
    AuditOperationType AUDIT_TYPE();
    AuditEntityType ENTITY_TYPE();
}
