package com.example.myhomework.homework13

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myhomework.databinding.FragmentItemSweetBinding
import com.example.myhomework.homework10.SaveSweetsList
import com.example.myhomework.homework10.Sweets


class   ItemSweetFragment : Fragment() {

    var binding: FragmentItemSweetBinding? = null
    val bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemSweetBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val info = arguments?.getSerializable(MyFragmentSweetsKod.KEY) as? Sweets
        binding?.tvN?.text = info?.brand
        binding?.tvK?.text = info?.kod.toString()

        Glide
            .with(this)
            .load(chekPhoto(view))
            .into(binding!!.imPicther)
    }

    private fun chekPhoto(view: View): String {
        when (binding?.tvN?.text) {
            SaveSweetsList.MARS ->
                return "https://cdn1.ozone.ru/multimedia/1019690063.jpg"
            SaveSweetsList.SNICKERS ->
                return "https://korzina.su/upload/iblock/315/315a795fada7a41e0094c1c1ee84d08f.jpg"
            SaveSweetsList.NUTS ->
                return "https://edimdomakmv.ru/wp-content/uploads/2020/04/3051232h.jpg"
        }
        return ""

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
           }

    companion object {
        const val TAG1 = "MyFragmentSweet"
    }
}
