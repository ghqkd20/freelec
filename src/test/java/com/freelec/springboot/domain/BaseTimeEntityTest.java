package com.freelec.springboot.domain;

import com.freelec.springboot.domain.posts.posts;
import com.freelec.springboot.domain.posts.postsRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTimeEntityTest {



    @Autowired
    private postsRepository _postsRepository;
    @Test
    public void 테스트(){
    //given
    LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
    _postsRepository.save(posts.builder()
            .title("title")
    .content("content")
    .author("author")
    .build());

    //when
    List<posts> postsList = _postsRepository.findAll();


    //then
    posts post = postsList.get(0);

    System.out.println(">>>>>>>>>>>>>>>>>>>>createDate = "+post.getCreatedDate()+", modifiedDate ="+post.getModifiedDate());

    assertThat(post.getCreatedDate()).isAfter(now);
    assertThat(post.getModifiedDate()).isAfter(now);
    }
}