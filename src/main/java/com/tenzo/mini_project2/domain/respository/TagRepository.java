package com.tenzo.mini_project2.domain.respository;

import com.tenzo.mini_project2.domain.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tags, Long> {

    @Query("select distinct(this.tag), this.id from tagInfo this")
    List<Tags>getTags();
}
