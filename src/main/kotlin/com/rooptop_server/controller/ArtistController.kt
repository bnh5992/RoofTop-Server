package com.rooptop_server.controller

import com.rooptop_server.dto.request.RequestArtistInfoDTO
import com.rooptop_server.dto.response.ResponseArtistInfoDTO
import com.rooptop_server.dto.response.ResponseDataDTO
import com.rooptop_server.service.ArtistService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "아티스트 API", description = "아티스트 정보 생성 수정 삭제를 담당한다.")
@RestController
@RequestMapping("/artist")
@Validated
class ArtistController (
    val artistService: ArtistService,
){

    @GetMapping("/test")
    fun test() : String{
        return "hi"
    }

    @Operation(summary = "아티스트 정보 저장")
    @PostMapping("/artist")
    fun saveArtist(@RequestBody @Valid requestArtistInfoDTO: RequestArtistInfoDTO) : ResponseEntity<ResponseDataDTO>{
        val result = artistService.saveArtist(requestArtistInfoDTO)
        return ResponseEntity.ok().body(result)
    }

    @Operation(summary = "아티스트 정보 호출", description = "아티스트 아이디를 줄 시 있으면 정보 제공")
    @GetMapping("{artistName}")
    fun artistInfo(@PathVariable artistName : String) : ResponseEntity<ResponseArtistInfoDTO>{
        val result = artistService.artistAllInfo(artistName)
        return ResponseEntity.ok().body(result)
    }




}