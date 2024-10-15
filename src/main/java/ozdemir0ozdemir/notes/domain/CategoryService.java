package ozdemir0ozdemir.notes.domain;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);
    private final CategoryRepository repository;

    public CategoryDto findCategoryById(Long categoryId) {
        Optional<CategoryDto> dto = this.repository.findByCategoryId(categoryId);
        return dto.orElseThrow();
    }

    public List<CategoryDto> findAll() {
        return this.repository.findAll();
    }

}
