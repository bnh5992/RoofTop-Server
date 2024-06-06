package com.rooptop_server.domain

import com.rooptop_server.enum.GenreType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "Album")
class Album (
    //구분
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val albumId : Long?,


    //앨범 구분
    @Column(name = "serialNum")
    val serialNum : String,

    //아티스트 이름
    @Column(name = "artistName")
    val artistName : String,

    //곡 이름
    @Column(name = "albumName")
    val albumName : String,

    //장르
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    val genre : GenreType,

    //설명란
    @Column(name = "albumInfo")
    val albumInfo : String,

    //곡 출시일
    @Column(name = "release")
    val release : LocalDate,

    @ManyToOne
    @JoinColumn(name = "artist")
    val artist : Artist? = null,
){

}