package main.kotlin

/*
 * Refactor the following controller to make it more concise.
 */

object RestController {

    fun getVehicle(
        region: String,
        environment: String,
        vin: String
    ): Vehicle {
        val client = getClient(region, environment)
        return try {
            client.getVehicle(vin)
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }

    fun postVehicle(
        region: String,
        environment: String,
        vin: String
    ): String {
        val client = getClient(region, environment)
        return try {
            client.postVehicle(vin)
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }

    fun deleteVehicle(
        region: String,
        environment: String,
        vin: String
    ): Int {
        val client = getClient(region, environment)
        return try {
            client.deleteVehicle(vin)
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }

    private fun getClient(
        region: String,
        environment: String
    ): Client {
        // maybe add some caching
        return Client(region, environment)
    }
}

class Client(val region: String, val environment: String) {
    fun getVehicle(vin: String): Vehicle {
        return Vehicle()
    }

    fun postVehicle(vin: String): String {
        return "OK"
    }

    fun deleteVehicle(vin: String): Int {
        return 1
    }
}

class Vehicle
