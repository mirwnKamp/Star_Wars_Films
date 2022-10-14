package com.mironk.starwarsfilms.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mironk.starwarsfilms.R
import com.mironk.starwarsfilms.viewmodel.FilmsViewModel

class FilmsFragment : Fragment() {

    companion object {
        fun newInstance() = FilmsFragment()
    }

    private lateinit var viewModel: FilmsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilmsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}