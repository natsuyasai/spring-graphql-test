package com.example.springgraphqltest.repository

import com.example.springgraphqltest.datamodel.Book
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class BookRepository {
    companion object {
        private val books = listOf(
            Book("book-1", "Effective Java", 416, "author-1"),
            Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            Book("book-3", "Down Under", 436, "author-3")
        )
    }

    fun getById(id: String): Book? {
        return books.stream()
            .filter { book: Book? -> book!!.id == id }
            .findFirst()
            .orElse(null)
    }
}
