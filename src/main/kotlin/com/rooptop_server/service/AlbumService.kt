package com.rooptop_server.service

import com.rooptop_server.domain.Album
import com.rooptop_server.dto.request.RequestAlbumInfoDTO
import com.rooptop_server.dto.response.ResponseAlbumInfoDTO
import com.rooptop_server.dto.response.ResponseDataDTO
import com.rooptop_server.enum.ResponseInfo
import com.rooptop_server.repository.AlbumRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class AlbumService (
    private val albumRepository: AlbumRepository,
){

    fun saveSong(requestSongInfoDTO: RequestAlbumInfoDTO) : ResponseDataDTO{
        val pair = requestSongInfoDTO.albumNum to requestSongInfoDTO.albumType
        val (albumNum, type) = pair

        albumRepository.save(Album(
            albumId = null,
            serialNum = type.sum(albumNum),
            artistName = requestSongInfoDTO.artistName,
            albumName = requestSongInfoDTO.alBumName,
            genre = requestSongInfoDTO.genre,
            albumInfo = requestSongInfoDTO.info,
            release = LocalDate.now(),
        ))

        return ResponseDataDTO(
            code = ResponseInfo.SUCCESS.num,
            info = "정상적으로 저장되었습니다."
        )
    }

    fun findSong(serial : String) : ResponseAlbumInfoDTO{
        val result = albumRepository.findBySerialNum(serial)

        return ResponseAlbumInfoDTO(
            code = ResponseInfo.SUCCESS.num,
            serialNum = result.serialNum,
            artistName = result.artistName,
            albumName = result.albumName,
            genre = result.genre,
            albumInfo = result.albumInfo,
            release = result.release,
            info = "앨범 serial 번호에 따른 정보"
        )

    }
}