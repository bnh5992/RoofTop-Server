package com.rooptop_server.controller

import com.rooptop_server.dto.request.RequestAlbumInfoDTO
import com.rooptop_server.dto.response.ResponseAlbumInfoDTO
import com.rooptop_server.dto.response.ResponseDataDTO
import com.rooptop_server.service.AlbumService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/song")
class AlbumController (
    private val albumService: AlbumService,
){

    @PostMapping("/song")
    fun saveAlbum(@RequestBody @Valid requestSongInfoDTO: RequestAlbumInfoDTO) : ResponseEntity<ResponseDataDTO> {
        val result = albumService.saveSong(requestSongInfoDTO)
        return ResponseEntity.ok().body(result)
    }

    @GetMapping("{serial}")
    fun findSerialAlbum(@PathVariable serial : String) : ResponseEntity<ResponseAlbumInfoDTO>{
        val result = albumService.findSong(serial)
        return ResponseEntity.ok().body(result)
    }
}