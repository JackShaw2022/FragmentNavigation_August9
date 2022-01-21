package com.example.fragmentnavigation_august9.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentnavigation_august9.data.User
import com.example.fragmentnavigation_august9.data.UserEmail
import com.example.fragmentnavigation_august9.data.UserName
import com.example.fragmentnavigation_august9.data.UserPassword
import com.example.fragmentnavigation_august9.databinding.UserItemBinding

class UserAdapter(
    private val userList: List<User>,
    private val userNameList: List<UserName>,
    private val userEmailList: List<UserEmail>,
    private val userPasswordList: List<UserPassword>
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // Inflating ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    // size of item
    override fun getItemCount(): Int {
        return userList.size
    }

    // Attaches data to xml of our item.
    class UserViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {
                nameTv.text = user.userName.toString()
            }
        }
    }
}
