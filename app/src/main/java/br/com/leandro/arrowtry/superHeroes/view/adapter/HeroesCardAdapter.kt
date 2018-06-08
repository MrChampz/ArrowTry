package br.com.leandro.arrowtry.superHeroes.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.leandro.arrowtry.R
import br.com.leandro.arrowtry.superHeroes.view.viewmodel.SuperHeroViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero_card.view.*

class HeroesCardAdapter(
        private val characters: List<SuperHeroViewModel>,
        private val itemClick: (SuperHeroViewModel) -> Unit) : RecyclerView.Adapter<HeroesCardAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, pos: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero_card, parent, false)
      return ViewHolder(view, itemClick)
  }

  override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
      holder.bind(characters[pos])
  }

  override fun getItemCount() = characters.size

  class ViewHolder(view: View, private val itemClick: (SuperHeroViewModel) -> Unit) : RecyclerView.ViewHolder(view) {
      fun bind(hero: SuperHeroViewModel) {
          with(hero) {
              Picasso.with(itemView.context).load(photoUrl).into(itemView.picture)
              itemView.setOnClickListener { itemClick(this) }
          }
      }
  }
}
