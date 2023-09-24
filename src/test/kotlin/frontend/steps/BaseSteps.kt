package frontend.steps

import backend.steps.BaseSteps
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

abstract class BaseSteps {
    protected val logger: Logger = LogManager.getLogger(BaseSteps::class.java)
}