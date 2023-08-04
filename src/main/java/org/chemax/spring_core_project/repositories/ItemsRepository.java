package org.chemax.spring_core_project.repositories;

import org.chemax.spring_core_project.models.Item;
import org.chemax.spring_core_project.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Long> {

    List<Item> findByItemName(String itemName);

    List<Item> findByOwner(Person owner);
}
