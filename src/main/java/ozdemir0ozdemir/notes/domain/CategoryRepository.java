package ozdemir0ozdemir.notes.domain;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

interface CategoryRepository extends Repository<Category, Long> {

    @Query("""
                select new ozdemir0ozdemir.notes.domain.CategoryDto(c.categoryId, c.categoryName) from Category c
                where c.categoryId = :categoryId
            """)
    Optional<CategoryDto> findByCategoryId(Long categoryId);

    @Query("""
                select new ozdemir0ozdemir.notes.domain.CategoryDto(c.categoryId, c.categoryName) from Category c
            """)
    List<CategoryDto> findAll();

}
