package org.wcci.albums.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlbumNotFound extends RuntimeException {

	public AlbumNotFound(String message) {
		super(message);
	}
}
//No entiendo