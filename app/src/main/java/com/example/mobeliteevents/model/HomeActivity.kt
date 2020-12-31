package com.example.mobeliteevents.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.mobeliteevents.Adapter.MainRecyclerAdapter
import com.example.mobeliteevents.R
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.*
import com.etebarian.meowbottomnavigation.MeowBottomNavigation as MeowBottomNavigation1


class HomeActivity : AppCompatActivity() {

    private var mainCategoryRecycler: RecyclerView? = null
    private var mainRecyclerAdapter:MainRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val CategoryItemList: MutableList<CategoryItem> = ArrayList()
            CategoryItemList.add(CategoryItem(1,R.drawable.event))
            CategoryItemList.add(CategoryItem(1,R.drawable.event2))
            CategoryItemList.add(CategoryItem(1,R.drawable.event3))
            CategoryItemList.add(CategoryItem(1,R.drawable.event12))

        val CategoryItemList2: MutableList<CategoryItem> = ArrayList()
        CategoryItemList2.add(CategoryItem(1,R.drawable.event4))
        CategoryItemList2.add(CategoryItem(1,R.drawable.event5))
        CategoryItemList2.add(CategoryItem(1,R.drawable.event6))
        CategoryItemList2.add(CategoryItem(1,R.drawable.event7))

        val CategoryItemList3: MutableList<CategoryItem> = ArrayList()
        CategoryItemList3.add(CategoryItem(1,R.drawable.event8))
        CategoryItemList3.add(CategoryItem(1,R.drawable.event9))
        CategoryItemList3.add(CategoryItem(1,R.drawable.event10))
        CategoryItemList3.add(CategoryItem(1,R.drawable.event11))

        val CategoryItemList4: MutableList<CategoryItem> = ArrayList()
        CategoryItemList4.add(CategoryItem(1,R.drawable.event13))
        CategoryItemList4.add(CategoryItem(1,R.drawable.event14))
        CategoryItemList4.add(CategoryItem(1,R.drawable.event15))
        CategoryItemList4.add(CategoryItem(1,R.drawable.event16))
        CategoryItemList4.add(CategoryItem(1, R.drawable.event17))

        val allCategory: MutableList<AllCategory> = ArrayList()
        allCategory.add(AllCategory(categoryTitle = "Sport", categoryItem = CategoryItemList))
        allCategory.add(AllCategory(categoryTitle = "Music", categoryItem = CategoryItemList2))
        allCategory.add(AllCategory(categoryTitle = "Arts", categoryItem = CategoryItemList3))
        allCategory.add(AllCategory(categoryTitle = "Culture", categoryItem = CategoryItemList4))
       setMainCategoryRecycler(allCategory)

    }

    private fun setMainCategoryRecycler(allCategory: List<AllCategory>){
        mainCategoryRecycler = findViewById(R.id.main_recycler)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        mainCategoryRecycler!!.layoutManager= layoutManager
        mainRecyclerAdapter = MainRecyclerAdapter(this, allCategory)
        mainCategoryRecycler!!.adapter = mainRecyclerAdapter
    }


}
