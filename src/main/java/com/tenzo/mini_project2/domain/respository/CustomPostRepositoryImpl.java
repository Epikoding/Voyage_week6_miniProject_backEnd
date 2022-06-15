package com.tenzo.mini_project2.domain.respository;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QList;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tenzo.mini_project2.domain.models.Post;
import com.tenzo.mini_project2.domain.models.QComment;
import com.tenzo.mini_project2.domain.models.QTags;
import com.tenzo.mini_project2.security.model.QUser;
import com.tenzo.mini_project2.web.dto.postDto.PostResponseDto;
import javax.persistence.EntityManager;
import java.util.List;


import static com.tenzo.mini_project2.domain.models.QComment.comment;
import static com.tenzo.mini_project2.domain.models.QPost.post;
import static com.tenzo.mini_project2.domain.models.QTags.tags;
import static com.tenzo.mini_project2.security.model.QUser.user;


public class CustomPostRepositoryImpl implements CustomPostRepository{
    private final JPAQueryFactory jpaQueryFactory;

    public CustomPostRepositoryImpl(EntityManager entityManager) {
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Post> getPosts() {
        return jpaQueryFactory
                .selectFrom(post)
                .leftJoin(post.user,user)
                .fetchJoin()
                .leftJoin(post.tagList, tags)
                .fetchJoin()
                .leftJoin(post.commentList, comment)
                .fetchJoin()
                .orderBy(post.modifiedAt.desc())
                .fetch();
    }
}
