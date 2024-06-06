package com.rooptop_server.dto.request

import com.rooptop_server.enum.AlbumType
import com.rooptop_server.enum.GenreType
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank


@Schema(description = "아티스트 곡 요청 DTO")
data class RequestAlbumInfoDTO (
    @Schema(description = "아티스트 이름", example = "MeiWei")
    @field:NotBlank(message = "이름은 필수입니다")
    val artistName : String,

    @Schema(description = "곡 이름", example = "sorrow")
    @field:NotBlank(message = "곡 이름은 필수입니다")
    val alBumName : String,

    @Schema(description = "장르", example = "Jazz")
    @field:NotBlank(message = "장르는 필수입니다")
    val genre : GenreType,

    @Schema(description = "앨범 릴리즈 시 종류", example = "Compilation")
    @field:NotBlank(message = "릴리즈 타입 필수")
    val albumType: AlbumType,

    @Schema(description = "앨범 번호 지정", example = "0001")
    @field:NotBlank(message = "번호는 필수입니다.")
    val albumNum : String,

    @Schema(description = "곡 설명", example = "좋은 느낌이 나도록 만들었어요")
    val info : String,
)