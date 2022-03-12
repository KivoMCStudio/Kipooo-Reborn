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
            info("�����ļ������ڣ����ڴ�JAR������ȡ.")
            releaseResourceFile("setting.yml" , true)
        }
        setting = Configuration.loadFromFile(settingFile , Type.YAML)
        info("�����ļ����سɹ�.")

        langFile = newFile(getDataFolder() , "lang.yml")
        if (!langFile.exists()) {
            info("�����ļ������ڣ����ڴ�JAR������ȡ.")
            releaseResourceFile("lang.yml" , true)
        }
        lang = Configuration.loadFromFile(langFile , Type.YAML)
        info("�����ļ����سɹ�.")
    }

    override fun onEnable() {
        info("�ɹ�����Kipooo")
    }

    override fun onDisable() {
        info("�ɹ�ж��Kipooo")
    }

    /**
     * ���������ļ�
     * @param fileName �����ļ�������
     * @return �����ļ�
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
     * ת��Ϊ��ɫ�ַ�
     * @param text ����Ĳ���
     * @return ���ش�����ɫ���ı�
     */
    fun toColor(text: String?) : String {
        return ChatColor.translateAlternateColorCodes('&' , text)
    }
}