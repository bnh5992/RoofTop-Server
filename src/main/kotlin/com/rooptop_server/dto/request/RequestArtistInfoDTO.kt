package com.rooptop_server.dto.request

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Column
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

@Schema(description = "아티스트 기본 정보 요청 DTO")
data class RequestArtistInfoDTO (
    @Schema(description = "아티스트 이름", example = "MeiWei")
    @field:NotBlank(message = "이름은 필수입니다")
    val artistName : String,

    @Schema(description = "이메일", example = "meiwei@gmail.com")
    @field:Email
    val email : String,


    @Schema(description = "전화번호", example = "000-0000-0000")
    @field:Pattern(regexp = "[0-9]{3}-[0-9]{4}-[0-9]{4}" , message = "전화번호 형식 : 000-0000-0000")
    val phone : String,

    @Schema(description = "아티스트 링크", example = "https://www.naver.com/")
    val link : String,

)