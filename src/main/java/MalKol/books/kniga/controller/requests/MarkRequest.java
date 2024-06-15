package MalKol.books.kniga.controller.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarkRequest {

    private Long bookId;

    private Long userId;

    private Integer intMark;
}
