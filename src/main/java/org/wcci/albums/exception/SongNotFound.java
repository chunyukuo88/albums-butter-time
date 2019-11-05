package org.wcci.albums.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SongNotFound extends RuntimeException {

	public SongNotFound(String message) {
		super(message);
	}
}
