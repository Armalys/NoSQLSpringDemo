package ge.me.nosqlspringdemo.repository

import ge.me.nosqlspringdemo.model.Aircraft
import org.springframework.data.repository.CrudRepository

interface AircraftRepository : CrudRepository<Aircraft, String>