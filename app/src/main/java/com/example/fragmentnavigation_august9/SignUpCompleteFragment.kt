package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentnavigation_august9.databinding.FragmentSignUpCompleteBinding
import com.example.fragmentnavigation_august9.viewModel.UserViewModel

class SignUpCompleteFragment : Fragment() {

    private var _binding: FragmentSignUpCompleteBinding? = null
    private val binding: FragmentSignUpCompleteBinding get() = _binding!!
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpCompleteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        with(binding) {

            viewModel.users.observe(viewLifecycleOwner) { users ->
                // .apply allows you to modify multiple fields of an object
                userRv.apply {
                    adapter = UserAdapter(users)
                    // Tells reyclerview orientation
                    layoutManager =
                        LinearLayoutManager(this@SignUpCompleteFragment, LinearLayoutManager.VERTICAL, false)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}