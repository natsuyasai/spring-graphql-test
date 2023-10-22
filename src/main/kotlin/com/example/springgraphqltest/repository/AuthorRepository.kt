package com.example.springgraphqltest.repository

import com.example.springgraphqltest.datamodel.Author
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class AuthorRepository {
    companion object {
        private val authors = listOf(
            Author("author-1", "Joshua", "Bloch"),
            Author("author-2", "Douglas", "Adams"),
            Author("author-3", "Bill", "Bryson")
        )
    }

    fun getById(id: String): Author? {
        return authors.stream()
            .filter { author: Author? -> author!!.id == id }
            .findFirst()
            .orElse(null)
    }
}
