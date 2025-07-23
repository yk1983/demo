package com.example.demo.community.controller.view;

import com.example.demo.community.dto.PostDto;
import com.example.demo.community.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller("communityPageController")
@RequestMapping("/community")
@RequiredArgsConstructor
@Tag(name = "커뮤니티 관련 VIEW 컨트롤러", description = "게시판 / 공지사항 / 문의 등 ...")
public class PageController {

    private final PostService bbsService;

    /**
     * 게시글 목록 VIEW
     * @param model 모델
     * @return String
     */
    @GetMapping
    @Operation(summary = "게시글 목록 VIEW", description = "커뮤니티 게시글 목록을 조회하는 화면을 호출합니다.")
    public String list(Model model) {
        model.addAttribute("bbsList", bbsService.getPostList());
        return "community/bbs-list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long pstSn, Model model) {
        // 예시로 bbsClsgSn = 1로 고정 처리 (실무에서는 파라미터로 받아야 함)
        model.addAttribute("bbs", bbsService.getPost(1L, pstSn));
        return "community/bbs-detail";
    }

    /**
     * 신규 게시글 입력 폼 VIEW
     * @param model 모델
     * @return String
     */
    @GetMapping("/post")
    @Operation(summary = "신규 게시글 입력 폼 VIEW", description = "커뮤니티 신규 게시글을 입력하기 위해 입력 폼 화면을 호출합니다.")
    public String edit(Model model) {
        model.addAttribute("post", new PostDto());
        model.addAttribute("isEdit", false);
        return "community/bbs-form";
    }

    @PostMapping("/post")
    public String create(@ModelAttribute PostDto dto) {
        bbsService.create(dto);
        return "redirect:/board";
    }

    /**
     * 수정 게시글 입력 폼 VIEW
     * @param pstSn 게시글일련번호
     * @param model 모델
     * @return String
     */
    @GetMapping("/post/{id}")
    @Operation(summary = "수정 게시글 입력 폼 VIEW", description = "커뮤니티 수정 게시글을 입력하기 위해 입력 폼 화면을 호출합니다.")
    public String editForm(@PathVariable("id") Long pstSn, Model model) {
        model.addAttribute("bbs", bbsService.getPost(1L, pstSn));
        model.addAttribute("isEdit", true);
        return "community/bbs-form";
    }

    @PutMapping("/post/{id}")
    public String update(@PathVariable("id") Long pstSn, @ModelAttribute PostDto dto) {
        bbsService.update(dto.getBbsClsgSn(), pstSn, dto);
        return "redirect:/board";
    }

    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable("id") Long pstSn) {
        bbsService.delete(1L, pstSn); // bbsClsgSn = 1 고정 예시
        return "redirect:/board";
    }

}
