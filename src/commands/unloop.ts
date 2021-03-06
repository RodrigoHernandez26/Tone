import {Command} from "./command";
import {CommandInteraction, GuildMember, Message} from "discord.js";
import MusicCommand from "./musicCommand";
import SucessEmbed from "../embeds/sucessEmbed";
import { CommandPropertiesInterface } from "../interfaces/CommandProperties.interface";

export default class Unloop extends MusicCommand implements Command {

    static properties: CommandPropertiesInterface = {
        name: 'unloop',
        description: 'unloop the song',
        aliases: ['unloop']
    }

    execute(message: Message | CommandInteraction) {
        if(message.member instanceof GuildMember){
            this.musicController.unloop(message);
            message.reply({embeds:[SucessEmbed.create("Unlooped").build()]});
        }
    }
}
