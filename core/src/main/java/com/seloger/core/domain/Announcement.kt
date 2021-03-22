package com.seloger.core.domain

data class Announcement(
    val id: Int = 0,
    val bedrooms: Int = 0,
    val city: String = "",
    val area: Double = 0.0,
    val imageUrl: String = "",
    val price: Double = 0.0,
    val professional: String = "",
    val propertyType: String = "",
    val rooms: Int = 0
)

fun announcement(block: Announcement.() -> Unit) = Announcement().apply(block)
