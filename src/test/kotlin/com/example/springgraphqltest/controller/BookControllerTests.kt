package com.example.springgraphqltest.controller

import com.example.springgraphqltest.SpringGraphqlTestApplication
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.graphql.test.tester.GraphQlTester
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener

// 動いていない
@GraphQlTest(BookController::class)
class BookControllerTests {
    @Autowired
    private val graphQlTester: GraphQlTester? = null
    @Test
    fun shouldGetFirstBook() {
        graphQlTester
            ?.documentName("bookDetails")
            ?.variable("id", "book-1")
            ?.execute()
            ?.path("bookById")
            ?.matchesJson(
                """
                    {
                        "id": "book-1",
                        "name": "Effective Java",
                        "pageCount": 416,
                        "author": {
                          "firstName": "Joshua",
                          "lastName": "Bloch"
                        }
                    }
                
                """.trimIndent()
            )
    }
}
