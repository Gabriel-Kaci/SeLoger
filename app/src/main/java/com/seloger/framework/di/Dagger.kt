package com.seloger.framework.di

import com.seloger.framework.gataway.ArticleDataSourceImpl
import com.seloger.presentation.MainViewModel
import com.seloger.presentation.announcement.AnnouncementDetailsFragment
import com.seloger.presentation.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        InteractorModule::class,
        RetrofitModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)
interface Component {
    fun inject(homeFragment: HomeFragment)
    fun inject(announcementDetailsFragment: AnnouncementDetailsFragment)
    fun inject(mainViewModel: MainViewModel)
    fun inject(articleDataSourceImpl: ArticleDataSourceImpl)
}