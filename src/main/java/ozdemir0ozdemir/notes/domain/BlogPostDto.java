package ozdemir0ozdemir.notes.domain;

import java.time.Instant;

public record BlogPostDto(Long blogPostId, String article, Instant createdAt) {
}
