package com.itsm.pub.courses.patients.front.menu;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Qualifier("topLevelMenuItem")
public @interface TopLevelMenu {
}
