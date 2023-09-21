package com.uniquenick.repository;

import com.uniquenick.entity.TrendingComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendingCommentsRepository extends JpaRepository<TrendingComments,Integer> {
}
