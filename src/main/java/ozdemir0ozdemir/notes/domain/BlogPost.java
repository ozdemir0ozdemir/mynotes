package ozdemir0ozdemir.notes.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "blog_posts")
@Getter
@Setter
@ToString
class BlogPost implements Serializable {

    @Id
    @SequenceGenerator(name = "blog_posts_id_gen", sequenceName = "blog_posts_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "blog_posts_id_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "blog_post_id")
    private Long blogPostId;

    @NotBlank
    @Column(name = "article", columnDefinition = "text")
    private String article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blog_title_id", referencedColumnName = "blog_title_id")
    private BlogTitle blogTitle;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Instant updatedAt;

    // Constructors
    public BlogPost() {
    }

    private BlogPost(String article, BlogTitle blogTitle) {
        this.article = article;
        this.blogTitle = BlogTitle.of(blogTitle);
    }

    // Static Factories
    static BlogPost of(String article, BlogTitle blogTitle) {
        return new BlogPost(article, blogTitle);
    }

    static BlogPost of(BlogPost other) {
        return BlogPost.of(other.article, other.blogTitle);
    }


}
