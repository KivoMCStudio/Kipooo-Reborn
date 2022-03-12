package org.kivo.kipooo.modules

import org.kivo.kipooo.Kipooo

interface UsageModules : EssentialModules {

    fun getUsage() : String? {
        return Kipooo.getYaml("setting")?.getString(modulesName() + ".usage")
    }

    fun getMessage() : String? {
        return Kipooo.getYaml("setting")?.getString(modulesName() + ".message")
    }

}