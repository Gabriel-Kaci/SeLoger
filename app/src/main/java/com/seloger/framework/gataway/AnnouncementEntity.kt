package com.seloger.framework.gataway

import com.seloger.core.domain.Announcement
import com.google.gson.annotations.SerializedName

data class AnnouncementEntity(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("bedrooms")
    val bedrooms: Int?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("area")
    val area: Double?,
    @SerializedName("url")
    val imageUrl: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("professional")
    val professional: String?,
    @SerializedName("propertyType")
    val propertyType: String?,
    @SerializedName("rooms")
    val rooms: Int?
) {
    fun toAnnouncement(): Announcement {
        return Announcement(
            id ?: 0,
            bedrooms ?: 0,
            city ?: "",
            area ?: 0.0,
            imageUrl ?: "null",
            price ?: 0.0,
            professional ?: "",
            propertyType ?: "",
            rooms ?: 0
        )
    }
}