package com.tenzo.mini_project2.domain.respository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tenzo.mini_project2.domain.models.Post;

import com.tenzo.mini_project2.domain.models.QComment;
import com.tenzo.mini_project2.domain.models.QPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.tenzo.mini_project2.domain.models.QComment.comment;
import static com.tenzo.mini_project2.domain.models.QPost.post;



public class CustomPostRepositoryImpl implements CustomPostRepository{
    private final JPAQueryFactory jpaQueryFactory;

    public CustomPostRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Post> getPosts() {
        return jpaQueryFactory
                .selectFrom(post)
                .leftJoin(post.commentList, comment)
                .fetchJoin()
                .orderBy(post.modifiedAt.desc())
                .fetch();
    }
}
