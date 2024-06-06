package com.rooptop_server.enum


enum class AlbumType(
    private val type : String,
    private val typeEnd : String,
){
    Compilation("RFTP-", "", ),
    CompilationEP("RFTP-", "EP"),
    MEGACollab("RFTP-", "SG"),
    ETC("RFTPR-", "");

    fun sum(num: String): String  = type+num+typeEnd
}