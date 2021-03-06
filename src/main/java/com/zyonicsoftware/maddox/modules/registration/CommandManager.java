/*
 * Zyonic Software - 2020 - Tobias Rempe
 * This File, its contents and by extention the corresponding project may be used freely in compliance with the Apache 2.0 License.
 *
 * tobiasrempe@zyonicsoftware.com
 */

/*
 * Zyonic Software - 2020 - Tobias Rempe
 * This File, its contents and by extention the corresponding project may be used freely in compliance with the Apache 2.0 License.
 *
 * tobiasrempe@zyonicsoftware.com
 */

package com.zyonicsoftware.maddox.modules.registration;

import com.zyonicsoftware.maddox.core.engine.handling.command.CommandHandler;
import com.zyonicsoftware.maddox.core.main.Maddox;
import com.zyonicsoftware.maddox.modules.command.information.BotInfoCommand;
import com.zyonicsoftware.maddox.modules.command.information.HelpCommand;
import com.zyonicsoftware.maddox.modules.command.moderation.BanCommand;
import com.zyonicsoftware.maddox.modules.command.moderation.ClearCommand;
import com.zyonicsoftware.maddox.modules.command.moderation.KickCommand;
import com.zyonicsoftware.maddox.modules.command.moderation.UnBanCommand;
import com.zyonicsoftware.maddox.modules.command.settings.messages.JoinMessageCommand;
import com.zyonicsoftware.maddox.modules.command.settings.messages.LanguageCommand;
import com.zyonicsoftware.maddox.modules.command.settings.messages.LeaveMessageCommand;
import com.zyonicsoftware.maddox.modules.command.settings.messages.PrivateJoinMessageCommand;
import com.zyonicsoftware.maddox.modules.command.settings.system.AutoRoleCommand;
import com.zyonicsoftware.maddox.modules.command.settings.system.SetPrefixCommand;
import com.zyonicsoftware.maddox.modules.command.settings.system.ToggleCommand;
import com.zyonicsoftware.maddox.modules.command.sysadmin.ForceAddCommand;

public class CommandManager {

    private final Maddox maddox;

    public CommandManager(final Maddox maddox) {
        this.maddox = maddox;
    }

    public void registerCommands(final CommandHandler commandHandler) {

        commandHandler.registerCommands(
                //Sys-Admin
                new ForceAddCommand(this.maddox),
                //Guild-Admin
                new LanguageCommand(this.maddox),
                new SetPrefixCommand(),
                new AutoRoleCommand(this.maddox),
                new JoinMessageCommand(this.maddox),
                new LeaveMessageCommand(this.maddox),
                new ToggleCommand(this.maddox),
                //Moderation
                new KickCommand(this.maddox),
                new BanCommand(this.maddox),
                new UnBanCommand(this.maddox),
                new PrivateJoinMessageCommand(this.maddox),
                new ClearCommand(),
                //Normal
                ///Information
                new HelpCommand(this.maddox),
                new BotInfoCommand(this.maddox)
                //Add further commands here
        );
    }


}
