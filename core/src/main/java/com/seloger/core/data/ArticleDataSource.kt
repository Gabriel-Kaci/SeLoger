package com.seloger.core.data

import com.seloger.core.domain.Announcement

interface ArticleDataSource {
    suspend fun getAnnouncements(): List<Announcement>?

    suspend fun getAnnouncement(announcementId: Int): Announcement?
}