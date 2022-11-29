package ge.me.nosqlspringdemo.service

import ge.me.nosqlspringdemo.model.Aircraft
import ge.me.nosqlspringdemo.repository.AircraftRepository
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@Component
@EnableScheduling
class PlaneFinderPoller(private val repository: AircraftRepository) {

    private val client = WebClient.create("http://somehost")

    @Scheduled(fixedRate = 1000)
    private fun pollPlanes() {
        repository.deleteAll()

//        client.get()
//            .retrieve()
//            .bodyToFlux<Aircraft>()
//            .filter { !it.reg.isNullOrEmpty() }
//            .toStream()
//            .forEach { repository.save(it) }

        println("--- All aircraft ---")
        repository.findAll().forEach { println(it) }
    }
}