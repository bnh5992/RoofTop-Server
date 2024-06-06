package com.rooptop_server.repository

import com.rooptop_server.domain.Artist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistRepository : JpaRepository<Artist, String>{

    fun findByArtistName(artistName : String) : Artist

}