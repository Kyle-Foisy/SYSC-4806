package org.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    BuddyInfo findByName(String name);

    BuddyInfo findByPhonenumber(long phonenumber);

    BuddyInfo findById(long id);
}
