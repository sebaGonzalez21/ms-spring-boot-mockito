package com.unittest.zenta.unittesting.repository;

import com.unittest.zenta.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepository extends JpaRepository<Item,Integer> {

}
