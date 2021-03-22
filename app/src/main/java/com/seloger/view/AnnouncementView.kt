package com.seloger.view

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import androidx.annotation.RequiresApi
import androidx.core.view.setMargins
import com.seloger.core.domain.Announcement
import com.google.android.material.card.MaterialCardView
import com.seloger.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_announcement.view.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class AnnouncementView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    companion object {
        private const val MARGIN = 5
        private const val RADIUS = 6f
        private const val ELEVATION = 6f
    }

    private var onHandlerTouchListener: ((MotionEvent) -> Unit)? = null

    init {
        LayoutInflater.from(context)?.inflate(R.layout.view_announcement, this)
        val scale = context.resources.displayMetrics.density
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT).apply {
            setMargins((MARGIN * scale).toInt())
        }
        layoutParams = params
        radius = RADIUS * scale
        elevation = ELEVATION * scale
    }

    fun bindData(announcement: Announcement) {
        val res: Resources = resources
        Picasso.get()
            .load(announcement.imageUrl)
            .resize(900, 600)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .into(imageView)
        textViewPropertyType.text = announcement.propertyType
        if (announcement.price > 0)
            textViewPrice.text = String.format(res.getString(R.string.price), announcement.price)
        if (announcement.rooms > 0)
            textViewRooms.text = String.format(res.getString(R.string.rooms), announcement.rooms)
        if (announcement.bedrooms > 0)
            textViewBedrooms.text =
                String.format(res.getString(R.string.bedrooms), announcement.bedrooms)
        if (announcement.area > 0)
            textViewArea.text = String.format(res.getString(R.string.area), announcement.area)
    }
}