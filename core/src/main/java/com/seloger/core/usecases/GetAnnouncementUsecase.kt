package com.seloger.core.usecases

import com.seloger.core.data.ArticleRepository

class GetAnnouncementUsecase(private val repository: ArticleRepository) {
    suspend operator fun invoke(announcementId: Int) = repository.getAnnouncement(announcementId)
}