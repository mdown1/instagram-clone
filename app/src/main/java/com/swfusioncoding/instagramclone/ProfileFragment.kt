package com.swfusioncoding.instagramclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView

class ProfileFragment : Fragment() {

    private var gridView: GridView? = null
    private var arrayList:ArrayList<PhotoItem> ? = null
    private var badgeAdapter:PhotoAdapter ? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_myphoto, container, false)

        gridView = view.findViewById(R.id.gridView_photo)
        arrayList = ArrayList()
        arrayList = setDataList()
        badgeAdapter = PhotoAdapter(view.context, arrayList!!)
        gridView?.adapter = badgeAdapter

        return view
    }

    private fun setDataList(): ArrayList<PhotoItem>{
        var arrayList: ArrayList<PhotoItem> = ArrayList()

        arrayList.add(PhotoItem(R.drawable.pic))
        arrayList.add(PhotoItem(R.drawable.pic))
        arrayList.add(PhotoItem(R.drawable.pic))
        arrayList.add(PhotoItem(R.drawable.pic))
        arrayList.add(PhotoItem(R.drawable.pic))
        arrayList.add(PhotoItem(R.drawable.pic))

        return arrayList
    }

}
