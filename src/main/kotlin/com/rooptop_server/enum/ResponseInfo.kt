package com.rooptop_server.enum

enum class ResponseInfo (
    val num : Long,
){
    SUCCESS(200),
    ERROR(400),
    NOSUCH(4000),

}