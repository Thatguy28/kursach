package MalKol.books.kniga.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserNotFoundException extends Throwable {
    private final Long id;
}
