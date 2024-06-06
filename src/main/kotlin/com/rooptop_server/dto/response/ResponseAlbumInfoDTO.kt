package com.rooptop_server.dto.response

import com.rooptop_server.enum.GenreType
import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.time.LocalDate

data class ResponseAlbumInfoDTO (
    val code : Long,

    val serialNum : String,

    val artistName : String,

    val albumName : String,

    val genre : GenreType,

    val albumInfo : String,

    val release : LocalDate,

    val info : String,
)