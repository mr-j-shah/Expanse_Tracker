package com.crestinfosystems_jinay.expancetracker.data

import kotlinx.coroutines.flow.Flow

class ExpanseRepo(private val expanseDAO: ExpanseDAO) {

    suspend fun addExpanse(expanse: Expanse) {
        expanseDAO.addExpanse(expanse)
    }

    fun getAllExpanse() : Flow<List<Expanse>> = expanseDAO.getAllExpanse()

    fun getExpanse(id:Long):Flow<Expanse>{
        return  expanseDAO.getAExpanseById(id)
    }

    suspend fun deleteExpanse(expanse: Expanse){
        expanseDAO.deleteExpanse(expanse)
    }

    suspend fun updateExpanse(expanse: Expanse){
        expanseDAO.updateAExpanse(expanse)
    }
}