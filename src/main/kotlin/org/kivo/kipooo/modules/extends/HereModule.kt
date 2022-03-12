package org.kivo.kipooo.modules.extends

import org.bukkit.Bukkit
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.kivo.kipooo.Kipooo
import org.kivo.kipooo.modules.EssentialModules
import org.kivo.kipooo.modules.UsageModules
import taboolib.common.platform.event.SubscribeEvent

class HereModule : EssentialModules , UsageModules {

    override var moduleName: String = "here"

    @SubscribeEvent
    fun onChat(event : AsyncPlayerChatEvent) {
        if (event.message == getUsage() && isEnabled()) {
            Bukkit.broadcastMessage(Kipooo.toColor(getMessage()))
        }
    }
}