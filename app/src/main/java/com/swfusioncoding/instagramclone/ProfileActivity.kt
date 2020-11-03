package com.swfusioncoding.instagramclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class ProfileActivity : AppCompatActivity() {

    var viewList = ArrayList<View>() // 프래그먼트를 저장할 배열

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        viewList.add(LayoutInflater.from(applicationContext).inflate(R.layout.fragment_profile, null)) // 프래그먼트를 배열에 저장
        viewList.add(LayoutInflater.from(applicationContext).inflate(R.layout.fragment_myphoto, null))

        // 뷰페이저에 어댑터 연결
        viewPager.adapter = pagerAdatper()

        tabLayout.setupWithViewPager(viewPager) // 탭과 뷰페이저를 연결시킴
        //tabLayout.getTabAt(0)?.setText("profile") // 아이콘과 텍스트를 같이 넣고 싶으면 이렇게..
        //tabLayout.getTabAt(1)?.setText("myphoto")

        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_apps_yellow_24dp)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_account_box_black_24dp)

        // 탭의 상태변화 이벤트 리스너
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) { // 탭이 또 다시 선택되었을 때

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) { // 탭이 선택되지 않았을 때

            }

            override fun onTabSelected(tab: TabLayout.Tab?) { // 탭이 선택되었을 때

            }
        })

        tabLayout.tabIconTint = resources.getColorStateList(R.color.tab_icon, null)

        btn_new.setOnClickListener {

        }

        // 프로필 사진 클릭(프로필 편집)
        btn_profileChange.setOnClickListener {
            startActivityForResult(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), 0)
        }

        btn_profileEdit.setOnClickListener {

        }


    }

    // 이너클래스로 어댑터 생성성
    inner class pagerAdatper : PagerAdapter() {
        override fun isViewFromObject(view: View, `object`: Any) = view == `object`

        override fun getCount() = viewList.size

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var curView = viewList[position]
            viewPager.addView(curView)
            return curView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            viewPager.removeView(`object` as View)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data != null) {
            btn_profileChange.setImageURI(data?.data)
        }
    }
}
