package ozdemir0ozdemir.notes.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BlogPostRepository extends Repository<BlogPost, Long> {

    @Query("""
            select new ozdemir0ozdemir.notes.domain.BlogPostDto(bp.blogPostId, bp.article, bp.createdAt) from BlogPost bp
            where bp.blogTitle.blogTitleId = :blogTitleId
            """)
    List<BlogPostDto> findAllByBlogTitleId(Long blogTitleId);
}
