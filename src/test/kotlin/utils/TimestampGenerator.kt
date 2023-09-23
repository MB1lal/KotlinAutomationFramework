package utils


import org.jeasy.random.api.Randomizer
import org.joda.time.Instant


class TimestampGenerator : Randomizer<String> {
    fun getCurrentTime(): String  = Instant.now().toString()

    override fun getRandomValue(): String = Instant.now().toString()

}