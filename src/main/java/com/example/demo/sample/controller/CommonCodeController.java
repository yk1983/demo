package com.example.demo.sample.controller;

import com.example.demo.common.domain.response.BaseResponse;
import com.example.demo.common.util.ResponseUtil;
import com.example.demo.sample.domain.dto.CommonCodeDetailDto;
import com.example.demo.sample.domain.dto.CommonCodeMasterDto;
import com.example.demo.sample.domain.entity.CommonCodeDetail;
import com.example.demo.sample.service.CommonCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/common-code")
public class CommonCodeController {
    private final CommonCodeService commonCodeService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<CommonCodeMasterDto>>> getCommonCodeMasterList() {
        List<CommonCodeMasterDto> result = commonCodeService.getCommonCodeMasterList();
        return ResponseEntity.ok(ResponseUtil.success(result));
    }

    @GetMapping("/{group}")
    public ResponseEntity<BaseResponse<List<CommonCodeDetailDto>>> getCommonCodeDetailList(
            @PathVariable String group) {
        List<CommonCodeDetailDto> result = commonCodeService.getCommonCodeDetailList(group);
        return ResponseEntity.ok(ResponseUtil.success(result));
    }

    @GetMapping("/{group}/{code}")
    public ResponseEntity<BaseResponse<CommonCodeDetailDto>> getCommonCodeDetail(
            @PathVariable String group,
            @PathVariable String code) {
        CommonCodeDetailDto result = commonCodeService.getCommonCodeDetail(group, code);
        return ResponseEntity.ok(ResponseUtil.success(result));
    }
}
