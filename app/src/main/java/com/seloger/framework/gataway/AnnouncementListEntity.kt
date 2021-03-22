package com.seloger.framework.gataway

import com.seloger.core.domain.Announcement
import com.google.gson.annotations.SerializedName

class AnnouncementListEntity(
    @SerializedName("items")
    var announcements: List<AnnouncementEntity>
) {
    fun toAnnouncementList(): List<Announcement> = announcements.map { it.toAnnouncement() }
}