package com.example.myhomework.homework13

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myhomework.databinding.MyFragmentSweetsKodFragmentBinding
import com.example.myhomework.homework10.Sweets

class MyFragmentSweetsCode : Fragment() {

    private var binding: MyFragmentSweetsKodFragmentBinding? = null
    private val myViewModel: MyFragmentSweetsCodeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MyFragmentSweetsKodFragmentBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listSweet: MutableList<Sweets> = mutableListOf()
        val sweetAdapter = SweetAdapter2(listSweet) { clickListener(it) }

        binding!!.rvSweet2?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding!!.rvSweet2?.adapter = sweetAdapter

        myViewModel.sweetsLiveData2.observe(this.viewLifecycleOwner, Observer {
            sweetAdapter.update(it)
        })
    }

    private fun clickListener(sweet: Sweets) {

        (activity as? HomeWork13Activity)?.clickListener(sweet)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        Log.e("aaa", "onDestroyView1")
    }

    companion object {
        const val TAG = "MyFragmentSweetKod"
        const val KEY = "Key"
    }
}