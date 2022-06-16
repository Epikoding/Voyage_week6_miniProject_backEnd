package com.tenzo.mini_project2.domain.respository;



import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.web.dto.commentDto.CommentsResponseDto;
import com.tenzo.mini_project2.web.dto.commentDto.QCommentsResponseDto;

import javax.persistence.EntityManager;
import java.util.List;


import static com.tenzo.mini_project2.domain.models.QComment.comment;
import static com.tenzo.mini_project2.domain.models.QPost.post;
import static com.tenzo.mini_project2.domain.models.QTags.tags;
import static com.tenzo.mini_project2.security.model.QUser.user;


public class CustomPostRepositoryImpl implements CustomPostRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public CustomPostRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Post> getPosts() {
        return jpaQueryFactory
                .selectFrom(post)
                .distinct()
                .leftJoin(post.tagList, tags)
                .fetchJoin()
                .leftJoin(post.commentList, comment)
                .fetchJoin()
                .orderBy(post.modifiedAt.desc())
                .fetch();
    }

    @Override
    public List<CommentsResponseDto> getComments(Long postId) {
        return jpaQueryFactory
                .select(new QCommentsResponseDto(
                        comment.id,
                        comment.userId,
                        comment.content,
                        comment.createdAt)
                )
                .from(comment)
                .leftJoin(comment.userId, user)
                .where(comment.postId.eq(postId))
                .orderBy(comment.createdAt.desc())
                .fetch();
    }
}
