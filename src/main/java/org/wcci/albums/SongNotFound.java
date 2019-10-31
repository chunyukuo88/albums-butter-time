package org.wcci.albums;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SongNotFound extends RuntimeException {

	public void SongNotFoundException(String message) {
		super(message);
	}
}
//No entiendo