package com.acme.statusmgr.beans;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Required List parameter 'details' is not present in request")
public class MissingListException extends RuntimeException {
}