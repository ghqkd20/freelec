package com.freelec.springboot.service;

import com.freelec.springboot.domain.posts.posts;
import com.freelec.springboot.domain.posts.postsRepository;
import com.freelec.springboot.web.dto.PostsListResponseDto;
import com.freelec.springboot.web.dto.PostsResponseDto;
import com.freelec.springboot.web.dto.PostsSaveRequestDto;
import com.freelec.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final postsRepository _postRepository;

    @Transactional
    public Long save(PostsSaveRequestDto postsSaveRequestDto){
        return _postRepository.save(postsSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto postsUpdateRequestDto){
        posts post = _postRepository.findById(id)
                        .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        post.update(postsUpdateRequestDto.getTitle(),postsUpdateRequestDto.getContent());
        return id;
    }
    @Transactional
    public void delete(Long id){
        posts post = _postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id)
        );
        _postRepository.delete(post);
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        posts entity = _postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id"+id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return _postRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
