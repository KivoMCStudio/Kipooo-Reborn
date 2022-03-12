package org.kivo.kipooo.modules

import org.kivo.kipooo.Kipooo

interface EssentialModules{

    var moduleName : String

    fun modulesName() : String? {
        return Kipooo.getYaml("setting")?.getString("modules.$moduleName")
    }

    fun isEnabled() : Boolean {
        return Kipooo.getYaml("setting")?.isBoolean(modulesName() + ".enabled")!!
    }

    fun getDesc() : String? {
        return Kipooo.getYaml("setting")?.getString(modulesName() + ".desc")
    }
}