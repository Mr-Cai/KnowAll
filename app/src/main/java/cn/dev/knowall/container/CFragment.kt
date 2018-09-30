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
import kotlinx.android.synthetic.main.fragment_lie.*
import java.util.*

class CFragment : Fragment() {
    private val itemList = ArrayList<Item>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_lie, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        itemList.clear()
        itemList.add(Item(R.drawable.sudoku, "数独"))
        itemList.add(Item(R.drawable.snake, "贪吃蛇"))
        itemList.add(Item(R.drawable.element, "连连看"))
        val adapter = CardAdapter(itemList)
        lie_recyclerView.adapter = adapter
        lie_recyclerView.layoutManager = GridLayoutManager(context, 1)
    }
}
