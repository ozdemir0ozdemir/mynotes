package ozdemir0ozdemir.notes.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogPostService {

    private final BlogPostRepository repository;

    public List<BlogPostDto> findAllByBlogTitleId(Long blogTitleId){
        return this.repository.findAllByBlogTitleId(blogTitleId);
    }
}
