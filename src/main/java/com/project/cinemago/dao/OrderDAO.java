package com.project.cinemago.dao;

import com.project.cinemago.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderDAO extends CrudRepository<Order, Integer> {

    @Query("select o from Order o where o.userId = ?1")
    public List<Order> findOrdersByUserId(int id);

}
