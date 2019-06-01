package com.project.cinemago.dao;

import com.project.cinemago.models.OrderInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderInfoDAO extends CrudRepository<OrderInfo, Integer> {
}
