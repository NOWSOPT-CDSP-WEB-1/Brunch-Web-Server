package com.brunch.server.posting.repository;

import com.brunch.server.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostingRepository extends JpaRepository<Posting, Long> {

    List<Posting> findAllByIsViewed(int isViewed);

    List<Posting> findAllByIsLiked(int isLiked);

    List<Posting> findAllByDayOrderByRequiredTimeDesc(String day);
    List<Posting> findAllByDayOrderByLikeCountDesc(String day);
}
