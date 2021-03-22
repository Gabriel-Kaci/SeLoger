package com.seloger.framework.di

import com.seloger.framework.gataway.ArticleDataSourceImpl
import com.seloger.framework.interactor.AnnouncementInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {

    @Singleton
    @Provides
    fun getArticleDataInteractor(): AnnouncementInteractor {
        return AnnouncementInteractor(ArticleDataSourceImpl())
    }
}