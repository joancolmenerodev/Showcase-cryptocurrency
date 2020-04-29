package com.joancolmenerodev.feature.crypto_list.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joancolmenerodev.feature.crypto_list.R
import com.joancolmenerodev.feature.crypto_list.domain.model.Crypto

class CryptoListAdapter(private val cryptoList: List<Crypto>, private val onItemClick: (cryptoId: Int) -> Unit) :
    RecyclerView.Adapter<CoinListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CoinListViewHolder {
        return CoinListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.crypto_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        holder.bind(cryptoList[position], onItemClick)
    }

}

class CoinListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cryptoName: TextView = itemView.findViewById(R.id.item_crypto_name)
    private val cryptoSymbol: TextView = itemView.findViewById(R.id.item_crypto_symbol)
    private val moreInfo: Button = itemView.findViewById(R.id.btn_more_info)

    fun bind(
        cryptoItem: Crypto,
        onItemClick: (cryptoId: Int) -> Unit
    ) {
        cryptoName.text = cryptoItem.name
        cryptoSymbol.text = cryptoItem.symbol
        moreInfo.setOnClickListener { onItemClick.invoke(cryptoItem.id) }
    }
}