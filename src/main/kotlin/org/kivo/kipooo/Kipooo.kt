package org.kivo.kipooo

import org.bukkit.ChatColor
import taboolib.common.io.newFile
import taboolib.common.platform.Plugin
import taboolib.common.platform.function.getDataFolder
import taboolib.common.platform.function.info
import taboolib.common.platform.function.releaseResourceFile
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigFile
import taboolib.module.configuration.Configuration
import taboolib.module.configuration.Type
import java.io.File

object Kipooo : Plugin() {

    private lateinit var settingFile : File
    private lateinit var langFile : File

    @Config
    lateinit var setting : ConfigFile
    @Config
    lateinit var lang : ConfigFile

    override fun onLoad() {
        settingFile = newFile(getDataFolder() , "setting.yml")
        if (!settingFile.exists()) {
            info("配置文件不存在，正在从JAR包中提取.")
            releaseResourceFile("setting.yml" , true)
        }
        setting = Configuration.loadFromFile(settingFile , Type.YAML)
        info("配置文件加载成功.")

        langFile = newFile(getDataFolder() , "lang.yml")
        if (!langFile.exists()) {
            info("语言文件不存在，正在从JAR包中提取.")
            releaseResourceFile("lang.yml" , true)
        }
        lang = Configuration.loadFromFile(langFile , Type.YAML)
        info("语言文件加载成功.")
    }

    override fun onEnable() {
        info("成功加载Kipooo")
    }

    override fun onDisable() {
        info("成功卸载Kipooo")
    }

    /**
     * 返回配置文件
     * @param fileName 配置文件的名字
     * @return 配置文件
     */
    fun getYaml(fileName : String) : ConfigFile? {
        if (fileName == "setting") {
            return setting
        }
        if (fileName == "lang") {
            return lang
        }
        return null
    }

    /**
     * 转换为颜色字符
     * @param text 传入的参数
     * @return 返回带有颜色的文本
     */
    fun toColor(text: String?) : String {
        return ChatColor.translateAlternateColorCodes('&' , text)
    }
}