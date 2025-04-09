package com.knbrgns.nutriscoreapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.knbrgns.nutriscoreapp.R
import com.knbrgns.nutriscoreapp.databinding.FragmentWelcomePageBinding

class WelcomePageFragment : Fragment() {
    private var _binding: FragmentWelcomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            btnLoginNavigate()
        }

        binding.btnSignup.setOnClickListener {
            btnSignUpNavigate()
        }

        binding.btnGuestLogin.setOnClickListener{
            btnGuestLoginNavigate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun btnLoginNavigate(){
        findNavController().navigate(R.id.action_welcomePageFragment_to_signInPageFragment)
    }

    private fun btnSignUpNavigate(){
        findNavController().navigate(R.id.action_welcomePageFragment_to_signUpPageFragment)
    }

    private fun btnGuestLoginNavigate(){
        findNavController().navigate(R.id.action_welcomePageFragment_to_placeholder)
    }

}