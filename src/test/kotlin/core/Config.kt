package core

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration
import net.thucydides.model.environment.SystemEnvironmentVariables
import net.thucydides.model.util.EnvironmentVariables

open class Config {
    companion object {
        val environmentVariables: EnvironmentVariables = SystemEnvironmentVariables.createEnvironmentVariables()
        fun getConfigValue(key: String?): String {
            return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(key)
        }
    }
}