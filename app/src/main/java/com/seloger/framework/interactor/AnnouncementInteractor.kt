package com.seloger.framework.interactor

import com.seloger.core.data.ArticleDataSource
import com.seloger.core.data.ArticleRepository
import com.seloger.core.usecases.GetAnnouncementUsecase
import com.seloger.core.usecases.GetAnnouncementsUsecase
import javax.inject.Singleton

@Singleton
class AnnouncementInteractor(dataSource: ArticleDataSource) {
    val getAnnouncements: GetAnnouncementsUsecase
    val getAnnouncement: GetAnnouncementUsecase

    init {
        val repository = ArticleRepository(dataSource)
        getAnnouncements = GetAnnouncementsUsecase(repository)
        getAnnouncement = GetAnnouncementUsecase(repository)
    }
}