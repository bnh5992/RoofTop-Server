package com.rooptop_server.dto.response

import com.rooptop_server.domain.Album
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate

@Schema(description = "아티스트의 모든 정보를 제공하는 DTO")
data class ResponseArtistInfoDTO (
    val code : Long,

    val artistName : String = "",

    val email : String = "",

    val phone : String = "",

    val link : String? = null,

    val date : LocalDate = LocalDate.now(),

    @Schema(description = "아티스트의 곡 모음")
    val albums : List<Album> = ArrayList(),

    @Schema(description = "API 호출 추가정보")
    val info : String,
)