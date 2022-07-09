package com.example.cryptoinfo.domain

class LoadDataUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke() = repository.loadData()
}