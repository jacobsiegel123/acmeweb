package com.acme.statusmgr.beans;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * if recieve an invalid input you get this exception
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Invalid details option: junkERROR")
public class DetailInvalidEx extends RuntimeException {
}
