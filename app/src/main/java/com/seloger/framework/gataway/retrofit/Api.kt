package com.seloger.framework.gataway.retrofit

import com.seloger.framework.gataway.AnnouncementEntity
import com.seloger.framework.gataway.AnnouncementListEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    companion object {
        const val URL = "https://gsl-apps-technical-test.dignp.com/"
    }

    @GET("listings.json")
    suspend fun getAnnouncements(): AnnouncementListEntity

    @GET("listings/{listingId}.json")
    suspend fun getAnnouncement(@Path("listingId") announcementId: Int): AnnouncementEntity
}