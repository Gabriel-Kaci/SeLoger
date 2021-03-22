package com.seloger.core.data

class ArticleRepository(private val dataSource: ArticleDataSource) {
    suspend fun getAnnouncements() = dataSource.getAnnouncements()

    suspend fun getAnnouncement(announcementId: Int) = dataSource.getAnnouncement(announcementId)
}