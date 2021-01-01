package com.api.fisher;

import com.api.fisher.config.ApplicationYamlRead;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationYamlTest {
    @Autowired
    private ApplicationYamlRead read;

    @Test
    public void test (){
    //given
        String key= read.getServiceKey();
    //when
        System.out.println(key);
    //then

    }
}
