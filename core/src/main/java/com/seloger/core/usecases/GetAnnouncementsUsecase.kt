package com.seloger.core.usecases

import com.seloger.core.data.ArticleRepository

class GetAnnouncementsUsecase(private val repository: ArticleRepository) {
    suspend operator fun invoke() = repository.getAnnouncements()
}