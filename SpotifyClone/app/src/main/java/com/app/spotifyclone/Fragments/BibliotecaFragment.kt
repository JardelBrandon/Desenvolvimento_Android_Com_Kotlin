package com.app.spotifyclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import com.app.spotifyclone.FragmentsTab.AlbunsFragment
import com.app.spotifyclone.FragmentsTab.ArtistasFragment
import com.app.spotifyclone.FragmentsTab.PlaylistsFragment

import com.app.spotifyclone.R
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.fragment_biblioteca.*

/**
 * A simple [Fragment] subclass.
 */
class BibliotecaFragment : Fragment() {

    companion object {
        fun newInstance(): BibliotecaFragment {
            val fragmentBiblioteca = BibliotecaFragment()
            val argumentos = Bundle()
            fragmentBiblioteca.arguments = argumentos
            return fragmentBiblioteca
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_biblioteca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var adapter = FragmentPagerItemAdapter(fragmentManager, FragmentPagerItems.with(context)
            .add("Playlists", PlaylistsFragment::class.java)
            .add("Artistas", ArtistasFragment::class.java)
            .add("Álbuns", AlbunsFragment::class.java)
            .create())

        viewpager.adapter = adapter
        viewpagertab.setViewPager(viewpager)
    }

}
