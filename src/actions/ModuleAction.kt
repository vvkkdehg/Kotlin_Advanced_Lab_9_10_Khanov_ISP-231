package actions

import resources.ResourseManager

interface ModuleAction {
    fun execute(manager: ResourseManager)
}