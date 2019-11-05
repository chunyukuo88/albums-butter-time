package org.wcci.albums.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ArtistNotFound extends RuntimeException {

	public ArtistNotFound(String message) {
		super(message);
	}
}
