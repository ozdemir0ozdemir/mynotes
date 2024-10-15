package ozdemir0ozdemir.notes.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogTitleService {

    private final BlogTitleRepository repository;

    public List<BlogTitleDto> getAll() {
        return repository.findAll();
    }

    public List<BlogTitleDto> getAllByCategoryId(Long id) {
        return this.repository.findAllByCategoryId(id);
    }


}
