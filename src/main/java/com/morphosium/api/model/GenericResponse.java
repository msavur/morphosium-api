package com.morphosium.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.morphosium.api.config.jwt.exception.AuthenticationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class GenericResponse<T> implements Serializable {

    private static String SUCCESS = "Success";
    private static String BAD_REQUEST = "Bad Request";
    private static String NOT_FOUND = "Not Found";

    private static final long serialVersionUID = 7208220849220984767L;
    private transient String message;
    private transient int responseStatus;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private transient T data;


    public GenericResponse(String message, T data, int responseStatus) {
        this.message = message;
        this.data = data;
        this.responseStatus = responseStatus;
    }

    public static <T> GenericResponse<T> error(String message) throws AuthenticationException {
        return createGenericResponse(HttpStatus.UNAUTHORIZED.value(), message, null);
    }

    public static <T> GenericResponse<T> empty() {
        return createGenericResponse(HttpStatus.OK.value(), SUCCESS, null);
    }

    public static <T> GenericResponse<T> ok() {
        return createGenericResponse(HttpStatus.OK.value(), SUCCESS, null);
    }

    public static <T> GenericResponse<T> ok(T data) {
        return createGenericResponse(HttpStatus.OK.value(), SUCCESS, data);
    }

    public static <T> GenericResponse<T> bad() {
        return createGenericResponse(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST, null);
    }

    public static <T> GenericResponse<T> resourceNotFound() {
        return createGenericResponse(HttpStatus.NOT_FOUND.value(), NOT_FOUND, null);
    }

    private static <T> GenericResponse<T> createGenericResponse(int responseStatus,
                                                                String message,
                                                                T data) {
        return new GenericResponse<>(message, data, responseStatus);
    }
}
