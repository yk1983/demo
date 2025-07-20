package com.example.demo.common.controller;

import com.example.demo.common.dto.CommonCodeDetailDto;
import com.example.demo.common.dto.CommonCodeMasterDto;
import com.example.demo.common.service.CommonCodeService;
import com.example.demo.global.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/common/code")
@Tag(name = "공통코드 API", description = "공통코드 관련 API")
public class CommonCodeController {
    private final CommonCodeService commonCodeService;

    @GetMapping
    @Operation(summary = "공통코드 마스터 목록 조회", description = "공통코드 마스터 목록 정보를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "403", description = "접근 권한 없음"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<BaseResponse<List<CommonCodeMasterDto>>> getCommonCodeMasterList() {
        List<CommonCodeMasterDto> result = commonCodeService.getCommonCodeMasterList();
        return ResponseEntity.ok(BaseResponse.success(result));
    }

    @PostMapping
    @Operation(summary = "공통코드 마스터 등록", description = "공통코드 마스터를 등록합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "403", description = "접근 권한 없음"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<BaseResponse<CommonCodeMasterDto>> createCommonCodeMaster(
            @RequestBody @Valid CommonCodeMasterDto requestDto) {
        return ResponseEntity.ok(BaseResponse.success(commonCodeService.createCommonCodeMaster(requestDto)));
    }

    @PutMapping("/{groupCode}")
    @Operation(summary = "공통코드 마스터 수정", description = "그룹코드에 해당하는 공통코드 마스터를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "403", description = "접근 권한 없음"),
            @ApiResponse(responseCode = "404", description = "해당 코드가 존재하지 않음"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    @Parameters({
            @Parameter(name = "groupCode", description = "그룹코드", example = "G0001"),
            @Parameter(name = "requestDto", description = "공통코드 마스터 DTO")
    })
    public ResponseEntity<BaseResponse<CommonCodeMasterDto>> updateCommonCodeMaster(
            @PathVariable String groupCode,
            @RequestBody @Valid CommonCodeMasterDto requestDto) {
        return ResponseEntity.ok(BaseResponse.success(commonCodeService.updateCommonCodeMaster(groupCode, requestDto)));
    }

    @GetMapping("/{groupCode}")
    @Operation(summary = "공통코드 상세 목록 조회", description = "공통코드 마스터 코드에 해당하는 공통코드 상세 목록을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "403", description = "접근 권한 없음"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<BaseResponse<List<CommonCodeDetailDto>>> getCommonCodeDetailList(
            @Parameter(description = "그룹코드")
            @PathVariable String groupCode) {
        List<CommonCodeDetailDto> result = commonCodeService.getCommonCodeDetailList(groupCode);
        return ResponseEntity.ok(BaseResponse.success(result));
    }

    @GetMapping("/{groupCode}/{detailCode}")
    @Operation(summary = "공통코드 상세 단일 레코드 조회", description = "공통코드 마스터 코드에 해당하는 공통코드 상세 코드로 상세 단일 레코드를 조회합니다.")
    @Parameters({
            @Parameter(name = "groupCode", description = "그룹코드", example = "G0001"),
            @Parameter(name = "detailCode", description = "상세코드", example = "G")
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정상 응답"),
            @ApiResponse(responseCode = "403", description = "접근 권한 없음"),
            @ApiResponse(responseCode = "500", description = "서버 오류")
    })
    public ResponseEntity<BaseResponse<CommonCodeDetailDto>> getCommonCodeDetail(
            @PathVariable String groupCode,
            @PathVariable String detailCode) {
        CommonCodeDetailDto result = commonCodeService.getCommonCodeDetail(groupCode, detailCode);
        return ResponseEntity.ok(BaseResponse.success(result));
    }
}
