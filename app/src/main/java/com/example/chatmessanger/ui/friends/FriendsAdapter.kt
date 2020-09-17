package com.example.chatmessanger.ui.friends

import android.view.View
import com.example.chatmessanger.R
import com.example.chatmessanger.domain.friends.FriendEntity
import com.example.chatmessanger.ui.core.BaseAdapter
import com.example.chatmessanger.ui.core.GlideHelper
import kotlinx.android.synthetic.main.item_friend.view.*

open class FriendsAdapter : BaseAdapter<FriendsAdapter.FriendViewHolder>() {
    override val layoutRes = R.layout.item_friend

    override fun createHolder(view: View, viewType: Int): FriendViewHolder {
        return FriendViewHolder(view)
    }

    class FriendViewHolder(view: View) : BaseViewHolder(view) {

        init {
            view.btnRemove.setOnClickListener {
                onClick?.onClick(item, it)
            }
        }

        override fun onBind(item: Any) {
            (item as? FriendEntity)?.let {
                GlideHelper.loadImage(view.context, it.image, view.imgPhoto, R.drawable.ic_account_circle)
                view.tvName.text = it.name
                view.tvStatus.text = it.status

                view.tvStatus.visibility = if (it.status.isNotEmpty()) View.VISIBLE else View.GONE
            }
        }
    }
}