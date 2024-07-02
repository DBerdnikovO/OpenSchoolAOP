package ru.berdnikov.openschoolaop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author danilaberdnikov on Asynchronously.
 * @project OpenSchoolAOP
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Asynchronously {
}