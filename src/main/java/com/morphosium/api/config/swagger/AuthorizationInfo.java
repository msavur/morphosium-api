package com.morphosium.api.config.swagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ApiImplicitParams({
        @ApiImplicitParam(name = "Authorization", value = "Request needs Authorization Token", paramType = "header", dataTypeClass = String.class, required = true),
})
public @interface AuthorizationInfo {
}