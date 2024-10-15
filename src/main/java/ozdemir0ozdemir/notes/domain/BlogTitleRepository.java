package ozdemir0ozdemir.notes.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

interface BlogTitleRepository extends Repository<BlogTitle, Long> {

    @Query("""
        select new ozdemir0ozdemir.notes.domain.BlogTitleDto(bt.blogTitleId, bt.blogTitle) from BlogTitle bt
        """)
    List<BlogTitleDto> findAll();

    @Query("""
        select new ozdemir0ozdemir.notes.domain.BlogTitleDto(bt.blogTitleId, bt.blogTitle) from BlogTitle bt
        where bt.category.categoryId = :categoryId
        """)
    List<BlogTitleDto> findAllByCategoryId(Long categoryId);

}
