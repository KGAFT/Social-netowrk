package com.kgaft.socialnetwork.Repositories;

import com.kgaft.socialnetwork.Entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositoryDAO extends CrudRepository<Post, Integer> {
}
