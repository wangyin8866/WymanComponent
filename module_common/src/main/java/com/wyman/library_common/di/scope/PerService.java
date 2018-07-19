package com.wyman.library_common.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerService {
}
