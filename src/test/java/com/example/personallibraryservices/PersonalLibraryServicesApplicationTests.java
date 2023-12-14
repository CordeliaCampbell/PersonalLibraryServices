package com.example.personallibraryservices;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional      //Not too sure how these two things are related (this and the line above)
class PersonalLibraryServicesApplicationTests {

    @Test
    void contextLoads() {
    }

}
