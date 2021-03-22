package com.seloger.presentation.announcement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.seloger.R
import com.seloger.SeLoger
import com.seloger.core.domain.announcement
import com.seloger.databinding.FragmentAnnouncementDetailsBinding
import com.seloger.framework.di.DaggerViewModelFactory
import com.seloger.presentation.MainViewModel
import com.squareup.picasso.Picasso
import javax.inject.Inject

class AnnouncementDetailsFragment : Fragment() {
    companion object {
        const val ARG_TEAM_NAME = "announcementId"
    }

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val model by viewModels<MainViewModel> { viewModelFactory }
    private var binding: FragmentAnnouncementDetailsBinding? = null

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, b: Bundle?): View? {
        binding = FragmentAnnouncementDetailsBinding.inflate(i, c, false).apply {
            announcement = announcement {}
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SeLoger.dagger.inject(this)

        model.loadAnnouncement(requireArguments().getInt(ARG_TEAM_NAME))
        model.announcementLiveData.observe(viewLifecycleOwner, {
            binding?.announcement = it
        })
    }
}

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String) {
    if (url.isNotEmpty())
        Picasso.get().load(url).into(view)
    else
        view.setImageResource(R.drawable.placeholder)
}

@BindingAdapter("price")
fun setTextPrice(view: TextView, price: Double) {
    if (price > 0) view.text = String.format(view.resources.getString(R.string.price), price)
    else view.text = ""
}

@BindingAdapter("rooms")
fun setTextRooms(view: TextView, rooms: Int) {
    if (rooms > 0) view.text = String.format(view.resources.getString(R.string.rooms), rooms)
    else view.text = ""
}

@BindingAdapter("bedrooms")
fun setTextBedrooms(view: TextView, bedrooms: Int) {
    if (bedrooms > 0)
        view.text = String.format(view.resources.getString(R.string.bedrooms), bedrooms)
    else view.text = ""
}

@BindingAdapter("area")
fun setTextArea(view: TextView, area: Double) {
    if (area > 0) view.text = String.format(view.resources.getString(R.string.area), area)
    else view.text = ""
}
