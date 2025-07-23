package com.example.demo.community.service;

import com.example.demo.community.dto.PostDto;

import java.util.List;

public interface PostService {
    /**
     * 게시글 목록 조회
     * @return List<PostDto> 게시글 목록
     */
    List<PostDto> getPostList();

    /**
     * 게시글 상세 조회
     * @param l
     * @param pstSn 게시글일련번호
     * @return PostDto 게시글 모델
     */
    PostDto getPost(long l, Long pstSn);

    /**
     * 게시글 등록
     * @param dto 게시글 모델
     */
    void create(PostDto dto);

    /**
     * 게시글 수정
     * @param bbsClsgSn 게시판분류일련번호
     * @param pstSn 게시글일련번호
     * @param dto 게시글 모델
     */
    void update(Long bbsClsgSn, Long pstSn, PostDto dto);

    /**
     * 게시글 삭제
     * @param l
     * @param pstSn 게시글일련번호
     */
    void delete(long l, Long pstSn);
}
