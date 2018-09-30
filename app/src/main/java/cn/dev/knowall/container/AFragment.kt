package cn.dev.knowall.container

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import cn.dev.knowall.R
import cn.dev.knowall.controller.CardAdapter
import cn.dev.knowall.controller.CardAdapter.Item
import kotlinx.android.synthetic.main.fragment_life.*
import java.util.*

class AFragment : Fragment() {
    private var itemList = ArrayList<Item>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_life, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemList.clear() //添加元素前清空数据集,要不然元素会重复,因为第一次添加后就进入了缓存
        itemList.add(Item(R.drawable.deposit, "存款"))
        itemList.add(Item(R.drawable.phone, "手机"))
        itemList.add(Item(R.drawable.post_code, "邮编"))
        val adapter = CardAdapter(itemList)
        life_recyclerView.adapter = adapter
        life_recyclerView.layoutManager = GridLayoutManager(context, 1)
    }

}