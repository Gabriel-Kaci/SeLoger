package com.seloger.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.seloger.SeLoger
import com.seloger.core.domain.Announcement
import com.seloger.framework.interactor.AnnouncementInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel(), CoroutineScope by MainScope() {

    @Inject
    lateinit var announcementInteractor: AnnouncementInteractor

    val announcementListLiveData: MutableLiveData<List<Announcement>> = MutableLiveData()
    val announcementLiveData: MutableLiveData<Announcement> = MutableLiveData()

    init {
        SeLoger.dagger.inject(this)

        launch { announcementListLiveData.value = announcementInteractor.getAnnouncements() }
    }

    fun loadAnnouncement(announcementId: Int) {
        launch {
            announcementLiveData.value = announcementInteractor.getAnnouncement(announcementId)
        }
    }
}