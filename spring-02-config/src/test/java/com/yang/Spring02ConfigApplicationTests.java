package com.yang;

import com.yang.pojo.Dog;
import com.yang.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Spring02ConfigApplicationTests {

    @Autowired
    private Dog dog;
    @Autowired
    private Person person;
    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(person);
    }


}
