package ozdemir0ozdemir.notes.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "blog_posts")
public class BlogPost implements Serializable {

    @Id
    @SequenceGenerator(name = "blog_posts_id_gen", sequenceName = "blog_posts_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "blog_posts_id_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "blog_post_id")
    private Long blogPostId;

    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "title", unique = true)
    private String title;

    @NotNull
    @Column(name = "article", columnDefinition = "text")
    private String article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Instant updatedAt;

    // Constructors
    public BlogPost() {
    }

    public BlogPost(String title, String article, Category category) {
        this.title = title;
        this.article = article;
        this.category = Category.of(category);
    }

    // Static Factories
    public static BlogPost of(String title, String article, Category category) {
        return new BlogPost(title, article, category);
    }

    public static BlogPost of(BlogPost other) {
        return BlogPost.of(other.title, other.article, other.category);
    }

    // Getters & Setters
    public Long getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(Long blogPostId) {
        this.blogPostId = blogPostId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle( String article) {
        this.article = article;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = Category.of(category);
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
