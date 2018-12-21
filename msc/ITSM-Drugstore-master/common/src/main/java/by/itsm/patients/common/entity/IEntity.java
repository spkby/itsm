package by.itsm.patients.common.entity;

public interface IEntity {

    Integer getId();

    default void setUpdatedBy(User user) {
    }

    default void setCreatedBy(User user) {
    }
}
