package ozdemir0ozdemir.notes.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ozdemir0ozdemir.notes.domain.*;

import java.util.List;

@Controller
@RequestMapping({"","/", "/home"})
@RequiredArgsConstructor
public class HomeController {

    private final BlogTitleService blogTitleService;
    private final CategoryService categoryService;
    private final BlogPostService blogPostService;

    @GetMapping
    public String getHomePage(Model model){
        List<CategoryDto> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "home";
    }

    @GetMapping("/categories")
    public String getCategories(Model model){
        List<CategoryDto> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "fragments/categories";
    }

    @GetMapping("/categories/{categoryId}/blogs")
    public String getAllBlogTitlesByCategoryId(@PathVariable Long categoryId, Model model) {
        List<BlogTitleDto> blogTitles = this.blogTitleService.getAllByCategoryId(categoryId);
        model.addAttribute("blogTitles", blogTitles);
        model.addAttribute("categoryId", categoryId);
        return "fragments/blogs";
    }


    @GetMapping("/categories/{categoryId}/blogs/{blogTitleId}")
    public String getAllBlogTitlesByCategoryId(@PathVariable Long categoryId, @PathVariable Long blogTitleId, Model model) {
        List<BlogPostDto> blogPosts = this.blogPostService.findAllByBlogTitleId(blogTitleId);
        model.addAttribute("blogPosts", blogPosts);
        model.addAttribute("categoryId", categoryId);
        return "fragments/blogposts";
    }
}
