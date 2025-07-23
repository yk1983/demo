package com.example.demo.community.service.impl;

import com.example.demo.community.dto.PostDto;
import com.example.demo.community.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    /**
     * @see PostService#getPostList()
     * @return
     */
    @Override
    public List<PostDto> getPostList() {
        return List.of();
    }

    /**
     * @see PostService#getPost(long, Long)
     * @param l
     * @param pstSn 게시글일련번호
     * @return
     */
    @Override
    public PostDto getPost(long l, Long pstSn) {
        return null;
    }

    /**
     * @see PostService#create(PostDto) 
     * @param dto 게시글 모델
     */
    @Override
    public void create(PostDto dto) {

    }

    /**
     * @see PostService#update(Long, Long, PostDto) 
     * @param bbsClsgSn 게시판분류일련번호
     * @param pstSn 게시글일련번호
     * @param dto 게시글 모델
     */
    @Override
    public void update(Long bbsClsgSn, Long pstSn, PostDto dto) {

    }

    /**
     * @see PostService#delete(long, Long)
     * @param l
     * @param pstSn 게시글일련번호
     */
    @Override
    public void delete(long l, Long pstSn) {

    }
}
