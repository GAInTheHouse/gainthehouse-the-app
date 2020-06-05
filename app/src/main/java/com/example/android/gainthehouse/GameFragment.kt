package com.example.android.gainthehouse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.gainthehouse.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
                inflater, R.layout.fragment_game, container, false)

        // Bind this fragment class to the layout
        binding.game = this

        val imageViewList: List<ImageView> =
            listOf(binding.card1,binding.card2,binding.card3,
                binding.card4,binding.card5,binding.card6,
                binding.card7,binding.card8,binding.card9,
                binding.card10,binding.card11,binding.card12) // and so on

        var selected: Int =-1
        var score: Int=0
        val numbers = mutableListOf(-1)
        for (i in 0..imageViewList.size-1) {
            imageViewList[i].setOnClickListener{
                if(i==0 || i==1)
                imageViewList[i].setImageResource(R.drawable.colour1)
                if(i==2 || i==3)
                    imageViewList[i].setImageResource(R.drawable.colour2)
                if(i==4|| i==5)
                    imageViewList[i].setImageResource(R.drawable.colour3)
                if(i==6 || i==7)
                    imageViewList[i].setImageResource(R.drawable.colour4)
                if(i==8 || i==9)
                    imageViewList[i].setImageResource(R.drawable.colour5)
                if(i==10 || i==11)
                    imageViewList[i].setImageResource(R.drawable.colour6)
                if(selected!=i || !numbers.contains(i) || !numbers.contains(selected)) {
                    if (selected != -1) {
                         if((selected%2==0 && i==selected+1) ||(selected%2==1 && i==selected-1)) {
                             score++
                             numbers.add(i)
                             numbers.add(selected)
                         }

                         else{
                             imageViewList[i].setImageResource(R.drawable.card_bg)
                             imageViewList[selected].setImageResource(R.drawable.card_bg)
                         }
                          selected=-1
                    } else {
                        selected = i
                    }
                }
                if(score==6)
                    view?.findNavController()
                        ?.navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(3,1))

            }
        }
        return binding.root
    }
}