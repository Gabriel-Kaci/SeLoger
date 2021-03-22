package com.seloger.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.seloger.R
import com.seloger.SeLoger
import com.seloger.framework.di.DaggerViewModelFactory
import com.seloger.presentation.MainViewModel
import com.seloger.view.AnnouncementItemSeparator
import kotlinx.android.synthetic.main.fragment_articles.*
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private val model by viewModels<MainViewModel> { viewModelFactory }

    private var viewAdapter: AnnouncementAdapter? = null

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, b: Bundle?): View? =
        i.inflate(R.layout.fragment_articles, c, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SeLoger.dagger.inject(this)
        setHasOptionsMenu(true)

        model.announcementListLiveData.observe(viewLifecycleOwner, { viewAdapter?.updateData(it) })

        viewAdapter = AnnouncementAdapter(listOf()).apply {
            setOnItemClickListener { _, announcement ->
                val action = HomeFragmentDirections.showTeam(announcement.id)
                NavHostFragment.findNavController(this@HomeFragment).navigate(action)
            }
        }

        recyclerView.addItemDecoration(
            AnnouncementItemSeparator(resources.getDimension(R.dimen.margin_l).toInt())
        )
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = viewAdapter
        }
    }
}
