package MalKol.books.kniga.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class AuthorNotFoundException extends Exception {

    private final Long id;
}
