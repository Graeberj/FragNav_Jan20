package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentnavigation_august9.SignUpCompleteFragmentDirections.*
import com.example.fragmentnavigation_august9.databinding.FragmentSignUpCompleteBinding
import com.example.userrecyclerview_jan10.UserAdapter

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
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        with(binding) {
            viewModel.users.observe(viewLifecycleOwner){users ->
                userListRv.apply {
                    adapter = UserAdapter(users)
                    layoutManager = LinearLayoutManager(, LinearLayoutManager.VERTICAL, true )

                }
            }
            returnBtn.setOnClickListener {
                val direction = actionSignUpCompleteFragmentToFirstNameFragment()
                findNavController().navigate(direction)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


