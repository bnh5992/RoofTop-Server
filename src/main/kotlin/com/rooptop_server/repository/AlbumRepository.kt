package com.rooptop_server.repository

import com.rooptop_server.domain.Album
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlbumRepository : JpaRepository<Album, Long>{

    fun findBySerialNum(serialNum : String) : Album


}