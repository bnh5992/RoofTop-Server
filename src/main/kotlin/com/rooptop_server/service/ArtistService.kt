package com.rooptop_server.service

import com.rooptop_server.enum.ResponseInfo
import com.rooptop_server.domain.Artist
import com.rooptop_server.dto.request.RequestArtistInfoDTO
import com.rooptop_server.dto.response.ResponseArtistInfoDTO
import com.rooptop_server.dto.response.ResponseDataDTO
import com.rooptop_server.repository.ArtistRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ArtistService (
    private val artistRepository: ArtistRepository,
){

    fun saveArtist(requestArtistInfoDTO: RequestArtistInfoDTO) : ResponseDataDTO {
        artistRepository.save(Artist(
            artistName = requestArtistInfoDTO.artistName,
            email = requestArtistInfoDTO.email,
            phone = requestArtistInfoDTO.phone,
            link = requestArtistInfoDTO.link,
            date = LocalDate.now(),
        ))
        return ResponseDataDTO(
            code = ResponseInfo.SUCCESS.num,
            info = "저장이 완료되었습니다."
        )
    }

    fun artistAllInfo(artistName : String) : ResponseArtistInfoDTO{
        try {
            val artist = artistRepository.findByArtistName(artistName)
            return ResponseArtistInfoDTO(
                code = ResponseInfo.SUCCESS.num,
                artistName = artist.artistName,
                email = artist.email,
                phone = artist.phone,
                link = artist.link,
                date = artist.date,
                albums = artist.albums,
                info = "정상적으로 호출되었습니다."
            )
        }
        catch (e : NoSuchElementException){
            return ResponseArtistInfoDTO(
                code = ResponseInfo.NOSUCH.num,
                info = "해당 아티스트가 존재하지 않습니다."
            )
        }


    }
}