package com.example.chatmessanger.ui.user

import android.os.Bundle
import android.view.View
import com.example.chatmessanger.R
import com.example.chatmessanger.remote.service.ApiService
import com.example.chatmessanger.ui.core.BaseFragment
import com.example.chatmessanger.ui.core.GlideHelper
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.item_friend.imgPhoto
import kotlinx.android.synthetic.main.item_friend.tvName
import kotlinx.android.synthetic.main.item_friend.tvStatus

class UserFragment : BaseFragment() {
    override val layoutId = R.layout.fragment_user

    override val titleToolbar = R.string.screen_user

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        base {
            val args = intent.getBundleExtra("args")
            if (args != null) {
                val image = args.getString(ApiService.PARAM_IMAGE)
                val name = args.getString(ApiService.PARAM_NAME)
                val email = args.getString(ApiService.PARAM_EMAIL)
                val status = args.getString(ApiService.PARAM_STATUS)

                GlideHelper.loadImage(requireContext(), image, imgPhoto, R.drawable.ic_account_circle)

                tvName.text = name
                tvEmail.text = email
                tvStatus.text = status

                if (tvStatus.text.isEmpty()) {
                    tvStatus.visibility = View.GONE
                    tvHintStatus.visibility = View.GONE
                }
            }
        }
    }
}