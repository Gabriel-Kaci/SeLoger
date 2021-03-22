package com.seloger.framework.gataway

import android.util.Log
import com.seloger.core.data.ArticleDataSource
import com.seloger.core.domain.Announcement
import com.seloger.SeLoger
import com.seloger.framework.gataway.retrofit.Api
import javax.inject.Inject

class ArticleDataSourceImpl : ArticleDataSource {
    @Inject
    lateinit var api: Api

    init {
        SeLoger.dagger.inject(this)
    }

    override suspend fun getAnnouncements(): List<Announcement>? {
        return try {
            api.getAnnouncements().toAnnouncementList()
        } catch (e: Exception) {
            Log.e("ArticleDataSourceImpl", "getArticles error :", e)
            null
        }
    }

    override suspend fun getAnnouncement(announcementId: Int): Announcement? {
        return try {
            api.getAnnouncement(announcementId).toAnnouncement()
        } catch (e: Exception) {
            Log.e("ArticleDataSourceImpl", "getArticles error :", e)
            null
        }
    }
}