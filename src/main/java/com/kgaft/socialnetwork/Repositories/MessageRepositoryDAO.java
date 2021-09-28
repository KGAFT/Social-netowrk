package com.kgaft.socialnetwork.Repositories;

import com.kgaft.socialnetwork.Entities.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepositoryDAO extends CrudRepository<Message, Integer> {
}
