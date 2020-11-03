package com.example.instagramproject

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class PhotoAdapter(var context: Context, var arrayList: ArrayList<PhotoItem>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View = View.inflate(context, R.layout.photo_list_item, null)
        var photoImage: ImageView = view.findViewById(R.id.imageView_photo)
        var photoItem: PhotoItem = arrayList.get(position)

        photoImage.setImageResource(photoItem.badgeImage)

        return view
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return arrayList.size
    }
}