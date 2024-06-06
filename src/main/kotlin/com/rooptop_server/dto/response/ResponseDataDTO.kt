package com.rooptop_server.dto.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "저장, 수정 시 사용되는 사용자에게 알려주는 상태 API")
data class ResponseDataDTO (
    @Schema(description = "성공 및 다른 특별한 예외 번호", example = "200")
    val code : Long,

    @Schema(description = "오류가 났을 시에 대한 설명", example = "앨범 이름을 찾을 수 없습니다.")
    val info : String,
)