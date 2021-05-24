package com.atrify.donutQueue.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "You must send clientId or quantity")
public class OrderMissingInformationException extends RuntimeException {
}