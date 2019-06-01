package com.project.cinemago.dao;

import com.project.cinemago.models.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MessageDAO extends CrudRepository<Message, Integer> {

    @Query("select m from Message m where m.userId = ?1")
    public Iterable<Message> findByUserId(int id);

}
