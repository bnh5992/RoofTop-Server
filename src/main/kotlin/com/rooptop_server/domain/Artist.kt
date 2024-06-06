package com.rooptop_server.domain

import jakarta.persistence.*
import java.time.LocalDate

@Table(name = "artist")
@Entity
class Artist (

    //아티스트 이름
    @Id
    @Column(name = "artistName")
    val artistName : String,

    //이메일
    @Column(name = "email")
    val email : String,

    //전화번호
    @Column(name = "phone")
    val phone : String,

    @Column(name = "link")
    val link : String? = null,

    // 출시일
    val date : LocalDate,


    @OneToMany(mappedBy = "artistName", cascade = [CascadeType.ALL])
    val albums : List<Album> = ArrayList(),

    ){
}