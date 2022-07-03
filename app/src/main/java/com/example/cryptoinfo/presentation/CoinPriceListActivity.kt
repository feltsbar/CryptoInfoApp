package com.example.cryptoinfo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoinfo.R
import com.example.cryptoinfo.databinding.ActivityCoinPriceListBinding
import com.example.cryptoinfo.domain.CoinInfo
import com.example.cryptoinfo.presentation.adapters.CoinInfoAdapter

class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    private val binding by lazy {
        ActivityCoinPriceListBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = CoinInfoAdapter(this)
        binding.rvCoinPriceList.adapter = adapter
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinPriceInfo.fromSymbol
                )
                startActivity(intent)
            }
        }
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(this) {
            adapter.coinInfoList = it
        }
    }

}