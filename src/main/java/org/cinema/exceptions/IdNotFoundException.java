package org.cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Id not found")
public class IdNotFoundException {

    public IdNotFoundException (Long id, String theName) {
       // super(MessageFormat.format("could not find this id {o} for the class {1}", id, theName));
    }
}
