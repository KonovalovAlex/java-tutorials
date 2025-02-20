package tutorials

import java.time.LocalDate

enum class CarEngineStatus { TurnedOn, TurnedOff, AutoStart }

enum class CarEngineOilStatus { Low, Normal }

interface CarEngine {

    fun model(): String

    fun manufacturedAt(): LocalDate

    fun oilPressure(): CarEngineOilStatus

    fun status(): CarEngineStatus

    fun temperatureF(): Int

    fun nextMaintenanceDate(): LocalDate
}

interface EngineStatusChecker : CarEngine {
    override fun status(): CarEngineStatus
}

abstract class AbstractEngineStatusCheck: EngineStatusChecker {
    override fun status(): CarEngineStatus {
        val engineStatusCheck = EngineStatusCheck()
        return engineStatusCheck.status()
    }

    override fun model(): String {
        TODO("Not yet implemented")
    }

    override fun manufacturedAt(): LocalDate {
        TODO("Not yet implemented")
    }

    override fun oilPressure(): CarEngineOilStatus {
        TODO("Not yet implemented")
    }

    override fun temperatureF(): Int {
        TODO("Not yet implemented")
    }

    override fun nextMaintenanceDate(): LocalDate {
        TODO("Not yet implemented")
    }
}

class EngineStatusCheck : AbstractEngineStatusCheck() {

    val normalTempInterval = Pair(1000, 10000)

    override fun status(): CarEngineStatus {
        return CarEngineStatus.TurnedOn
    }

//    fun check(): Boolean {
//        engine.status()
//        TODO("Check engine min max temperature")
//        TODO("Check engine oil pressure")
//        TODO("Check time passed after last maintenance")
//
//        TODO("More checks")
//    }
}