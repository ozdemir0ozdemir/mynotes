package ozdemir0ozdemir.notes.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "blog_titles")
@Getter
@Setter
@ToString(exclude = {"blogPosts"})
class BlogTitle implements Serializable {

    @Id
    @SequenceGenerator(name = "blog_titles_id_gen", sequenceName = "blog_titles_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "blog_titles_id_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "blog_title_id")
    private Long blogTitleId;

    @Column(name = "blog_title")
    private String blogTitle;

    @Setter(value = AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "blogTitle")
    private final List<BlogPost> blogPosts = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Instant updatedAt;

    // Constructors
    public BlogTitle() {
    }

    private BlogTitle(String blogTitle, Category category, List<BlogPost> blogPosts) {
        this.blogTitle = blogTitle;
        this.category = Category.of(category);
        this.blogPosts.addAll(blogPosts);
    }

    // Static Factories
    static BlogTitle of(String blogTitle, Category category, List<BlogPost> blogPosts) {
        return new BlogTitle(blogTitle, category, blogPosts);
    }

    static BlogTitle of(BlogTitle blogTitle) {
        return new BlogTitle(
                blogTitle.getBlogTitle(),
                blogTitle.getCategory(),
                blogTitle.getBlogPosts());
    }

    // Additional Methods
    void addBlogPost(BlogPost blogPost) {
        this.blogPosts.add(BlogPost.of(
                blogPost.getArticle(),
                blogPost.getBlogTitle()
        ));
    }


}
