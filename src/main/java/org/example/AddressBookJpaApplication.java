package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AddressBookJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressBookJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner buddyDemo(BuddyInfoRepository buddyInfoRepository) {
        return args -> {
            buddyInfoRepository.save(new BuddyInfo("John", 1234567890l));
            buddyInfoRepository.save(new BuddyInfo("Jane", 1234567891l));
            buddyInfoRepository.save(new BuddyInfo("Henry", 1234567892l));

            log.info("All buddies in repository:");
            buddyInfoRepository.findAll().forEach(buddyInfo -> {
                log.info(buddyInfo.toString());
            });
            log.info("");

            BuddyInfo buddy = buddyInfoRepository.findByName("John");
            log.info("Buddy with name John:");
            log.info(buddy.toString());
            log.info("");


            buddy = buddyInfoRepository.findByPhonenumber(1234567891l);
            log.info("Buddy with phone number 1234567891");
            log.info(buddy.toString());
            log.info("");


        };
    }

    @Bean
    public CommandLineRunner addressBookDemo(AddressBookRepository addressBookRepository) {
        return args -> {
            BuddyInfo buddy1 = new BuddyInfo("John", 1234567890l);
            BuddyInfo buddy2 = new BuddyInfo("Jane", 1234567891l);
            BuddyInfo buddy3 = new BuddyInfo("Henry", 1234567892l);

            AddressBook addressBook =  new AddressBook();
            addressBook.addBuddy(buddy1);
            addressBook.addBuddy(buddy2);
            addressBook.addBuddy(buddy3);

            addressBookRepository.save(addressBook);

            AddressBook book = addressBookRepository.findById(1L);
            log.info("Book with id 1:");
            log.info(book.toString());
            log.info("");
        };
    }
}
