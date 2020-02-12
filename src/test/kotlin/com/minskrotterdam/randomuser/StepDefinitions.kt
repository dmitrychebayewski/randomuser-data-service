package com.minskrotterdam.randomuser

import com.minskrotterdam.randomuser.model.UserData
import io.cucumber.java8.En
import org.junit.Assert
import org.junit.Ignore
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestTemplate

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
class StepDefinitions : En {
    private val url = "http://localhost"
    private val endpoint = "/randomuser"
    private val restTemplate: RestTemplate = RestTemplate()
    @LocalServerPort
    protected var port = 0

    private fun endpoint(): String {
        return "$url:$port$endpoint"
    }

    private val contents: UserData
        get() = restTemplate.getForObject(endpoint(), UserData::class.java)!!

    init {
        Given(
                "I get valid response from getRandomUser"
        ) { Assert.assertNotNull(contents.results[0].name) }
    }
}