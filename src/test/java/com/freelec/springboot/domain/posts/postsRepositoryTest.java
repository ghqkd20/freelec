package com.freelec.springboot.domain.posts;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class postsRepositoryTest {

        @Autowired
        postsRepository _postRepository;

        @After
        public void cleanup(){
            _postRepository.deleteAll();
        }

        @Test
        public void 게시글저장_불러오기(){
            //given
            String title = "Test title";
            String content ="Test content";
            String author = "Test author";

            _postRepository.save(posts.builder().
                    title(title)
                    .content(content)
                    .author(author)
                    .build())   ;
            //when
            List<posts> postsList = _postRepository.findAll();
            //then
            posts _post = postsList.get(0);

            assertThat(_post.getTitle()).isEqualTo(title);
            assertThat(_post.getContent()).isEqualTo(content);
        }

}